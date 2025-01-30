package org.example.model;

import io.cucumber.java.DataTableType;
import lombok.Data;

import java.util.Map;

@Data
public class Department {
    private String name;
    private Boolean readOnly;
    private Boolean mandatory;

    @DataTableType
    public Department setDepartmentDetails(Map<String, String> details) {
        Department department = new Department();
        department.setName(details.get("name"));
        department.setMandatory(Boolean.parseBoolean(details.get("mandatory")));
        department.setReadOnly(Boolean.parseBoolean(details.get("readOnly")));
        return department;
    }
}
