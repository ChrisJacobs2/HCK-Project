package com.csc340sp23.admin;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Christopher Jacobs
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
