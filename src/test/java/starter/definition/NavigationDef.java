package starter.definition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.implementation.Navigation;

public class NavigationDef {

    private Navigation navigation;

    @When("navigate to office : {}")
    public void navigateToOffice(String officeId) {
        navigation.navigateToOffice(officeId);
    }

    @When("sleep : {} seconds")
    public void sleep(String sec) {
        navigation.sleep(Integer.parseInt(sec));
    }

    @Then("debug step")
    public void debugStep() {
        System.out.println("debug step");
    }

}
