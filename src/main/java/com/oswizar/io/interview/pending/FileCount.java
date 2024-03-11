package com.oswizar.io.interview.pending;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FileCount {

    public static void main(String[] args) {
        // 统计指定文件夹下的各类型文件个数
        String path = "/Users/oswizar/Temp";
        File src = new File(path);
        HashMap<String, Integer> result = helper(src);
        System.out.println(result);
    }

    private static HashMap<String, Integer> helper(File src) {
        HashMap<String, Integer> hm = new HashMap<>();
        // 获取当前文件夹下的所有文件
        File[] files = src.listFiles();
        for (File file : files) {
            // 如果是文件就进行统计
            if (file.isFile()) {
                String fileName = file.getName();
                String[] split = fileName.split("\\.");
                // 获取文件类型
                String key = split[split.length - 1];
                // 文件类型已存在
                if (hm.containsKey(key)) {
                    // 同类型，个数累加
                    hm.put(key, hm.get(key) + 1);
                } else {
                    // 新类型，添加
                    hm.put(key, 1);
                }
            } else {
                // 如果是文件夹，进行递归处理
                HashMap<String, Integer> subHm = helper(file);
                Set<Map.Entry<String, Integer>> entries = subHm.entrySet();
                for (Map.Entry<String, Integer> entry : entries) {
                    String subKey = entry.getKey();
                    Integer subCount = entry.getValue();
                    // 文件类型已存在，个数求和
                    if (hm.containsKey(subKey)) {
                        hm.put(subKey, hm.get(subKey) + subCount);
                    } else {
                        // 新类型，添加
                        hm.put(subKey, subCount);
                    }
                }
            }
        }
        return hm;
    }
}
