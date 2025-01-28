package org.example.steps;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NavBarSteps {
    private static Playwright playwright;
    private static Page page;
    private static Browser browser;

    @Before
    public void setup() {
        playwright = Playwright.create();
        browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();

    }

    @Given("I open bootcamp website")
    public void iOpenBootcampWebsite() {
        page.navigate(DepartmentSteps.URL);
    }

    @Then("I verify the text on NavBar")
    public void iVerifyTheTextOnNavBar() {
        assertThat(page.locator("//a[contains(@class,'active')]")).containsText("Employees");
        assertThat(page.locator("//a[@href='#']")).containsText("Bootcamp");

    }

    @Then("I verify the text {string}")
    public void iVerifyTheText(String text) {
        assertThat(page.locator("//a[text()='" + text + "']")).containsText(text);
    }

    @And("I verify Menu {string} is selected")
    public void iVerifyMenuIsSelected(String menuItem) {
        assertThat(page.locator("//a[contains(@class,'active')]")).containsText(menuItem);

    }

    @And("I verify the Menu items")
    public void iVerifyTheMenuItems(List<String> items) {
        items.forEach(item -> {
            Locator locator = page.locator("//a[text()='" + item + "']");
            assertThat(locator).isVisible();
        });
    }
}
