package com.csc340sp23.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;





/**
 *
 * @author Hilda
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
    
}
