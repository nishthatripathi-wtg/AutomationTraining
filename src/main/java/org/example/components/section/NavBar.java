package org.example.components.section;

import org.example.components.GenericComponent;
import org.example.components.MenuItem;
import org.example.instances.GenericInstance;

import java.util.List;

public class NavBar extends GenericComponent {
    private static final String A_TEXT_SELECTOR = "//a[text()='%s']";
    public static final String A_ACTIVE_CLASS_SELECTOR = "//a[contains(@class,'active')]";

    private final MenuItem menuItem;
    private final MenuItem activeMenuItem;

    public NavBar(GenericInstance instance) {
        super(instance);
        menuItem = new MenuItem(instance, A_TEXT_SELECTOR);
        activeMenuItem = new MenuItem(instance, A_ACTIVE_CLASS_SELECTOR);
    }

    public void navigateToMenuItem(String itemName) {
        menuItem.setParameters(itemName);
        menuItem.click();
    }

    public void verifyMenuIsSelected(String itemName) {
        activeMenuItem.assertContainsText(itemName);
    }

    public void verifyTheMenuItems(List<String> items) {
        items.forEach(item -> {
            menuItem.setParameters(item);
            menuItem.assertIsVisible();
        });
    }
}