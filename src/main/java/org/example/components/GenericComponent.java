package org.example.components;

import lombok.AllArgsConstructor;
import org.example.instances.GenericInstance;

@AllArgsConstructor
public abstract class GenericComponent {
    protected GenericInstance instance;
}