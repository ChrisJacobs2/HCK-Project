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

/**
 *
 * @author Christopher Jacobs
 */
@AllArgsConstructor
@Entity
@Table(name = "product")
@NoArgsConstructor
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String lastFirst;
    private int salary;
    private boolean isBusy;
    private int tasksCompleted;
    private int tasksFailed;

    public Employee(String lastFirst, int salary) {
        this.lastFirst = lastFirst;
        this.salary = salary;
        isBusy = false;
        tasksCompleted = 0;
        tasksFailed = 0;
    }

}
