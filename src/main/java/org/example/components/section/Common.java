package org.example.components.section;

import org.example.components.Button;
import org.example.components.GenericComponent;
import org.example.components.Text;
import org.example.instances.GenericInstance;

public class Common extends GenericComponent {
    private static final String URL = "https://bootcampapi05.bolero-global.net/UI/index.html";
    private static final String BUTTON_TEXT_SELECTOR = "//button[text()='%s']";
    private static final String P_SELECTOR = "//p";
    public static final String ACCEPT = "Accept";

    private final Text textComponent;
    private final Button actionButton;

    public Common(GenericInstance instance) {
        super(instance);
        actionButton = new Button(instance, BUTTON_TEXT_SELECTOR);
        textComponent = new Text(instance, P_SELECTOR);
    }

    public void openBootcampWebsite() {
        instance.navigate(URL);
    }

    public void clickOn(String buttonName) {
        actionButton.setParameters(buttonName);
        actionButton.click();
    }

    public void theDialogBox(String decision) {
        instance.dialogAction(decision.equals(ACCEPT));
    }

    public void verifyTheText(String text) {
        textComponent.assertContainsText(text);
    }
}
