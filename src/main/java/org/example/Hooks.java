package org.example;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.instances.GenericInstance;
import org.example.instances.PlaywrightInstance;

public class Hooks {
    private GenericInstance instance;
    private final Context context;

    public Hooks(Context context) {
        this.context = context;
    }

    @Before
    public void initialize() {
        instance = new PlaywrightInstance();
        context.setInstance(instance);
    }

    @After
    public void tearDown() {
        instance.tearDown();
    }
}
