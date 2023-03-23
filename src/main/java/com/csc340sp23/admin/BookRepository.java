// BookRepository.java: A repository interface extending JpaRepository
package com.csc340sp23.admin;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Christopher Jacobs
 */
public interface BookRepository extends JpaRepository<Book, Long> {
    
}
