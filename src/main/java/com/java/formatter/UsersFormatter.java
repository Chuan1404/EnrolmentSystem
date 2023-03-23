/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.formatter;

import com.java.pojos.Users;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author AnChuPC
 */
public class UsersFormatter implements Formatter<Users>{

    @Override
    public String print(Users user, Locale locale) {
        return String.valueOf(user.getId());
    }

    @Override
    public Users parse(String id, Locale locale) throws ParseException {
        Users u = new Users();
        u.setId(id);
        
        return u;
    }
    
}
