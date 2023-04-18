package com.csc340sp23.Account;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Christopher Jacobs
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
