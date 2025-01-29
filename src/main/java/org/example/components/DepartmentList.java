package org.example.components;

import org.example.instances.GenericInstance;
import org.example.model.Department;

public class DepartmentList extends GenericComponent {

    private static final String LAST_DEPT_NAME = "//tr[last()]/td[2]";
    private static final String LAST_DEPT_READ_ONLY = "//tr[last()]/td[3]/i";
    private static final String LAST_DEPT_MANDATORY = "//tr[last()]/td[4]/i";
    private static final String CLASS_BI_BI_CHECK_LG = "bi bi-check-lg";
    private static final String CLASS_BI_BI_X_LG = "bi bi-x-lg";
    private static final String EDIT = "Edit";
    private static final String BUTTON_NGBTOOLTIP_EDIT = "//tr[last()]/td[5]/button[@ngbtooltip='" + EDIT + "']";
    private static final String DELETE = "Delete";
    private static final String BUTTON_NGBTOOLTIP_DELETE = "//tr[last()]/td[5]/button[@ngbtooltip='" + DELETE + "']";
    private static final String TR_LAST_TD_ID = "//tr[last()]/td[1]";
    private static final String TR_LAST_ICON = "//tr[last()]/td[5]/button[@ngbtooltip='%s']";

    private final TableData tableDataDepartmentName;
    private final TableData tableDataReadOnly;
    private final  TableData tableDataMandatory;
    private final  TableData tableDataLastId;
    private  final Button editButton;
    private  final Button deleteButton;


    public DepartmentList(GenericInstance instance) {
        super(instance);
        tableDataDepartmentName= new TableData(instance,LAST_DEPT_NAME);
        tableDataMandatory =  new TableData(instance,LAST_DEPT_MANDATORY );
        tableDataReadOnly=  new TableData(instance,LAST_DEPT_READ_ONLY );
        tableDataLastId=  new TableData(instance,TR_LAST_TD_ID );
        editButton = new Button(instance, BUTTON_NGBTOOLTIP_EDIT);
        deleteButton= new Button(instance, BUTTON_NGBTOOLTIP_DELETE);

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
        Button actionButton = new Button(instance, TR_LAST_ICON.formatted(iconName));
        actionButton.click();
    }

    public void iVerifyTheLastDepartmentIsDeleted(String departmentId) {
      tableDataLastId.assertNotContainsText(departmentId);

    }

    private String getAssertionClass(boolean flag) {
        return flag ? CLASS_BI_BI_CHECK_LG : CLASS_BI_BI_X_LG;
    }
}