package com.github.lihongjie.jackson.demo;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * For “Normal view”, salary will be hidden, for “Manager view”, display everything.
 * To enable the @JsonView features, use the following methods :
 * 1.mapper.writerWithView(“view class”).writeValue()
 * 2.mapper.readerWithView(“view class”).readValue()
 */
public class JsonViewExample {

    public static void main(String[] args) {
        JsonViewExample jsonViewExample = new JsonViewExample();
        jsonViewExample.run();
    }

    private void run() {
        ObjectMapper mapper = new ObjectMapper();

        try {

            StaffJsonView staff = mapper.readValue(new File("D:\\staff.json"), StaffJsonView.class);
            // Salary will be hidden
            System.out.println("Normal View");
            String normalView = mapper.writerWithView(Views.Normal.class).writeValueAsString(staff);
            System.out.println(normalView);

            String jsonInString = "{\"name\":\"mkyong\",\"age\":33,\"position\":\"Developer\",\"salary\":7500,\"skills\":[\"java\",\"python\"]}";
            StaffJsonView normalStaff = mapper.readerWithView(Views.Normal.class).forType(StaffJsonView.class).readValue(jsonInString);
            System.out.println(normalStaff);

            // Display everything
            System.out.println("\nManager View");
            String managerView = mapper.writerWithView(Views.Manager.class).writeValueAsString(staff);
            System.out.println(managerView);

            StaffJsonView managerStaff = mapper.readerWithView(Views.Manager.class).forType(StaffJsonView.class).readValue(jsonInString);
            System.out.println(managerStaff);

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * output:
 *
 * Normal View
 {"name":"mkyong","age":33,"position":"Developer","skills":["java","python"]}
 StaffJsonView{name='mkyong', age=33, position='Developer', salary=null, skills=[java, python]}

 Manager View
 {"name":"mkyong","age":33,"position":"Developer","salary":7500,"skills":["java","python"]}
 StaffJsonView{name='mkyong', age=33, position='Developer', salary=7500, skills=[java, python]}

 */
