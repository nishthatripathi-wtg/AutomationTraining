package org.example.steps;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Context;
import org.example.model.Department;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

public class DepartmentSteps {
    public static final String URL = "https://bootcampapi05.bolero-global.net/UI/index.html";
    public static final String A_TEXT = "//a[text()='%s']";
    public static final String BUTTON_TEXT = "//button[text()='%s']";
    public static final String INPUT_ID_DEPARTMENT_NAME = "//input[@id='departmentName']";
    public static final String INPUT_ID_READ_ONLY = "//input[@id='readOnly']";
    public static final String INPUT_ID_MANDATORY = "//input[@id='mandatory']";
    public static final String LAST_DEPT_NAME = "//tr[last()]/td[2]";
    public static final String LAST_DEPT_READ_ONLY = "//tr[last()]/td[3]/i";
    public static final String LAST_DEPT_MANDATORY = "//tr[last()]/td[4]/i";
    public static final String CLASS_BI_BI_CHECK_LG = "bi bi-check-lg";
    public static final String CLASS_BI_BI_X_LG = "bi bi-x-lg";
    public static final String EDIT = "Edit";
    public static final String BUTTON_NGBTOOLTIP_EDIT = "//tr[last()]/td[5]/button[@ngbtooltip='" + EDIT + "']";
    public static final String DELETE = "Delete";
    public static final String BUTTON_NGBTOOLTIP_DELETE = "//tr[last()]/td[5]/button[@ngbtooltip='" + DELETE + "']";
    public static final String TR_LAST_TD_ID = "//tr[last()]/td[1]";
    public static final String TR_LAST_ICON = "//tr[last()]/td[5]/button[@ngbtooltip='%s']";

    private static Playwright playwright;
    private static Page page;
    private static Browser browser;
    private Context context;

    //@Before
    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        context = new Context();
    }
/*
    @Given("I open bootcamp website")
    public void iOpenBootcampWebsite() {
        page.navigate(URL);
    }*/

    @And("I navigate to {string} tab")
    public void iNavigateToTab(String tabName) {
        page.locator(String.format(A_TEXT, tabName)).click();
    }

    @When("I click on {string}")
    public void iClickOn(String buttonName) {
        page.locator(String.format(BUTTON_TEXT,buttonName)).click();
    }

    @And("I fill the department form details")
    public void iFillTheDepartmentFormDetails(Department department) {
        page.locator(INPUT_ID_DEPARTMENT_NAME).fill(department.getName());
        if (department.getReadOnly()) {
            page.locator(INPUT_ID_READ_ONLY).check();
        }
        if (department.getMandatory()) {
            page.locator(INPUT_ID_MANDATORY).check();
        }
        context.setDepartmentData(department);
    }

    @Then("I verify the department details")
    public void iVerifyTheDepartmentDetails() {
        Department department = context.getDepartmentData();
        assertThat(page.locator(LAST_DEPT_NAME)).containsText(department.getName());

        if (department.getReadOnly())
            assertThat(page.locator(LAST_DEPT_READ_ONLY)).hasClass(CLASS_BI_BI_CHECK_LG);
        else
            assertThat(page.locator(LAST_DEPT_READ_ONLY)).hasClass(CLASS_BI_BI_X_LG);

        if (department.getMandatory())
            assertThat(page.locator(LAST_DEPT_MANDATORY)).hasClass(CLASS_BI_BI_CHECK_LG);
        else
            
            assertThat(page.locator(LAST_DEPT_MANDATORY)).hasClass(CLASS_BI_BI_X_LG);

    }

    @And("I verify the icons")
    public void iVerifyTheIcons() {
        Department department = context.getDepartmentData();
        Locator editLocator = page.locator(BUTTON_NGBTOOLTIP_EDIT);

        assertThat(editLocator).isVisible();
        assertThat(editLocator).isEnabled();

        Locator deleteLocator = page.locator(BUTTON_NGBTOOLTIP_DELETE);

        assertThat(deleteLocator).isVisible();
        if (department.getReadOnly()) {
            assertThat(deleteLocator).isDisabled();
        } else {
            assertThat(deleteLocator).isEnabled();
        }
    }

    // @After
    public void tearDown() {
        page.close();
        browser.close();
        playwright.close();
    }


    @When("I click on {string} for last department")
    public void iClickOnForLastDepartment(String iconName) {
        if (iconName.equals(DELETE)) {
            String id = page.locator(TR_LAST_TD_ID).innerText();
            context.setDepartmentId(id);
        }
        page.locator(String.format(TR_LAST_ICON,iconName)).click();
    }

    @Then("I accept the dialog box")
    public void iAcceptTheDialogBox() {
        page.onDialog(Dialog::accept);
        page.waitForTimeout(1000);
    }

    @And("I verify the last department is deleted")
    public void iVerifyTheLastDepartmentIsDeleted() {
        Locator element = page.locator(TR_LAST_TD_ID);
        assertThat(element).not().containsText(context.getDepartmentId());
    }
}
