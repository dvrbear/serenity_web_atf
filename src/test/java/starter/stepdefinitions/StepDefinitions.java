package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.navigation.NavigateTo;
//import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;


public class StepDefinitions extends BaseSteps {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("{actor} opens the shop page")
    public void openShopPage(Actor actor) {
        actor.wasAbleTo(NavigateTo.homePage());
    }

    @When("{actor} navigates to the phone selection")
    public void listAllPhones(Actor actor) {
        assuredHover(actor, "//a[@data-scope='menu-sub']//span[.='Telefoane']");
        assuredClick(actor, "//a[@class='inner is-category']//div[contains(@class,'icon-device-smart-phone')]");
    }

    @When("{actor} selects the specific phone model: {}")
    public void selectPhoneFromList(Actor actor, String phoneModel) {
        String imgPhone = String.format("//img[@alt='%s']", phoneModel);
        assuredScroll(actor, imgPhone);
        assuredClick(actor, imgPhone);
    }

    @When("{actor} proceed buying")
    public void buysPhone(Actor actor) {
        assuredClick(actor, "//button[contains(@class,'cta s-size productStartConfig')]");
    }

    @When("{actor} chooses the shipping method: get from store")
    public void shippingMethod(Actor actor) {
        assuredInvisible(actor, "//div[contains(@class,'opopup-bg loading')]");
        assuredClick(actor, "//div[contains(@class,'no-livrare button')]");
    }

    @When("{actor} chooses store location")
    public void storeLocation(Actor actor) {
        String btnOnlyDevice = "//div[contains(@class,'b_acc_selector button-tag  bold sell-standalone-button p_std_bg_1 clear-flow-ctrl')]";
        assuredClick(actor, "//span[@aria-labelledby='select2-pickup-list-locality-container']//b[@role='presentation']");
        assuredSelect(actor, "Chișinău", "//input[contains(@class,'select2-search__field')]");
        assuredClick(actor, "//span[@aria-labelledby='select2-pickup-list-shop-container']//b[@role='presentation']");
        assuredSelect(actor, "Orange Centru", "//input[contains(@class,'select2-search__field')]");
        assuredScroll(actor, btnOnlyDevice);
        assuredClick(actor, btnOnlyDevice);
    }

    @When("{actor} proceed ordering")
    public void submitOrder(Actor actor) {
        String btnSubmit = "//button[contains(@class,'cta')]";
        assuredScroll(actor, btnSubmit);
        assuredClick(actor, btnSubmit);
    }

    @When("{actor} enters personal information")
    public void personalInformation(Actor actor) {
        String btnSubmit = "//a[@id='btn_proceed']";
        assuredInvisible(actor, "//div[contains(@class,'opopup-bg loading')]");
        assuredSelect(actor, "TestName", "//input[@id='FirstName']");
        assuredSelect(actor, "TestSurname", "//input[@id='LastName']");
        assuredSelect(actor, "069000111", "//input[@id='Phone']");
        assuredSelect(actor, "test@test.com", "//input[@id='Email']");
        assuredClick(actor, "//a[@id='contractSubmit']");
        assuredScroll(actor, btnSubmit);
        assuredClick(actor, "//div[@class='chek-min-fed padding_0_20 txt-left']//span[@class='checkmark_checkbox']");
//        assuredClick(actor, btnSubmit);
    }

    @Then("{actor} ensures that order is succeeded")
    public void ensureOrderCompleted(Actor actor) {
        String txtTitle = "//div[@class='success-title txt-caption-s-size bold']";
        actor.attemptsTo(
                WaitUntil.the(txtTitle, WebElementStateMatchers.isVisible()).forNoMoreThan(LONG_TIMEOUT).seconds(),
                Ensure.that(Target.the("title").locatedBy(txtTitle))
                        .hasText("Tranzacția a fost efectuată cu succes")
        );
    }

    @Then("debug step")
    public void debugStep() {
        System.out.println("debug step");
    }

}
