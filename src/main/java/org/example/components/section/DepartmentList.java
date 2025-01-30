package org.example.components.section;

import org.example.components.Button;
import org.example.components.GenericComponent;
import org.example.components.TableData;
import org.example.instances.GenericInstance;
import org.example.model.Department;

public class DepartmentList extends GenericComponent {
    private static final String LAST_DEPT_NAME_SELECTOR = "//tr[last()]/td[2]";
    private static final String LAST_DEPT_READ_ONLY_SELECTOR = "//tr[last()]/td[3]/i";
    private static final String LAST_DEPT_MANDATORY_SELECTOR = "//tr[last()]/td[4]/i";
    private static final String CLASS_CHECK = "bi bi-check-lg";
    private static final String CLASS_UNCHECK = "bi bi-x-lg";
    private static final String LAST_BUTTON_EDIT_SELECTOR = "//tr[last()]/td[5]/button[@ngbtooltip='Edit']";
    private static final String LAST_BUTTON_DELETE_SELECTOR = "//tr[last()]/td[5]/button[@ngbtooltip='Delete']";
    private static final String LAST_ID_SELECTOR = "//tr[last()]/td[1]";
    private static final String LAST_ICON_SELECTOR = "//tr[last()]/td[5]/button[@ngbtooltip='%s']";

    private final TableData tableDataDepartmentName;
    private final TableData tableDataReadOnly;
    private final TableData tableDataMandatory;
    private final TableData tableDataLastId;
    private final Button editButton;
    private final Button deleteButton;
    private final Button actionButton;

    public DepartmentList(GenericInstance instance) {
        super(instance);
        tableDataDepartmentName = new TableData(instance, LAST_DEPT_NAME_SELECTOR);
        tableDataMandatory = new TableData(instance, LAST_DEPT_MANDATORY_SELECTOR);
        tableDataReadOnly = new TableData(instance, LAST_DEPT_READ_ONLY_SELECTOR);
        tableDataLastId = new TableData(instance, LAST_ID_SELECTOR);
        editButton = new Button(instance, LAST_BUTTON_EDIT_SELECTOR);
        deleteButton = new Button(instance, LAST_BUTTON_DELETE_SELECTOR);
        actionButton = new Button(instance, LAST_ICON_SELECTOR);
    }

    public void verifyTheDepartmentDetails(Department department) {
        tableDataDepartmentName.assertContainsText(department.getName());
        tableDataReadOnly.assertHasClass(getAssertionClass(department.getReadOnly()));
        tableDataMandatory.assertHasClass(getAssertionClass(department.getMandatory()));
    }

    public void iVerifyTheIcons(Department department) {
        editButton.assertIsVisible();
        editButton.assertIsEnabled();

        deleteButton.assertIsVisible();
        if (department.getReadOnly()) {
            deleteButton.assertIsDisabled();
        } else {
            deleteButton.assertIsEnabled();
        }
    }

    public void clickOnForLastDepartment(String iconName) {
        actionButton.setParameters(iconName);
        actionButton.click();
    }

    public String getLastDepartmentId() {
        return tableDataLastId.getInnerText();
    }

    public void iVerifyTheLastDepartmentIsDeleted(String departmentId) {
        tableDataLastId.assertNotContainsText(departmentId);
    }

    private String getAssertionClass(boolean flag) {
        return flag ? CLASS_CHECK : CLASS_UNCHECK;
    }
}