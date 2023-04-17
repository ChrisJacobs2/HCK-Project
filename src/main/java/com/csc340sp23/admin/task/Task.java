package com.csc340sp23.admin.task;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import jakarta.persistence.ManyToOne;
import com.csc340sp23.admin.employees.Employee;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;

/**
 *
 * @author Christopher Jacobs
 */
@AllArgsConstructor
@Entity
@Table(name = "task")
@NoArgsConstructor
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String taskName;
    private String taskDesc;
    private LocalDateTime taskStartTime = LocalDateTime.now();
    private LocalDateTime taskEndTime;
    private boolean taskCompleteStatus;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "employee_id")
    private Employee employee;
    
    public Task(String taskName, String taskDesc, Employee employee) {
        this.taskName = taskName;
        this.taskDesc = taskDesc;
        this.employee = employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
        employee.addTask(this); 
        employee.incrementTasksTotal(); 
    }
    
}
