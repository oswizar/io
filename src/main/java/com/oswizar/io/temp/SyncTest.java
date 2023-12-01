package com.oswizar.io.temp;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class SyncTest {

    private final ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {

        List<Integer> l1 = Stream.of(  3, 4, 5,6, 3, 4,5,6).collect(Collectors.toList());
        List<Integer> l2 = Stream.of(9, 8, 3, 4, 5).collect(Collectors.toList());

        String ids = "[\n" +
                "    {\n" +
                "        \"0\": \"免费\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"1\": \"微信收款\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"2\": \"仅积分支付\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"3\": \"收款至公司账户\"\n" +
                "    }\n" +
                "]";
        JSONArray jsonArray = JSONArray.parseArray(ids);
        System.out.println(jsonArray);
        jsonArray.remove(3);
        System.out.println(jsonArray);
//        System.out.println(Arrays.toString(array));


//        int[] arr = generateRandomArray(100, 50);
//        System.out.println(Arrays.toString(arr));
//        mergeSortByRecursion(arr, 0, arr.length - 1);
//        mergeSortByIteration(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSortByRecursion(int[] arr, int left, int right) {
        // > 边界检查，= 递归终止条件
        if (left >= right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        mergeSortByRecursion(arr, left, mid);
        mergeSortByRecursion(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void mergeSortByIteration(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        // 设置步长
        int step = 1;
        while (step <= right) {
            int low = left;
            // 依据步长合并每一组左[low, mid]、右[mid + 1, high]区间
            while (low <= right) {
                int mid = low + step - 1;
                // 左区间不足，提前结束
                if (mid > right) {
                    break;
                }
                int high = Math.min(mid + step, right);
                merge(arr, low, mid, high);
                // 更新下一组区间的起始位置
                low = high + 1;
            }
            // 1.步长翻倍前提前检查；2.额外防止溢出
            if (step > right / 2) {
                break;
            }
            // 步长翻倍
            step <<= 1;
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        if (mid < left || mid > right) {
            return;
        }
        int[] temp = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int p = 0;
        while (p1 <= mid && p2 <= right) {
            temp[p++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            temp[p++] = arr[p1++];
        }
        while (p2 <= right) {
            temp[p++] = arr[p2++];
        }
        for (int i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
        }
    }


    private static int[] generateRandomArray(int limit, int length) {
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            ans[i] = (int) (Math.random() * (limit + 1)) - (int) (Math.random() * (limit + 1));
        }
        return ans;
    }


}

