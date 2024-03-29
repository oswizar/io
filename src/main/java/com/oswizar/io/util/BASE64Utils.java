package com.oswizar.io.util;

import java.io.*;
import java.util.Base64;

public class BASE64Utils {

    /**
     * 将文件编码成base64字符串
     *
     * @param path 文件路径
     * @return 编码后的base64字符串
     */
    public static String fileToBase64(String path) {
        String base64 = null;
        File file = new File(path);
        try (InputStream in = new FileInputStream(file)) {
            byte[] bytes = new byte[(int) file.length()];
            int read = in.read(bytes);
            base64 = Base64.getEncoder().encodeToString(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return base64;
    }


    /**
     * 将base64字符串解码为文件
     *
     * @param destPath 文件路径
     * @param base64   编码后的base64字符串
     * @param fileName 文件名
     */
    public static void base64ToFile(String destPath, String base64, String fileName) {
        File file = null;
        //创建文件目录
        File dir = new File(destPath);
        if (!dir.exists() && !dir.isDirectory()) {
            boolean mkdirs = dir.mkdirs();
        }
        file = new File(destPath + "/" + fileName);
        try (FileOutputStream fos = new FileOutputStream(file); BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            byte[] bytes = Base64.getDecoder().decode(base64);

            bos.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
