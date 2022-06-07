package starter.definition;

import io.cucumber.java.en.When;
import starter.implementation.Login;

public class LoginDef {

    private Login login;

    @When("opens main page")
    public void openShopPage() {
        login.gotoURL("https://senseit-test.orange.md/");
    }

    @When("introduce username and pass")
    public void insertCreds() {
        login.insertCreds();
    }

    @When("inserts OTP")
    public void insertOTP() {
        login.insertOTP();
    }

    //
    @When("go to booking")
    public void goToBooking() {
        login.goToBooking();
    }
//
//    @When("open workplaces")
//    public void openWorkspaces() {
//        click(WORKPLACE_XP);
//    }
//
//    @When("select ZTower")
//    public void selectZTower() {
//        click(ZTOWER_XP);
//    }
//
//    @When("select Kitchen")
//    public void selectKitchen() {
//        click(KITCHEN_XP);
//    }
//
//    @When("submit booking")
//    public void submitBooking() {
//        click(BOOK_BTN_XP);
//        click(CLOSE_BTN_XP);
//    }
//
//    @When("cancel booking")
//    public void cancelBooking() {
//        click(CANCEL_BTN_XP);
//        click(YES_BTN_XP);
//        click(CLOSE_BTN_XP);
//    }
//
//    @When("select date")
//    public void selectDate() {
//        click(DATE_XP);
//    }
//s
//    @When("select place {}")
//    public void selectPlace(String place) {
//        clickOnFreePLace(place);
//    }
//
//    @When("select first free place")
//    public void selectFirstFreePlace() {
//        List<WebElement> list = getAllFreePlaces();
//        if (list.size() > 0) {
//            actionClick(getAllFreePlaces().get(0));
//        }
//    }

}
