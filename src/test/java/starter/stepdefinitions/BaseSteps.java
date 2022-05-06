package starter.stepdefinitions;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import static org.openqa.selenium.Keys.RETURN;

public class BaseSteps extends PageObject {
    public final int SHORT_TIMEOUT = 10;
    public final int MEDIUM_TIMEOUT = 15;
    public final int LONG_TIMEOUT = 20;

    public void assuredClick(Actor actor, String element) {
        actor.attemptsTo(
                WaitUntil.the(element, WebElementStateMatchers.isVisible()).forNoMoreThan(SHORT_TIMEOUT).seconds(),
                WaitUntil.the(element, WebElementStateMatchers.isEnabled()).forNoMoreThan(SHORT_TIMEOUT).seconds(),
                WaitUntil.the(element, WebElementStateMatchers.isClickable()).forNoMoreThan(SHORT_TIMEOUT).seconds(),
                Click.on(element)
        );
    }

    public void assuredHover(Actor actor, String element) {
        actor.attemptsTo(
                WaitUntil.the(element, WebElementStateMatchers.isVisible()).forNoMoreThan(SHORT_TIMEOUT).seconds(),
                WaitUntil.the(element, WebElementStateMatchers.isEnabled()).forNoMoreThan(SHORT_TIMEOUT).seconds(),
                WaitUntil.the(element, WebElementStateMatchers.isClickable()).forNoMoreThan(SHORT_TIMEOUT).seconds(),
                HoverOverBy.over(element)
        );
    }

    public void assuredInvisible(Actor actor, String element) {
        actor.attemptsTo(
                WaitUntil.the(element, WebElementStateMatchers.isNotVisible()).forNoMoreThan(MEDIUM_TIMEOUT).seconds()
        );
    }

    public void assuredSelect(Actor actor, String item, String element) {
        actor.attemptsTo(
                WaitUntil.the(element, WebElementStateMatchers.isVisible()).forNoMoreThan(SHORT_TIMEOUT).seconds(),
                WaitUntil.the(element, WebElementStateMatchers.isEnabled()).forNoMoreThan(SHORT_TIMEOUT).seconds(),
                WaitUntil.the(element, WebElementStateMatchers.isClickable()).forNoMoreThan(SHORT_TIMEOUT).seconds(),
                Enter.theValue(item).into(element),
                Hit.the(RETURN).keyIn(element)
        );
    }

    public void assuredScroll(Actor actor, String element) {
        actor.attemptsTo(
                WaitUntil.the(element, WebElementStateMatchers.isVisible()).forNoMoreThan(MEDIUM_TIMEOUT).seconds(),
                Scroll.to(By.xpath(element))
        );
    }
}
