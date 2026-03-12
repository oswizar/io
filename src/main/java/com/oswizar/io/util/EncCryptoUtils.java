package com.oswizar.io.util;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;

/**
 * Jasypt ENC(...) 加解密工具类
 * 支持自定义算法、密钥、迭代次数等
 */
public class EncCryptoUtils {

    /**
     * 解密 ENC(...) 格式的字符串
     *
     * @param encValue 格式如 "ENC(Dh2QfOEyw43jRbj1lMWNQRWaKryUiX3m)"
     * @param password 解密密钥（必须与加密时一致）
     * @return 明文
     */
    public static String decrypt(String encValue, String password) {
        if (encValue == null || !encValue.startsWith("ENC(") || !encValue.endsWith(")")) {
            throw new IllegalArgumentException("Invalid ENC format: " + encValue);
        }
        String encrypted = encValue.substring(4, encValue.length() - 1); // 去掉 ENC(...)
        StandardPBEStringEncryptor encryptor = buildEncryptor(password);
        return encryptor.decrypt(encrypted);
    }

    /**
     * 加密明文为 ENC(...) 格式
     *
     * @param plainText 明文
     * @param password  加密密钥
     * @return 格式如 "ENC(Kx9aB2cD...xyz)"
     */
    public static String encrypt(String plainText, String password) {
        StandardPBEStringEncryptor encryptor = buildEncryptor(password);
        String encrypted = encryptor.encrypt(plainText);
        return "ENC(" + encrypted + ")";
    }

    /**
     * 构建 Jasypt 加密器（可扩展配置）
     */
    private static StandardPBEStringEncryptor buildEncryptor(String password) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();

        // 配置（使用默认安全算法）
        EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
        config.setPassword(password);

        // 默认算法：PBEWITHHMACSHA512ANDAES_256（强安全）
        config.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
        config.setKeyObtentionIterations("1000");      // 迭代次数（防暴力破解）
        config.setPoolSize("1");                       // 连接池大小
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");          // 输出 Base64

        encryptor.setConfig(config);
        return encryptor;
    }

    // ==================== 兼容旧算法（如 PBEWithMD5AndDES）====================
    public static String encryptWithLegacy(String plainText, String password) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(password);
        encryptor.setAlgorithm("PBEWithMD5AndDES"); // ⚠️ 不推荐，仅用于兼容
        return "ENC(" + encryptor.encrypt(plainText) + ")";
    }

    public static String decryptWithLegacy(String encValue, String password) {
        if (encValue == null || !encValue.startsWith("ENC(") || !encValue.endsWith(")")) {
            throw new IllegalArgumentException("Invalid ENC format");
        }
        String encrypted = encValue.substring(4, encValue.length() - 1);
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(password);
        encryptor.setAlgorithm("PBEWithMD5AndDES");
        return encryptor.decrypt(encrypted);
    }


    public static void main(String[] args) throws Exception {
        String password = "eTKEhteEG"; // ← 加解密密钥（必须保密！）

        // 1. 加密
        String plain = "mwkTyhsWgH9jQrDx";
        String encResult = EncCryptoUtils.encryptWithLegacy(plain, password);
        System.out.println("加密结果: " + encResult);
        // 输出: ENC(Dh2QfOEyw43jRbj1lMWNQRWaKryUiX3m)

//        "eyZjco0/G20Fk8Tf1RCPH8RB0XBKxxN+ODsNBgpNKbo="

//        String  encResult =  "ENC(eyZjcoO/G2OFk8TflRCPH8RBOXBKxxN+ODsNBgpNKbo=)";

        // 2. 解密
        String decrypted = EncCryptoUtils.decryptWithLegacy(encResult, password);
        System.out.println("解密结果: " + decrypted);
        // 输出: myDatabasePassword!

        // 验证
//        assert plain.equals(decrypted);
    }
}
