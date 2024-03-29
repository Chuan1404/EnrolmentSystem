/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.repositories;

import com.java.enums.UserRole;
import com.java.pojos.Users;
import java.util.List;

/**
 *
 * @author AnChuPC
 */

public interface UsersRepository {
    public Users getUserById(String id);
    public boolean addOrUpdateUser(Users u);
    public Users getUsersByUsername(String name);
    public Users getUserByEmail(String email);
    List<Users> getUsersByUserRole(UserRole userRole);
}
