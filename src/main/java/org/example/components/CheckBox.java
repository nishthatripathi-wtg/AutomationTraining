package org.example.components;

import org.example.instances.GenericInstance;

public class CheckBox extends GenericSelector {

    public CheckBox(GenericInstance instance, String selector) {
        super(instance, selector);
    }

    public void check(boolean check) {
        if (check) {
            instance.check(getFormattedSelector());
        }
    }
}