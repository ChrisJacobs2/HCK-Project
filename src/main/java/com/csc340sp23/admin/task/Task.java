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
    private LocalDateTime taskStartTime;
    private LocalDateTime taskEndTime;
    private boolean taskCompleteStatus;
    
    public Task(String taskName, String taskDesc) {
        this.taskName = taskName;
        this.taskDesc = taskDesc;
        this.taskStartTime = LocalDateTime.now();
    }
    
}
