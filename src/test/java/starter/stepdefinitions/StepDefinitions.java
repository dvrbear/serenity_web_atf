package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefinitions extends BaseSteps {

    @When("opens main page")
    public void openShopPage() {
        initDriver("https://seat.orange.md/");
        System.out.println("*********************************************");
        System.out.println(driver.toString());
        System.out.println("*********************************************");
    }

    @Then("debug step")
    public void debugStep() {
        System.out.println("debug step");
    }

}
