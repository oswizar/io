package com.oswizar.io.util;

import java.util.Random;

/**
 * 随机数生成工具类
 * 提供各种随机数生成功能
 * 
 * @author oswizar
 */
public class RandomUtils {
    
    // 私有构造方法，防止实例化
    private RandomUtils() {
        throw new UnsupportedOperationException("工具类不能实例化");
    }
    
    // 共享的Random实例，避免重复创建
    private static final Random RANDOM = new Random();

    /**
     * 生成指定范围内的随机整数数组
     *
     * @param min 最小值（包含）
     * @param max 最大值（包含）
     * @param length 数组长度
     * @return 随机整数数组
     * @throws IllegalArgumentException 如果参数无效
     */
    public static int[] generateRandomArray(int min, int max, int length) {
        if (min > max) {
            throw new IllegalArgumentException("最小值不能大于最大值");
        }
        if (length <= 0) {
            throw new IllegalArgumentException("数组长度必须大于0");
        }
        
        int[] result = new int[length];
        int range = max - min + 1;
        
        for (int i = 0; i < length; i++) {
            result[i] = RANDOM.nextInt(range) + min;
        }
        return result;
    }
    
    /**
     * 生成包含正负数的随机数组（兼容旧版本）
     *
     * @param limit 数值范围限制
     * @param length 数组长度
     * @return 随机整数数组
     * @throws IllegalArgumentException 如果参数无效
     */
    public static int[] generateRandomArray(int limit, int length) {
        if (limit < 0) {
            throw new IllegalArgumentException("限制值不能为负数");
        }
        if (length <= 0) {
            throw new IllegalArgumentException("数组长度必须大于0");
        }
        
        int[] result = new int[length];
        int range = 2 * limit + 1; // 从-limit到limit的范围
        
        for (int i = 0; i < length; i++) {
            result[i] = RANDOM.nextInt(range) - limit;
        }
        return result;
    }

    /**
     * 随机生成一个指定行数和列数的二维数组
     *
     * @param rows 行数
     * @param cols 列数
     * @return 二维数组
     * @throws IllegalArgumentException 如果参数无效
     */
    public static int[][] generateRandom2DArray(int rows, int cols) {
        return generateRandom2DArray(rows, cols, 0, 99);
    }
    
    /**
     * 随机生成一个指定行数、列数和范围的二维数组
     *
     * @param rows 行数
     * @param cols 列数
     * @param min 最小值（包含）
     * @param max 最大值（包含）
     * @return 二维数组
     * @throws IllegalArgumentException 如果参数无效
     */
    public static int[][] generateRandom2DArray(int rows, int cols, int min, int max) {
        if (rows <= 0) {
            throw new IllegalArgumentException("行数必须大于0");
        }
        if (cols <= 0) {
            throw new IllegalArgumentException("列数必须大于0");
        }
        if (min > max) {
            throw new IllegalArgumentException("最小值不能大于最大值");
        }
        
        int[][] array = new int[rows][cols];
        int range = max - min + 1;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = RANDOM.nextInt(range) + min;
            }
        }
        return array;
    }
    
    /**
     * 生成随机整数
     *
     * @param min 最小值（包含）
     * @param max 最大值（包含）
     * @return 随机整数
     * @throws IllegalArgumentException 如果参数无效
     */
    public static int nextInt(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("最小值不能大于最大值");
        }
        int range = max - min + 1;
        return RANDOM.nextInt(range) + min;
    }
    
    /**
     * 生成随机双精度浮点数
     *
     * @param min 最小值（包含）
     * @param max 最大值（不包含）
     * @return 随机双精度浮点数
     * @throws IllegalArgumentException 如果参数无效
     */
    public static double nextDouble(double min, double max) {
        if (min >= max) {
            throw new IllegalArgumentException("最小值必须小于最大值");
        }
        return min + (max - min) * RANDOM.nextDouble();
    }
    
    /**
     * 生成随机布尔值
     *
     * @return 随机布尔值
     */
    public static boolean nextBoolean() {
        return RANDOM.nextBoolean();
    }
    
    /**
     * 从数组中随机选择一个元素
     *
     * @param array 数组
     * @param <T> 元素类型
     * @return 随机选择的元素
     * @throws IllegalArgumentException 如果数组为空或null
     */
    public static <T> T choose(T[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("数组不能为空");
        }
        return array[RANDOM.nextInt(array.length)];
    }
}
