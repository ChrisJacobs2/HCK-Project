package com.csc340sp23.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ModelAttribute;


/**
 *
 * @author Christopher Jacobs
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    EmployeeService employeeService;
    
    @GetMapping("/home")
    public String getHome() {
        return "management/home";
    }
    
    @GetMapping("/complaints")
    public String getComplaints() {
        return "management/complaints/list-complaints";
    }
    
    @GetMapping("/complaints/details")
    public String getComplaintDetails() {
        return "management/complaints/details-complaints";
    }
    
    @GetMapping("/tasks")
    public String getTasks() {
        return "management/tasks/list-tasks";
    }
    
    @GetMapping("/tasks/new-task")
    public String newTask() {
        return "management/tasks/new-task";
    }
    
    @GetMapping("/tasks/details")
    public String taskDetails() {
        return "management/tasks/details-task";
    }
    
    @GetMapping("/tasks/modify")
    public String updateTask() {
        return "management/tasks/update-task";
    }    
    
    @GetMapping("/employees")
    public String getEmployees() {
        return "management/employees/list-employees";
    }
    
    @GetMapping("/employees/id")
    public String getEmployeeInfo() {
        return "management/employees/employee-details";
    }
    
    @GetMapping("/employees/id/message")
    public String getEmployeeTasks() {
        return "management/employees/new-message";
    }
    
    @GetMapping("/employees/new-employee")
    public String newEmployeeForm(Model model) {
        return "management/employees/new-employee";
    }
    
    @PostMapping("/employees/create")
    public String createEmpoyee(Employee employee) {

        employeeService.saveEmployee(employee);
        return "redirect:/admin/employees";
    }
    
}


