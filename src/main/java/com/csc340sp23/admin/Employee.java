package com.csc340sp23.admin;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
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
//    private String position;
//    private LocalDateTime dateHired;
//    private int salary;
//    private boolean isBusy;
//    private int tasksTotal;
//    private int tasksSuccess;

//    public Employee(String lastName, String firstName, String position, int salary) {
//        this.lastName = lastName;
//        this.firstName = firstName;
//        this.position = position;
//        this.salary = salary;
//        isBusy = false;
//        tasksTotal = 0;
//        tasksSuccess = 0;
//        this.dateHired = LocalDateTime.now();
//    }
    public Employee(String last, String first) {
        this.last = last;
        this.first = first;
    }

}
