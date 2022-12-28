package com.sampleproject.modules.employeeinfo;


import com.sampleproject.entities.Employee;
import com.sampleproject.mvputils.BaseView;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@UIScope
@SpringComponent
@Route("")
public class EmployeeInfoView extends BaseView<EmployeeInfoPresenter> {
    private Grid<Employee> employeeGrid;
    @Override
    protected void init() {
        employeeGrid = new Grid<>();
        employeeGrid.addColumn(Employee::getId).setHeader("Id");
        employeeGrid.addColumn(Employee::getEmpName).setHeader("Full Name");
        employeeGrid.addColumn(Employee::getDeptId).setHeader("Department Id");
        employeeGrid.addColumn(Employee::getSalary).setHeader("Salary");

        employeeGrid.setItems(getPresenter().employees());
        add(employeeGrid);
    }
}
