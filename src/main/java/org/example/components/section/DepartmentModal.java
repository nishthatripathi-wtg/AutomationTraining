package org.example.components.section;

import org.example.components.CheckBox;
import org.example.components.GenericComponent;
import org.example.components.TextBox;
import org.example.instances.GenericInstance;
import org.example.model.Department;

public class DepartmentModal extends GenericComponent {
    private static final String INPUT_ID_DEPARTMENT_NAME_SELECTOR = "//input[@id='departmentName']";
    private static final String INPUT_ID_READ_ONLY_SELECTOR = "//input[@id='readOnly']";
    private static final String INPUT_ID_MANDATORY_SELECTOR = "//input[@id='mandatory']";

    private final TextBox textBoxDepartment;
    private final CheckBox checkBoxReadOnly;
    private final CheckBox checkBoxMandatory;

    public DepartmentModal(GenericInstance instance) {
        super(instance);
        textBoxDepartment = new TextBox(instance, INPUT_ID_DEPARTMENT_NAME_SELECTOR);
        checkBoxReadOnly = new CheckBox(instance,INPUT_ID_READ_ONLY_SELECTOR );
        checkBoxMandatory = new CheckBox(instance, INPUT_ID_MANDATORY_SELECTOR);

    }

    public void fillTheDepartmentFormDetails(Department department) {
        textBoxDepartment.fill(department.getName());
        checkBoxReadOnly.check(department.getReadOnly());
        checkBoxMandatory.check(department.getMandatory());
    }
}
