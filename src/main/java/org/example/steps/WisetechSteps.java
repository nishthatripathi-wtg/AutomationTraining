package org.example.steps;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class WisetechSteps {
    public static final String GET_IN_TOUCH = "Get in touch";
    private static final String WISETECHGLOBAL_COM = "https://www.wisetechglobal.com/";

    private static Playwright playwright;
    private static   Page page;
    private static Browser browser;

    //TODO: Check on multiple browsers for Playwright

    public void setup() {
         playwright = Playwright.create();
         browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
         page = browser.newPage();
    }

    @Given("I navigate to Wisetech website")
    public void iNavigateToWisetech() {
        page.navigate(WISETECHGLOBAL_COM);
    }

    @When("I click on {string} menu item")
    public void iClickOn(String menuItem) {
        page.locator("//a[contains(@href," + menuItem + ")]").first().click();
    }

    @Then("I verify the results")
    public void iVerifyTheResults() {
        Locator locator = page.locator("//h2").first();
        assertThat(locator).isVisible();
        assertThat(locator).containsText(GET_IN_TOUCH);
    }

   
    public void tearDown(){
        page.close();
        browser.close();
        playwright.close();
    }
}
