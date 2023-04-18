package com.csc340sp23.Account;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Christopher Jacobs
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
