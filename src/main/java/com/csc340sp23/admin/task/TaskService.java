package com.csc340sp23.admin.task;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Christopher Jacobs
 */
@Service
public class TaskService {
    
    @Autowired
    private TaskRepository repo;

    public List<Task> getAllTasks() {
        return repo.findAll();
    }

    public Task getTask(long taskId) {
        return repo.getReferenceById(taskId);
    }

    public void deleteTask(long taskId) {
        repo.deleteById(taskId);
    }

    public void saveTask(Task task) {

        repo.save(task);
    }
}
