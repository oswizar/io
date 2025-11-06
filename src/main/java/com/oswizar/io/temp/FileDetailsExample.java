package com.oswizar.io.temp;

import org.apache.tika.Tika;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileDetailsExample {
    public static void main(String[] args) {
        File file = new File("/Users/oswizar/Temp/converter.sh"); // 指定文件路径
        String fileName = file.getName();
        String extension = getFileExtension(fileName);
        System.out.println("File extension: " + extension);

        try {
            String mimeType = getFileType(file);
            System.out.println("File type (MIME): " + mimeType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getFileExtension(String fileName) {
        if (fileName == null || fileName.lastIndexOf(".") == -1) {
            return ""; // 无扩展名
        }
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    private static String getFileType(File file) throws IOException {
        Tika tika = new Tika();
        return tika.detect(file);
    }
}
