
package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.NoArgsConstructor;
import org.example.Context;
import org.example.components.section.DepartmentList;
import org.example.components.section.DepartmentModal;
import org.example.model.Department;

@NoArgsConstructor
public class DepartmentSteps {

    private static final String DELETE = "Delete";

    private Context context;
    private DepartmentList departmentList;
    private DepartmentModal departmentModal;

    public DepartmentSteps(Context context) {
        this.context = context;
        this.departmentList = new DepartmentList(context.getInstance());
        this.departmentModal = new DepartmentModal(context.getInstance());
    }

    @And("I fill the department form details")
    public void iFillTheDepartmentFormDetails(Department department) {
        //When
        departmentModal.fillTheDepartmentFormDetails(department);

        //Then
        context.setDepartmentData(department);
    }

    @Then("I verify the department details")
    public void iVerifyTheDepartmentDetails() {
        //Given
        Department department = context.getDepartmentData();

        //When
        departmentList.verifyTheDepartmentDetails(department);
    }

    @And("I verify the icons")
    public void iVerifyTheIcons() {
        Department department = context.getDepartmentData();

        departmentList.iVerifyTheIcons(department);
    }

    @When("I click on {string} for last department")
    public void iClickOnForLastDepartment(String iconName) {
        if (iconName.equals(DELETE)) {
            String id = departmentList.getLastDepartmentId();
            context.setDepartmentId(id);
        }

        departmentList.clickOnForLastDepartment(iconName);
    }

    @And("I verify the last department is deleted")
    public void iVerifyTheLastDepartmentIsDeleted() {
        departmentList.iVerifyTheLastDepartmentIsDeleted(context.getDepartmentId());
    }
}