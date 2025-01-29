package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.Context;
import org.example.components.NavBarComponent;

import java.util.List;

public class NavBarSteps {
    private final NavBarComponent navBarComponent;

    public NavBarSteps(Context context) {
        this.navBarComponent = new NavBarComponent(context.getInstance());
    }

    @And("I navigate to {string} tab")
    public void iNavigateToTab(String tabName) {
        navBarComponent.navigateToTab(tabName);
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