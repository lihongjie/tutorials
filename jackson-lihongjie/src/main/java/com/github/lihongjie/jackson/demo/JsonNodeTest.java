package com.github.lihongjie.jackson.demo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class JsonNodeTest {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        String json = "{\n" +
                "\"data\":{\n" +
                "\"name\":\"mkyong\",\n" +
                "\"age\":33,\n" +
                "\"position\":\"Developer\",\n" +
                "\"salary\":{\n" +
                "\t\"one\":\"1\",\n" +
                "\t\"two\":{\n" +
                "\t\t\"three\":\"3\"\n" +
                "\t}\n" +
                "},\n" +
                "\"skills\":[\"java\",\"python\"]\n" +
                "}\n" +
                "}";


        JsonNode root = objectMapper.readTree(json);

        List<String> list = Arrays.asList("data", "salarys", "ones");

        JsonNode dataNode = root.path("data");

        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if ("data".equals(str))
                continue;
            if (dataNode.isObject() && i != list.size() - 1) { // 防止数组越界
                replaceContainerNode(dataNode, list.get(i), i, list);
                break;
            } else {
                String key  = list.get(i);
                JsonNode node = dataNode.get(key);
                if (node != null) {
                    ((ObjectNode) dataNode).remove(key);
                    ((ObjectNode) dataNode).set("lihongjie", node);
                }


            }

        }

        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(root));

    }

    private static void replaceContainerNode(JsonNode jsonNode, String path, int i, List<String> list) {
        JsonNode node = jsonNode.get(path);
        if (node == null)
            return;
        if (node.isValueNode()) {
            String key  = list.get(i);
            ((ObjectNode) jsonNode).remove(key);
            ((ObjectNode) jsonNode).put("lihongjie", node.asText());

        } else if(node.isObject()) {
            i++;
            String key  = list.get(i);
            JsonNode temptNode = node.get(key);
            if (temptNode == null)
                return;
            replaceContainerNode(temptNode, list.get(i + 1), i + 1, list);
        } else if (node.isArray()) {
            String key  = list.get(i);
            ArrayNode arryNode = (ArrayNode) jsonNode.get(key);
            ((ObjectNode) jsonNode).remove(key);
            ((ObjectNode) jsonNode).set("lihongjie", arryNode);
        }
    }


}
