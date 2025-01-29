package org.example.steps;

import com.microsoft.playwright.Locator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Context;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class WisetechSteps {
    private static final String WISETECHGLOBAL_COM = "https://www.wisetechglobal.com/";
    private static final String A_CONTAINS_HREF = "//a[contains(@href,%s)]";
    private static final String H_2 = "//h2";
    private static final String MAKE_A_DIFFERENCE = "Join our team – make a difference";

    private Context context;

    public WisetechSteps(Context context) {
        this.context = context;
    }
    //TODO: Check on multiple browsers for Playwright

    @Given("I navigate to Wisetech website")
    public void iNavigateToWisetech() {
        context.getInstance().navigate(WISETECHGLOBAL_COM);
    }

    @When("I click on {string} menu item")
    public void iClickOn(String menuItem) {
        context.getInstance().locator(A_CONTAINS_HREF.formatted(menuItem)).first().click();
    }

    @Then("I verify the results")
    public void iVerifyTheResults() {
        Locator locator = context.getInstance().locator(H_2).first();
        assertThat(locator).isVisible();
        assertThat(locator).containsText(MAKE_A_DIFFERENCE);
    }
}
