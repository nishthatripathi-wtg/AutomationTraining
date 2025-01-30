package org.example.components;

import org.example.instances.GenericInstance;

public class MenuItem extends GenericSelector{
    public MenuItem(GenericInstance instance, String selector) {
        super(instance, selector);
    }

    public void click() {
        instance.click(getFormattedSelector());
    }
}