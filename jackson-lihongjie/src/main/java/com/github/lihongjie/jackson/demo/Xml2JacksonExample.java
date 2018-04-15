package com.github.lihongjie.jackson.demo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.json.XML;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * Convert XML to JSON and back
 */
public class Xml2JacksonExample {

    private static ObjectMapper objectMapper = new ObjectMapper();

    private static XmlMapper xmlMapper = new XmlMapper();

    public static void main(String[] args) throws IOException {

        Xml2JacksonExample xml2JacksonExample = new Xml2JacksonExample();

//        xml2JacksonExample.xml2json();
//        xml2JacksonExample.xml2json2();
        xml2JacksonExample.xml2json3();
    }

    public void xml2json() throws IOException {

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<root>\n" +
                "<name>Li Hongjie</name>\n" +
                "<age>26</age>\n" +
                "<position>Developer</position>\n" +
                "<salary>123456</salary>\n" +
                "<skills>\n" +
                "\t<skill>java</skill>\n" +
                "\t<skill>c++</skill>\n" +
                "</skills>\n" +
                "</root>";

        JsonNode jsonNode = xmlMapper.readTree(xml.getBytes());
        String json = objectMapper.writeValueAsString(jsonNode);
        System.out.println(json);

    }

    /**
     * 使用map存
     * @throws IOException
     */
    public void xml2json2() throws IOException {

        InputStream inputStream = new FileInputStream(new File("D:\\test.xml"));
        String xml = IOUtils.toString(inputStream, Charset.defaultCharset());
        Map<String, Object> list = xmlMapper.readValue(xml, Map.class);

        String json = objectMapper.writeValueAsString(list);

        System.out.println(json);

    }

    /**
     * 使用org.json 和 jackson 配合解析xml
     * 结果中没有去 根节点
     * @throws IOException
     */
    public void xml2json3() throws IOException {

        InputStream inputStream = new FileInputStream(new File("D:\\test.xml"));
        String xml = IOUtils.toString(inputStream, Charset.defaultCharset());
        JSONObject jsonObject = XML.toJSONObject(xml);

        Object json = objectMapper.readValue(jsonObject.toString(), Object.class);
        // java object -> json
        String output = objectMapper.writeValueAsString(json);
        System.out.println(output);

    }
}
