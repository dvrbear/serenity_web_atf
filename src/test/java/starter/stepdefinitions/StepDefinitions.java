package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefinitions extends BaseSteps {

//    xpaths used in test
    String user_x = "//*[@id=\"username\"]";
    String pass_x = "//*[@id=\"password\"]/input";
    String login_x = "//*[@id=\"kc-login\"]";
    String token_x = "//*[@id=\"otp\"]";
    String signin_x = "//*[@id=\"log-in\"]/div[2]/form/input";
    String booking_x = "//*[@id=\"root\"]/div[1]/div/div/div/div/ul/div[2]/div/span";
    String workplace_x = "//*[@id=\"root\"]/div[1]/div/div/div/div/ul/div[3]/div/div/div/div[1]/div/div/span";
    String ztower_x = "//*[@id=\"root\"]/div[1]/div/main/div/div/div/div/div[2]/div[2]/div/div[2]/div";
    String kitchen_x = "//*[@id=\"root\"]/div[1]/div/main/div/div/div[2]/div/div/div/div";
    String date_x = "//*[@id=\"booking\"]/div[3]/div[3]/div[2]/div/div[2]/div/div[2]/div/span[35]";
    String place_x = "//*[@class='rect-place work-place'][@transform='translate(1458.26 2567)']";

    @When("opens main page")
    public void openShopPage() {
        initDriver("https://seat.orange.md/");
        System.out.println("*********************************************");
        System.out.println(driver.toString());
        System.out.println("*********************************************");
    }

    @When ("introduce username and pass")
    public void readFile() {
        input("vpihut", user_x);
        input("Batman1903", pass_x);
    }

    @When("press login button")
    public void loginButt(){
        click(login_x);
    }

    @When("inserts token")
    public void insertToken(){
        input(getClipboard(), token_x);
    }

    @When("sign in seat")
    public void signIn(){
        click(signin_x);
    }

    @When("go to booking")
    public void goToBooking(){
        click(booking_x);
    }
    @When("open workplaces")
    public void openWorkspaces(){
        click(workplace_x);
    }

    @When("select ZTower")
    public void selectZTower(){
        click(ztower_x);
    }

    @When("select Kitchen")
    public void selectKitchen(){
        click(kitchen_x);
    }

    @When("select date")
    public void selectDate(){
        click(date_x);
    }

    @When("select place {}")
    public void selectPlace(String place){
        clickOnFreePLace(place);
    }

    @Then("debug step")
    public void debugStep(){
        System.out.println("debug step");
    }

}
