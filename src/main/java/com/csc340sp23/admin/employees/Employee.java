package com.csc340sp23.admin.employees;

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
import java.util.List;
import com.csc340sp23.admin.task.Task;
import jakarta.persistence.OneToMany;

/**
 *
 * @author Christopher Jacobs
 */
@AllArgsConstructor
@Entity
@Table(name = "employee")
@NoArgsConstructor
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String last;
    private String first;
    private String position;
    private LocalDateTime dateHired = LocalDateTime.now();
    private int salary;
    private boolean isBusy;
    private int tasksTotal;
    private int tasksSuccess;
    
    
    @OneToMany(mappedBy = "employee")
    private List<Task> tasks;

    public Employee(String lastName, String firstName, String position, int salary) {
        this.last = lastName;
        this.first = firstName;
        this.position = position;
        this.salary = salary;
        isBusy = false;
        tasksTotal = 0;
        tasksSuccess = 0;
        
    }
    
    public Employee(String last, String first) {
        this.last = last;
        this.first = first;
    }
    
    public void addTask(Task task) {
        tasks.add(task);
    }
    
    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public void incrementTasksTotal() {
        tasksTotal++;
    }
    
    public void decrementTasksTotal() {
        tasksTotal--;
    }

}
