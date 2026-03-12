package com.oswizar.io.util;

import java.io.*;
import java.util.Base64;

/**
 * Base64编码解码工具类
 * 提供文件、字节数组与Base64字符串之间的转换功能
 * 
 * @author oswizar
 */
public class Base64Utils {
    
    // 默认缓冲区大小：8KB
    private static final int DEFAULT_BUFFER_SIZE = 8192;
    
    // 私有构造方法，防止实例化
    private Base64Utils() {
        throw new UnsupportedOperationException("工具类不能实例化");
    }

    /**
     * 字节数组编码为Base64字符串
     *
     * @param bytes 字节数组
     * @return Base64编码字符串
     * @throws IllegalArgumentException 如果字节数组为空
     */
    public static String encode(byte[] bytes) {
        if (bytes == null) {
            throw new IllegalArgumentException("字节数组不能为空");
        }
        return Base64.getEncoder().encodeToString(bytes);
    }
    
    /**
     * Base64字符串解码为字节数组
     *
     * @param base64 Base64编码字符串
     * @return 解码后的字节数组
     * @throws IllegalArgumentException 如果Base64字符串为空或无效
     */
    public static byte[] decode(String base64) {
        if (base64 == null || base64.trim().isEmpty()) {
            throw new IllegalArgumentException("Base64字符串不能为空");
        }
        return Base64.getDecoder().decode(base64);
    }
    
    /**
     * 将文件编码成base64字符串（适合小文件）
     *
     * @param path 文件路径
     * @return 编码后的base64字符串
     * @throws IOException 如果文件读取失败
     * @throws IllegalArgumentException 如果路径为空或无效
     */
    public static String fileToBase64(String path) throws IOException {
        return fileToBase64(path, DEFAULT_BUFFER_SIZE);
    }
    
    /**
     * 将文件编码成base64字符串（支持大文件）
     *
     * @param path 文件路径
     * @param bufferSize 缓冲区大小
     * @return 编码后的base64字符串
     * @throws IOException 如果文件读取失败
     * @throws IllegalArgumentException 如果路径为空或无效
     */
    public static String fileToBase64(String path, int bufferSize) throws IOException {
        if (path == null || path.trim().isEmpty()) {
            throw new IllegalArgumentException("文件路径不能为空");
        }
        if (bufferSize <= 0) {
            throw new IllegalArgumentException("缓冲区大小必须大于0");
        }
        
        File file = new File(path);
        if (!file.exists() || !file.isFile()) {
            throw new FileNotFoundException("文件不存在或不是有效文件: " + path);
        }
        
        // 对于大文件，使用流式处理避免内存溢出
        if (file.length() > 10 * 1024 * 1024) { // 10MB以上使用流式处理
            try (InputStream in = new FileInputStream(file);
                 ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                byte[] buffer = new byte[bufferSize];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
                return Base64.getEncoder().encodeToString(out.toByteArray());
            }
        } else {
            // 小文件直接读取
            try (InputStream in = new FileInputStream(file)) {
                byte[] bytes = in.readAllBytes();
                return Base64.getEncoder().encodeToString(bytes);
            }
        }
    }

    /**
     * 将base64字符串解码为文件
     *
     * @param destPath 文件路径
     * @param base64   编码后的base64字符串
     * @param fileName 文件名
     * @throws IOException 如果文件写入失败
     * @throws IllegalArgumentException 如果参数无效
     */
    public static void base64ToFile(String destPath, String base64, String fileName) throws IOException {
        base64ToFile(destPath, base64, fileName, DEFAULT_BUFFER_SIZE);
    }
    
    /**
     * 将base64字符串解码为文件（支持自定义缓冲区大小）
     *
     * @param destPath 文件路径
     * @param base64   编码后的base64字符串
     * @param fileName 文件名
     * @param bufferSize 缓冲区大小
     * @throws IOException 如果文件写入失败
     * @throws IllegalArgumentException 如果参数无效
     */
    public static void base64ToFile(String destPath, String base64, String fileName, int bufferSize) throws IOException {
        if (destPath == null || destPath.trim().isEmpty()) {
            throw new IllegalArgumentException("目标路径不能为空");
        }
        if (base64 == null || base64.trim().isEmpty()) {
            throw new IllegalArgumentException("Base64字符串不能为空");
        }
        if (fileName == null || fileName.trim().isEmpty()) {
            throw new IllegalArgumentException("文件名不能为空");
        }
        if (bufferSize <= 0) {
            throw new IllegalArgumentException("缓冲区大小必须大于0");
        }
        
        // 创建文件目录
        File dir = new File(destPath);
        if (!dir.exists() && !dir.isDirectory()) {
            if (!dir.mkdirs()) {
                throw new IOException("无法创建目录: " + destPath);
            }
        }
        
        File file = new File(dir, fileName);
        byte[] bytes = Base64.getDecoder().decode(base64);
        
        // 对于大文件，使用流式写入
        if (bytes.length > 10 * 1024 * 1024) {
            try (FileOutputStream fos = new FileOutputStream(file); 
                 BufferedOutputStream bos = new BufferedOutputStream(fos, bufferSize)) {
                bos.write(bytes);
            }
        } else {
            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(bytes);
            }
        }
    }
    
    /**
     * URL安全的Base64编码（将+替换为-，/替换为_）
     *
     * @param bytes 字节数组
     * @return URL安全的Base64字符串
     */
    public static String encodeUrlSafe(byte[] bytes) {
        if (bytes == null) {
            throw new IllegalArgumentException("字节数组不能为空");
        }
        return Base64.getUrlEncoder().encodeToString(bytes);
    }
    
    /**
     * URL安全的Base64解码
     *
     * @param base64 URL安全的Base64字符串
     * @return 解码后的字节数组
     */
    public static byte[] decodeUrlSafe(String base64) {
        if (base64 == null || base64.trim().isEmpty()) {
            throw new IllegalArgumentException("Base64字符串不能为空");
        }
        return Base64.getUrlDecoder().decode(base64);
    }
    
    /**
     * 检查字符串是否为有效的Base64编码
     *
     * @param base64 待检查的字符串
     * @return 是否为有效的Base64编码
     */
    public static boolean isValidBase64(String base64) {
        if (base64 == null || base64.trim().isEmpty()) {
            return false;
        }
        
        try {
            Base64.getDecoder().decode(base64);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

}
