package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.Context;
import org.example.components.section.NavBar;

import java.util.List;

public class NavBarSteps {
    private final NavBar navBarComponent;

    public NavBarSteps(Context context) {
        this.navBarComponent = new NavBar(context.getInstance());
    }

    @And("^I navigate to (Employees|Departments) tab$")
    public void iNavigateToMenuItem(String tabName) {
        navBarComponent.navigateToMenuItem(tabName);
    }

    @And("I verify Menu {string} is selected")
    public void iVerifyMenuIsSelected(String menuItem) {
        navBarComponent.verifyMenuIsSelected(menuItem);
    }

    @Then("I verify the Menu items")
    public void iVerifyTheMenuItems(List<String> items) {
        navBarComponent.verifyTheMenuItems(items);
    }
}