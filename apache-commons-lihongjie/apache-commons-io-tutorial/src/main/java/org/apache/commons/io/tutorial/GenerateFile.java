package org.apache.commons.io.tutorial;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class GenerateFile {

    public static void main(String[] args) throws IOException {

        FileUtils.writeStringToFile(new File("D:\\20181006.json"), "ss", "UTF-8");
    }
}
