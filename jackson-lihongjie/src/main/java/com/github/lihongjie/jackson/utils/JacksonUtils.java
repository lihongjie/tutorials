package com.github.lihongjie.jackson.utils;

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

public class JacksonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    private static XmlMapper xmlMapper = new XmlMapper();

    private JacksonUtils() {

    }

    public static String xml2Json(String xml) throws IOException {
        JSONObject jsonObject = XML.toJSONObject(xml);

        Object json = objectMapper.readValue(jsonObject.toString(), Object.class);
        // java object -> json
        String output = objectMapper.writeValueAsString(json);
        return output;
    }

    public static String xml2Json(File file) throws IOException {

        InputStream inputStream = new FileInputStream(file);
        String xml = IOUtils.toString(inputStream, Charset.defaultCharset());
        return xml2Json(xml);
    }
}
