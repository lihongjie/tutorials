package com.github.lihongjie.jackson.demo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class JsonArrayDemo {

    public static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        String json = "[{\"variant_number\":\"20187256108934\",\"variant_name\":\"大学生\"}]";

        List<ArrayTest> list = objectMapper.readValue(json, new TypeReference<List<ArrayTest>>(){});

        System.out.println(list.size());
    }
}
