package org.example.model;

import io.cucumber.java.DataTableType;

import java.util.Map;

public class Department {
    private String name;
    private Boolean readOnly;
    private Boolean mandatory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    public Boolean getMandatory() {
        return mandatory;
    }

    public void setMandatory(Boolean mandatory) {
        this.mandatory = mandatory;
    }

    @DataTableType
    public Department setDepartmentDetails(Map<String, String> details) {
        Department department = new Department();
        department.setName(details.get("name"));
        department.setMandatory(Boolean.parseBoolean(details.get("mandatory")));
        department.setReadOnly(Boolean.parseBoolean(details.get("readOnly")));
        return department;
    }
}
