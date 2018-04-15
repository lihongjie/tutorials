package com.github.lihongjie.jackson.demo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonCollectionExample {

    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        JsonCollectionExample collectionExample = new JsonCollectionExample();
        collectionExample.convertToMapAndBack();
        collectionExample.convertToListAndBack();
    }

    public void convertToMapAndBack() throws IOException {

        String json = "{\"name\":\"mkyong\", \"age\":33}";
        Map<String, Object> map = mapper.readValue(json, new TypeReference<Map<String,Object>>(){});
        System.out.println(map);

        // 官网操作Map
        Map<String, Object> jsonMap = mapper.readValue(json, Map.class);
        System.out.println(jsonMap);

        // map -> json string
        String mapJson = mapper.writeValueAsString(jsonMap);
        System.out.println(mapJson);

        // 复杂的map
        String json2 = "{\"name\":{\"firstName\":\"mkyong\", \"lastName\":\"Kim\"}}";
        Map<String, Map<String, String>> map2 = mapper.readValue(json2, Map.class);
        System.out.println("复杂的map: " + map2);
    }

    public  void convertToListAndBack() throws IOException {
        String json = "[{\"name\":\"mkyong\"}, {\"name\":\"laplap\"}]";
        List<Staff> list = mapper.readValue(json, new TypeReference<List<Staff>>(){});
        System.out.println(list);


        // 官网操作List
        List<Staff> staffList = mapper.readValue(json, List.class);
        System.out.println(staffList);

        // list -> json string
        String listJson = mapper.writeValueAsString(staffList);
        System.out.println(listJson);
    }

}
