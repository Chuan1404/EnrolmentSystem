/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.formatter;

import com.java.pojos.Majors;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author jackc
 */
public class MajorsFormatter implements Formatter<Majors> {

    @Override
    public String print(Majors major, Locale locale) {
        return String.valueOf(major.getId());
    }

    @Override
    public Majors parse(String id, Locale locale) throws ParseException {
        Majors major = new Majors();
        major.setId(Integer.valueOf(id));
        return major;
    }
    
}
