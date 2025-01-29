package org.example;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.instances.GenericInstance;
import org.example.model.Department;


@Data
@NoArgsConstructor
public class Context {
    private Department departmentData;
    private String departmentId;
    private GenericInstance instance;
}
