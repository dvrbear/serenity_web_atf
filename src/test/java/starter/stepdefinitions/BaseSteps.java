package starter.stepdefinitions;

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

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static starter.utils.Const.FREE_PLACE_SEARCH_PATTERN;

public class BaseSteps extends PageObject {
    public final int SHORT_TIMEOUT = 10;
    public final int MEDIUM_TIMEOUT = 15;
    public final int LONG_TIMEOUT = 20;

    public WebDriver driver;
    private WebDriverWait wait;

    public static String auth (String secretKey) {
        Base32 base32 = new Base32();
        byte[] bytes = base32.decode(secretKey);
        String hexKey = Hex.encodeHexString(bytes);
        return TOTP.getOTP(hexKey);
    }

    public void initDriver(String baseURL) {
        driver = Serenity.getDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(baseURL);
        wait = new WebDriverWait(driver, LONG_TIMEOUT);
    }

    public void click(String xpath) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
        } catch (Exception e) {
            locatorNotFound(xpath);
        }
    }

    public void actionClick(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        actionClick(element);
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
            WebElement element = driver.findElement(By.xpath(xpath));
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
            WebElement element = driver.findElement(By.xpath(xpath));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(500);
        } catch (Exception e) {
            locatorNotFound(xpath);
        }
    }

    public String getClipboard() {
        Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable t = c.getContents(this);
        String a;
        try {
            a = (String) t.getTransferData(DataFlavor.stringFlavor);
            return a;
        } catch (UnsupportedFlavorException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickOnFreePLace(String place) {
        String placeXpath = String.format(Const.FREE_PLACE_PATTERN, place);
        if (isPlaceFree(placeXpath)) {
            actionClick(placeXpath);
        }else {
            failWithMessage(String.format(Const.MESSAGE_PLACE_BUSY, place));
        }
    }

    public List<WebElement> getAllFreePlaces(){
        return driver.findElements(By.xpath(FREE_PLACE_SEARCH_PATTERN));
    }

    private boolean isPlaceFree(String placeXpath) {
        return driver.findElements(By.xpath(placeXpath)).size() > 0;
    }

    public void saveValue(String key, Object value) {
        Serenity.setSessionVariable(key).to(value);
    }

    public Object loadValue(String key) {
        return Serenity.sessionVariableCalled(key);
    }

    public static String otp (String secretKey) {
        Base32 base32 = new Base32();
        byte[] bytes = base32.decode(secretKey);
        String hexKey = Hex.encodeHexString(bytes);
        return TOTP.getOTP(hexKey);
    }

    private void locatorNotFound(String xpath) {
        failWithMessage(String.format("Locator was not found: [%s]", xpath));
    }

    private void failWithMessage(String message) {
        Assert.fail("> > > > > > > " + message);
    }
}
