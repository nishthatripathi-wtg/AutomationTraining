package org.example.components;

import org.example.instances.GenericInstance;

public class CommonComponent extends GenericComponent {
    private static final String URL = "https://bootcampapi05.bolero-global.net/UI/index.html";
    private static final String BUTTON_TEXT = "//button[text()='%s']";
    private static final String P = "//p";

    public CommonComponent(GenericInstance instance) {
        super(instance);
    }

    public void openBootcampWebsite() {
        instance.navigate(URL);
    }

    public void clickOn(String buttonName) {
        instance.click(String.format(BUTTON_TEXT, buttonName));
    }

    public void theDialogBox(String decision) {
        instance.dialogAction(decision.equals("Accept"));
    }

    public void verifyTheText(String text) {
        instance.assertContainsText(P, text);
    }
}
