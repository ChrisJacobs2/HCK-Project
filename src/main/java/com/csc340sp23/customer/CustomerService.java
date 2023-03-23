package com.csc340sp23.customer;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hilda
 */
@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {

        return customerRepository.getReferenceById(id);

    }

    public void saveBooking(Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteBooking(Long id) {

        customerRepository.deleteById(id);
    }

}
