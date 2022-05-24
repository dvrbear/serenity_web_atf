package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class OrangeStepDefinitions extends BaseSteps {

    @When("opens Orange")
    public void openShopPage() {
        initDriver("https://eshop.orange.md/ro");
        System.out.println("*********************************************");
        System.out.println(driver.toString());
        System.out.println("*********************************************");
    }


    @When("navigates to the phone selection")
    public void listAllPhones() {
        hover("//a[@data-scope='menu-sub']//span[.='Telefoane']");
        click("//a[@class='inner is-category']//div[contains(@class,'icon-device-smart-phone')]");
    }

    @When("selects the specific phone model: {}")
    public void selectPhoneFromList(String phoneModel) {
        String imgPhone = String.format("//img[@alt='%s']", phoneModel);
        String imgPhoneClick = String.format("//img[@alt='%s']/../../../div[@class='product-info-expanded']", phoneModel);
        scroll(imgPhone);
        hover(imgPhone);
        click(imgPhoneClick);
    }

    @When("proceed buying")
    public void buysPhone() {
        click("//button[contains(@class,'cta s-size productStartConfig')]");
    }

    @Then("orange debug step")
    public void debugStep() {
        System.out.println("debug step");
    }

}
