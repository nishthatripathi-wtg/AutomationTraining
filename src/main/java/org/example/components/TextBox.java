package org.example.components;

import org.example.instances.GenericInstance;

public class TextBox extends GenericSelector {
    public TextBox(GenericInstance instance, String selector) {
        super(instance, selector);
    }

    public void fill(String text) {
        instance.fill(getFormattedSelector(), text);
    }
}
