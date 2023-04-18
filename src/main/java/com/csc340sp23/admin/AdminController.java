package com.csc340sp23.admin;

import com.csc340sp23.PrototypeDemoApplication;
import static com.csc340sp23.PrototypeDemoApplication.imageUrls;
import static com.csc340sp23.PrototypeDemoApplication.soyTenor;
import com.csc340sp23.admin.employees.EmployeeService;
import com.csc340sp23.admin.employees.Employee;
import com.csc340sp23.admin.task.TaskService;
import com.csc340sp23.admin.task.Task;
import com.csc340sp23.customer.helpdesk.HelpDeskService;
import com.csc340sp23.customer.helpdesk.HelpDesk;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * @author Christopher Jacobs
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    TaskService taskService;
    @Autowired
    HelpDeskService helpDeskService;
    
    @GetMapping("/home")
    public String getHome(Model model) {
               
        String randomImageUrlSoy = PrototypeDemoApplication.soyTenor();
        String randomImageUrlEng = PrototypeDemoApplication.engieTenor();
        model.addAttribute("imageUrlEng", randomImageUrlEng);
        model.addAttribute("imageUrlSoy", randomImageUrlSoy);
        return "management/home";
    }
    
    @GetMapping("/complaints")
    public String getComplaints(Model model) {
        model.addAttribute("complaintList", helpDeskService.getAllMessages());
        return "management/complaints/list-complaints";
    }

    @GetMapping("/deletecomplaint/complaints/messageId={messageId}")
    public String deleteHelpDesk(@PathVariable long messageId) {
        helpDeskService.deleteMessageById(messageId);
        return "redirect:/admin/complaints";

    }
    
    @GetMapping("/tasks")
    public String getTasks(Model model) {
        model.addAttribute("taskList", taskService.getAllTasks());
        return "management/tasks/list-tasks";
    }
    
    @GetMapping("/tasks/new-task")
    public String newTask(Model model) {
        model.addAttribute("employeeList", employeeService.getAllEmployees());
        return "management/tasks/new-task";
    }
    
    @GetMapping("/tasks/id={taskId}")
    public String getTask(@PathVariable long taskId, Model model) {
        model.addAttribute("task", taskService.getTask(taskId));
        return "management/tasks/details-task";
    }
    
    @GetMapping("/tasks/delete/id={taskId}")
    public String deleteTask(@PathVariable long taskId, Model model) {
        
        Task taskToDelete = taskService.getTask(taskId);
        Employee employee = taskToDelete.getEmployee();
        
        if (employee != null) {
            employee.removeTask(taskToDelete);
            employee.decrementTasksTotal();
            employeeService.saveEmployee(employee);
        }
        
        taskService.deleteTask(taskId);
        return "redirect:/admin/tasks";
    }
    
    @GetMapping("/tasks/modify/id={taskId}")
    public String updateTaskForm(@PathVariable long taskId, Model model) {
        model.addAttribute("task", taskService.getTask(taskId));
        return "management/tasks/update-task";
    }    
    
    @PostMapping("/tasks/update")
    public String updateTask(Task task) {
        taskService.saveTask(task);
        return "redirect:/admin/tasks";
    }
    
    
    @PostMapping("/tasks/create")
    public String createTask(@ModelAttribute("task") Task task, @RequestParam("employeeId") Long employeeId) {
        Employee employee = employeeService.getEmployee(employeeId);
        task.setEmployee(employee);
        taskService.saveTask(task);
        return "redirect:/admin/tasks";
    }
    
    @GetMapping("/employees")
    public String getEmployees(Model model) {
        model.addAttribute("employeeList", employeeService.getAllEmployees());
        return "management/employees/list-employees";
    }
    
    @GetMapping("/employees/id={employeeId}")
    public String getEmployee(@PathVariable long employeeId, Model model) {
        model.addAttribute("imgUrl", PrototypeDemoApplication.soyImg());
        model.addAttribute("employee", employeeService.getEmployee(employeeId));
        return "management/employees/employee-details";
    }
    
    @GetMapping("/employees/delete/id={employeeId}")
    public String deleteEmployee(@PathVariable long employeeId, Model model) {
        employeeService.deleteEmployee(employeeId);
        return "redirect:/admin/employees";
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


