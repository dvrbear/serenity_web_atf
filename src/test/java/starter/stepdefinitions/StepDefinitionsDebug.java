package starter.stepdefinitions;

import io.cucumber.java.en.Then;


public class StepDefinitionsDebug extends BaseSteps {

    @Then("debug step")
    public void debugStep() {
        System.out.println("debug step");
    }

}
