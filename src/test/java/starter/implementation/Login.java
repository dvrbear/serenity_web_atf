package starter.implementation;

import static starter.utils.ConstXpath.*;
import static starter.utils.Creds.*;

public class Login extends BasePageObject {


    public void insertCreds() {
        input(USER_NAME, USERNAME_XP);
        input(USER_PASSWORD, PASSWORD_XP);
        click(LOGIN_BTN_XP);
    }

    public void insertOTP() {
        input(otp(USER_AUTH_KEY), OTP_XP);
        click(SIGNIN_XP);
    }
//
    public void goToBooking() {
        click(EXPAND_NAVBAR_XP);
        click(MENU_ICON_MAP_XP);
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
//
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
