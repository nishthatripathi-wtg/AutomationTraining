package org.example.components;

import org.example.instances.GenericInstance;
import org.example.model.Department;

public class DepartmentModal extends GenericComponent {

    private static final String INPUT_ID_DEPARTMENT_NAME = "//input[@id='departmentName']";
    private static final String INPUT_ID_READ_ONLY = "//input[@id='readOnly']";
    private static final String INPUT_ID_MANDATORY = "//input[@id='mandatory']";

    private final TextBox textBoxDepartment;
    private final CheckBox checkBoxReadOnly;
    private final CheckBox checkBoxMandatory;

    public DepartmentModal(GenericInstance instance) {
        super(instance);
        textBoxDepartment = new TextBox(instance, INPUT_ID_DEPARTMENT_NAME);
        checkBoxReadOnly = new CheckBox(instance,INPUT_ID_READ_ONLY );
        checkBoxMandatory = new CheckBox(instance, INPUT_ID_MANDATORY);

    }

    public void fillTheDepartmentFormDetails(Department department) {
        textBoxDepartment.fill(INPUT_ID_DEPARTMENT_NAME, department.getName());
        checkBoxReadOnly.check(department.getReadOnly());
        checkBoxMandatory.check(department.getMandatory());
    }
}
