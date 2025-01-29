package org.example.instances;

import com.microsoft.playwright.*;
import org.example.Context;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;


public class PlaywrightInstance implements GenericInstance {

    private Page page;

    private Playwright playwright;

    private Browser browser;

    public PlaywrightInstance() {
        playwright = Playwright.create();
        browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    @Override
    public void click(String selector) {
        page.locator(selector).click();

    }

    @Override
    public void navigate(String url) {
        page.navigate(url);
    }

    @Override
    public void dialogAction(boolean action) {
        if (action) {
            page.onDialog(Dialog::accept);
        } else {
            page.onDialog(Dialog::dismiss);
        }
    }

    @Override
    public void fill(String selector, String value) {
        page.locator(selector).fill(value);

    }

    @Override
    public void check(String selector) {
        page.locator(selector).check();
    }

    @Override
    public String innerText(String selector) {
        return page.locator(selector).innerText();
    }

    @Override
    public Locator locator(String selector) {
        return page.locator(selector);
    }

    @Override
    public void waitForTimeout(double timeout) {
        page.waitForTimeout(timeout);
    }

    @Override
    public void assertContainsText(String selector, String text) {
        assertThat(page.locator(selector)).containsText(text);
    }

    @Override
    public void assertNotContainsText(String selector, String text) {
        assertThat(page.locator(selector)).not().containsText(text);
    }

    @Override
    public void assertIsVisible(String selector) {
        assertThat(page.locator(selector)).isVisible();
    }

    @Override
    public void assertIsEnabled(String selector) {
        assertThat(page.locator(selector)).isEnabled();
    }

    @Override
    public void assertIsDisabled(String selector) {
        assertThat(page.locator(selector)).isDisabled();
    }

    @Override
    public void assertIsChecked(String selector) {
        assertThat(page.locator(selector)).isChecked();
    }

    @Override
    public void assertHasClass(String selector, String className) {
        assertThat(page.locator(selector)).hasClass(className);
    }

    @Override
    public void tearDown() {
        page.close();
        browser.close();
        playwright.close();
    }
}