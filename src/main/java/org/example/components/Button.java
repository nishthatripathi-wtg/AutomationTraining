package org.example.components;

import org.example.instances.GenericInstance;

public class Button extends GenericSelector {

    public Button(GenericInstance instance, String selector) {
        super(instance, selector);
    }

    public void click() {
        instance.click(selector);
    }
}
