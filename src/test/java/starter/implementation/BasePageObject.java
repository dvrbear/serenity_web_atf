package starter.implementation;

import de.taimos.totp.TOTP;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import starter.utils.Const;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static starter.utils.Const.FREE_PLACE_SEARCH_PATTERN;
import static starter.utils.Const.LONG_TIMEOUT;

public class BasePageObject extends PageObject {

    public WebDriver driver;
    private WebDriverWait wait;

    public BasePageObject() {
        driver = Serenity.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, LONG_TIMEOUT);
        System.out.println("*********************************************");
        System.out.println(driver.toString());
        System.out.println("*********************************************");
    }

    public void gotoURL(String url){
        driver.get(url);
    }

    public void initDriver(String baseURL) {
        driver = Serenity.getDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, LONG_TIMEOUT);
    }

    public void click(String xpath) {
        try {
            WebElement element = getElement(xpath);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            sleep(1);
            element.click();
        } catch (Exception e) {
            locatorNotFound(xpath);
        }
    }

    public void actionClick(String xpath) {
        actionClick(getElement(xpath));
    }

    public void actionClick(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element)
                .click()
                .build()
                .perform();
    }

    public void input(String text, String xpath) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).sendKeys(text);
        } catch (Exception e) {
            locatorNotFound(xpath);
        }
    }

    public void hover(String xpath) {
        try {
            WebElement element = getElement(xpath);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.perform();
        } catch (Exception e) {
            locatorNotFound(xpath);
        }
    }

    public void scroll(String xpath) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(xpath));
        } catch (Exception e) {
            locatorNotFound(xpath);
        }
    }

    public void clickOnFreePLace(String place) {
        String placeXpath = String.format(Const.FREE_PLACE_PATTERN, place);
        if (isPlaceFree(placeXpath)) {
            actionClick(placeXpath);
        } else {
            failWithMessage(String.format(Const.MESSAGE_PLACE_BUSY, place));
        }
    }

    public List<WebElement> getAllFreePlaces() {
        return driver.findElements(By.xpath(FREE_PLACE_SEARCH_PATTERN));
    }

    public void saveValue(String key, Object value) {
        Serenity.setSessionVariable(key).to(value);
    }

    public Object loadValue(String key) {
        return Serenity.sessionVariableCalled(key);
    }

    public static String otp(String secretKey) {
        Base32 base32 = new Base32();
        byte[] bytes = base32.decode(secretKey);
        String hexKey = Hex.encodeHexString(bytes);
        return TOTP.getOTP(hexKey);
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (Exception e) {
            failWithMessage("Insomnia");
        }
    }

    private boolean isPlaceFree(String placeXpath) {
        return driver.findElements(By.xpath(placeXpath)).size() > 0;
    }

    private WebElement getElement(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    private void locatorNotFound(String xpath) {
        failWithMessage(String.format("Locator was not found: [%s]", xpath));
    }

    private void failWithMessage(String message) {
        Assert.fail("> > > > > > > " + message);
    }
}
