package com.example;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;

import java.io.*;
import java.util.Date;

public class Test {

    public static void main(String[] args) throws MarshalException, ValidationException, IOException {
//        Test.marshal();
        Test.unmarshal();

    }

    private static void marshal() throws MarshalException, ValidationException, IOException {
        // Create a new Person
        Person person = new Person("Ryan 'Mad Dog' Madden");
        person.setDateOfBirth(new Date(1955, 8, 15));

        // Create a File to marshal to
        Writer writer = new FileWriter("E:\\test.xml");

        // Marshal the person object
        Marshaller.marshal(person, writer);
    }

    private static void unmarshal() throws FileNotFoundException, MarshalException, ValidationException {

        // Create a Reader to the file to unmarshal from
        Reader reader = new FileReader("E:\\test.xml");

        // Marshal the person object
        Person person = (Person) Unmarshaller.unmarshal(Person.class, reader);

        person.toString();
    }
}
