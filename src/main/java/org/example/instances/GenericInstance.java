package org.example.instances;

import com.microsoft.playwright.Locator;

public interface GenericInstance {
    void click(String selector);

    void navigate(String url);

    void dialogAction(boolean action);

    void fill(String selector, String value);

    void check(String selector);

    String innerText(String selector);

    Locator locator(String selector);

    void waitForTimeout(double timeout);

    void assertContainsText(String selector, String text);

    void assertIsVisible(String selector);

    void assertIsEnabled(String selector);

    void assertIsDisabled(String selector);

    void assertIsChecked(String selector);

    void assertHasClass(String selector, String className);

    void assertNotContainsText(String selector, String text);

    void tearDown();

}

