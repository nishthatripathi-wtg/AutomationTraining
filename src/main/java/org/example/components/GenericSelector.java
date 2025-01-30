package org.example.components;

import org.example.instances.GenericInstance;

public abstract class GenericSelector extends GenericComponent {
    private final String selector;
    private String formattedSelector;

    public GenericSelector(GenericInstance instance, String selector) {
        super(instance);
        this.selector = selector;
    }

    public void assertContainsText(String text) {
        instance.assertContainsText(getFormattedSelector(), text);
    }

    public void assertNotContainsText(String text) {
        instance.assertNotContainsText(getFormattedSelector(), text);
    }

    public String getInnerText() {
        return instance.getInnerText(getFormattedSelector());
    }

    public void assertIsVisible() {
        instance.assertIsVisible(getFormattedSelector());
    }

    public void assertIsEnabled() {
        instance.assertIsEnabled(selector);
    }

    public void assertIsDisabled() {
        instance.assertIsDisabled(getFormattedSelector());
    }

    public void assertHasClass(String className) {
        instance.assertHasClass(getFormattedSelector(), className);
    }

    public void setParameters(String... parameters) {
        formattedSelector = selector.formatted(parameters);
    }

    public String getFormattedSelector() {
        return formattedSelector == null ? selector : formattedSelector;
    }
}