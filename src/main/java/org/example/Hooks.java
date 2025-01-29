package org.example;

import com.microsoft.playwright.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.instances.GenericInstance;
import org.example.instances.PlaywrightInstance;

public class Hooks {
    private static GenericInstance instance;
    private  Context context;

    public Hooks( Context context) {
        this.context = context;
    }


    @Before
    public  void initialize() {
        instance = new PlaywrightInstance();
        context.setInstance(instance);
    }

    @After
    public static void tearDown() {
        instance.tearDown();
    }

}
