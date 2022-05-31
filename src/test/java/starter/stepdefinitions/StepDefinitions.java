package starter.stepdefinitions;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.util.List;

import static starter.utils.ConstXpath.*;
import static starter.utils.Creds.*;

public class StepDefinitions extends BaseSteps {


    @When("opens main page")
    public void openShopPage() {
        initDriver("https://senseit-test.orange.md/");
//        initDriver("https://seat.orange.md/");
        System.out.println("*********************************************");
        System.out.println(driver.toString());
        System.out.println("*********************************************");
    }

    @When("introduce username and pass")
    public void insertCreds() {
        input(USER_NAME, USERNAME_XPATH);
        input(USER_PASSWORD, PASSWORD_XPATH);
        click(LOGIN_BTN_XPATH);
    }

    @When("inserts OTP")
    public void insertOTP() {
        input(otp(USER_AUTH_KEY), OTP_XPATH);
        click(SIGNIN_XPATH);
    }

    @When("go to booking")
    public void goToBooking() {
        click(EXPAND_NAVBAR_XPATH);
        click(MAP_XPATH);
    }

    @When("open workplaces")
    public void openWorkspaces() {
        click(WORKPLACE_XPATH);
    }

    @When("select ZTower")
    public void selectZTower() {
        click(ZTOWER_XPATH);
    }

    @When("select Kitchen")
    public void selectKitchen() {
        click(KITCHEN_XPATH);
    }

    @When("submit booking")
    public void submitBooking() {
        click(BOOK_BTN_XPATH);
        click(CLOSE_BTN_XPATH);
    }

    @When("cancel booking")
    public void cancelBooking() {
        click(CANCEL_BTN_XPATH);
        click(YES_BTN_XPATH);
        click(CLOSE_BTN_XPATH);
    }

    @When("select date {}  {}")
    public void selectDate(String month, String dayOfMonth) throws ParseException {
        checkWhatMonth(month,dayOfMonth);
    }

    @When("select place {}")
    public void selectPlace(String place) {
        clickOnFreePLace(place);
    }

    @When("select first free place")
    public void selectFirstFreePlace() {
        List<WebElement> list = getAllFreePlaces();
        if (list.size() > 0) {
            actionClick(getAllFreePlaces().get(0));
        }
    }

}
