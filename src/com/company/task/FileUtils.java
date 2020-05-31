package com.company.task;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * All rights reserved & copyright ©
 */
class FileUtils {

    static String getContent(String path) {
        try {
            return new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    static void setContent(String path, String content) {
        File destination = new File(path);
        if(!destination.exists()) {
            try {
                destination.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            Files.write(Paths.get(path), content.getBytes(), StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
