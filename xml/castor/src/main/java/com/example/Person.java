package com.example;

import java.util.Date;

/** An simple person class */
public class Person implements java.io.Serializable {

    private String name = null;

    private Date dob = null;

    public Person() {
        super();
    }

    public Person(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dob;
    }

    public String getName() {
        return name;
    }

    public void setDateOfBirth(Date dob) {
        this.dob = dob;
    }

    public void setName(String name) {
        this.name = name;
    }
}
