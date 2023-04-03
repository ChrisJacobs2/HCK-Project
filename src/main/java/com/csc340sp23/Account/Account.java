package com.csc340sp23.Account;

import com.csc340sp23.customer.Booking;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "account")
@NoArgsConstructor
@Getter
@Setter
public class Account {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private int roomNumber;
    private String firstName;
    private String lastName;
    private String roles;
    private String email;
    private Booking currentBooking;
    
    public Account (String username, String password, 
                    String firstName, String lastName, 
                    String roles, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = roles;
        this.email = email;
        roomNumber = -1;
        currentBooking = null;
    }
}
