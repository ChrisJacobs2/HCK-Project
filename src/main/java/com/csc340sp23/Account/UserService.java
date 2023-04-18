package com.csc340sp23.Account;

import java.util.List;

/**
 *
 * @author Javaguides.net
 */
public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
