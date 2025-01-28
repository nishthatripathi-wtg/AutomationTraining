package org.example.steps;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.en.Then;
import org.example.Context;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class EmployeeSteps {
    public static final String URL = "https://bootcampapi05.bolero-global.net/UI/index.html";

    private static Playwright playwright;
    private static Page page;
    private static Browser browser;
    Context context;

  //  @Before
    public void setup() {
        playwright = Playwright.create();
        browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        context = new Context();
    }

    /*@Given("I open bootcamp website")
    public void iOpenBootcampWebsite() {
        page.navigate(URL);
    }*/

    @Then("I verify the text")
    public void iVerifyTheResult() {
        assertThat(page.locator("//p")).containsText("hiring");
       /* assertThat(page.locator("//a[contains(@class,'active')]")).containsText("Employees");
        assertThat(page.locator("//a[@href='#']")).containsText("Bootcamp");*/
    }

   // @After
    public void tearDown(){
        page.close();
        browser.close();
        playwright.close();
    }

}
