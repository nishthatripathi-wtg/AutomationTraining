package org.example.components;

import com.microsoft.playwright.Locator;
import org.example.instances.GenericInstance;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NavBarComponent extends GenericComponent {
    private static final String A_TEXT = "//a[text()='%s']";
    public static final String A_CONTAINS_CLASS_ACTIVE = "//a[contains(@class,'active')]";

    public NavBarComponent(GenericInstance instance) {
        super(instance);
    }

    public void navigateToTab(String tabName) {
      instance.click(String.format(A_TEXT, tabName));
    }

    public void verifyMenuIsSelected(String menuItem) {
        instance.assertContainsText(A_CONTAINS_CLASS_ACTIVE,menuItem);

    }

    public void verifyTheMenuItems(List<String> items) {
        items.forEach(item -> {
            Locator locator =instance.locator(A_TEXT.formatted(item));
            assertThat(locator).isVisible();
        });
    }
}
