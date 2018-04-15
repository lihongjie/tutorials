package com.github.lihongjie.jackson.demo;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * JSON 转 Java Object
 * Java Object 转 JSON
 */
public class Jackson2Example {

    public static void main(String[] args) {
        Jackson2Example jackson2Example = new Jackson2Example();
//        jackson2Example.run();
        jackson2Example.run2();
    }


    private void run() {
        ObjectMapper mapper = new ObjectMapper();
        Staff staff = createDummyObject();

        // Convert object to JSON string and save into a file directly
        try {
            mapper.writeValue(new File("D:\\staff.json"), staff);
            // Convert object to JSON string
            String jsonInString = mapper.writeValueAsString(staff);
            System.out.println(jsonInString);

            // Convert object to JSON string and pretty print
            jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff);
            System.out.println(jsonInString);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void run2() {
        ObjectMapper mapper = new ObjectMapper();

        try {

            // Convert JSON string from file to Object
            Staff staff = mapper.readValue(new File("D:\\staff.json"), Staff.class);
            System.out.println(staff);

            // Convert JSON string to Object
            String jsonInString = "{\"name\":\"mkyong\",\"salary\":7500,\"skills\":[\"java\",\"python\"]}";
            Staff staff1 = mapper.readValue(jsonInString, Staff.class);
            System.out.println(staff1);

            //Pretty print
            String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff1);
            System.out.println(prettyStaff1);

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private Staff createDummyObject() {

        Staff staff = new Staff();

        staff.setName("mkyong");
        staff.setAge(33);
        staff.setPosition("Developer");
        staff.setSalary(new BigDecimal("7500"));

        List<String> skills = new ArrayList<>();
        skills.add("java");
        skills.add("python");

        staff.setSkills(skills);

        return staff;

    }
}
