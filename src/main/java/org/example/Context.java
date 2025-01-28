package org.example;

import lombok.Data;
import org.example.model.Department;

@Data
public class Context {
    private Department departmentData;
    private String departmentId;
}
