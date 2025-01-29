package org.example.components;

import org.example.instances.GenericInstance;

public abstract class GenericSelector extends GenericComponent {
    public String selector;

    public GenericSelector(GenericInstance instance, String selector) {
        super(instance);
        this.selector = selector;
    }

    public void assertContainsText(String text) {
        instance.assertContainsText(selector, text);

    }

    public void assertNotContainsText(String text) {
        instance.assertNotContainsText(selector, text);

    }

    public void assertIsVisible() {
        instance.assertIsVisible(selector);
    }

    public void assertIsEnabled() {
        instance.assertIsEnabled(selector);
    }

    public void assertIsDisabled() {
        instance.assertIsDisabled(selector);
    }

    public void assertHasClass(String className) {
        instance.assertHasClass(selector, className);
    }
}
