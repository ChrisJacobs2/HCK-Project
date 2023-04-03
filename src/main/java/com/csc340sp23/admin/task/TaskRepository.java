package com.csc340sp23.admin.task;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Christopher Jacobs
 */
public interface TaskRepository extends JpaRepository<Task, Long> {

}
