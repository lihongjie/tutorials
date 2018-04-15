package com.github.lihongjie.jackson.demo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class TreeModelExample {

    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        TreeModelExample treeModel = new TreeModelExample();
        System.out.println("find-------------");
        treeModel.find();
        System.out.println("find2-------------");
        treeModel.find2();
        System.out.println("update-------------");
        treeModel.update();
    }

    public void add() {

    }

    public void update() throws IOException {
        JsonNode root = mapper.readTree(new File("D:\\user.json"));

        String resultOriginal = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
        System.out.println("Before Update " + resultOriginal);

        // 1. Update id to 1000
        ((ObjectNode) root).put("id", 1000L);

        String result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
        System.out.println("After Update id to 1000 " + result);

        // 2. If middle name is empty , update to M
        JsonNode nameNode = root.path("name");
        if ("".equals(nameNode.path("middle").asText())) {
            ((ObjectNode) nameNode).put("middle", "M");
        }

        // 2.1 change fieldName



        result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
        System.out.println("After Update middle name " + result);

        // 3. Create a new field in nameNode
        ((ObjectNode) nameNode).put("nickname", "mkyong");

        result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
        System.out.println("After Create a new field " + result);

        // 4. Remove 'last' field in nameNode
        ((ObjectNode) nameNode).remove("last");

        result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
        System.out.println("After Remove last field " + result);

        // 5. Create a new ObjectNode and add to root
        ObjectNode positionNode = mapper.createObjectNode();
        positionNode.put("name", "Developer");
        positionNode.put("years", 10);
        ((ObjectNode) root).set("position", positionNode);

        result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
        System.out.println("After Create a new ObjectNode " + result);

        // 6. Create a new ArrayNode and add to root
        ArrayNode gamesNode = mapper.createArrayNode();

        ObjectNode game1 = mapper.createObjectNode();
        game1.put("name", "Fall Out 4");
        game1.put("price", 49.9);

        ObjectNode game2 = mapper.createObjectNode();
        game2.put("name", "Dark Soul 3");
        game2.put("price", 59.9);

        gamesNode.add(game1);
        gamesNode.add(game2);
        ((ObjectNode) root).set("games", gamesNode);

        result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
        System.out.println("After Create a new ArrayNode " + result);

        // 7. Append a new Node to ArrayNode
        ObjectNode email = mapper.createObjectNode();
        email.put("type", "email");
        email.put("ref", "abc@mkyong.com");

        JsonNode contactNode = root.path("contact");
        ((ArrayNode) contactNode).add(email);

        result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
        System.out.println("After Append a new Node to ArrayNode " + result);
    }

    public void find() throws IOException {

        JsonNode root = mapper.readTree(new File("D:\\user.json"));
        // Get id
        Long id = root.path("id").asLong();
        System.out.println("id is :" + id);
        // Get Name , Map 结构
        JsonNode nameNode = root.path("name");
        if (nameNode.isMissingNode()) {
            // if "name" node is missing
        } else {

            String firstName = nameNode.path("first").asText();
            // missing node, just return empty string
            String middleName = nameNode.path("middle").asText();
            String lastName = nameNode.path("last").asText();
            System.out.println("firstName : " + firstName);
            System.out.println("middleName : " + middleName);
            System.out.println("lastName : " + lastName);
        }

        // Get Contact, Array 结构
        JsonNode contactNode = root.path("contact");
        if (contactNode.isArray()) {
            // If this node an Arrray?
        }

        for (JsonNode node : contactNode) {
            String type = node.path("type").asText();
            String ref = node.path("ref").asText();
            System.out.println("type : " + type);
            System.out.println("ref : " + ref);

        }
    }

    // 顶层是array
    public void find2() throws IOException {

        JsonNode rootArray = mapper.readTree(new File("D:\\user2.json"));

        for(JsonNode root : rootArray){

            Long id = rootArray.path("id").asLong();
            System.out.println("id is : " + id);
        }
    }

}
