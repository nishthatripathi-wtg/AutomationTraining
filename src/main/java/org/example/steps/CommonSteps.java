package org.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Context;
import org.example.components.section.Common;

public class CommonSteps {

    private final Common commonComponent;

    public CommonSteps(Context context) {
        commonComponent = new Common(context.getInstance());
    }

    @Given("I open bootcamp website")
    public void iOpenBootcampWebsite() {
        commonComponent.openBootcampWebsite();
    }

    @When("I click on {string}")
    public void iClickOn(String buttonName) {
        commonComponent.clickOn(buttonName);
    }

    @Then("^I (accept|reject) the dialog box$")
    public void iTheDialogBox(String decision) {
       commonComponent.theDialogBox(decision);
    }

    @Then("I verify the text {string}")
    public void iVerifyTheText(String text) {
       commonComponent.verifyTheText(text);
    }
}