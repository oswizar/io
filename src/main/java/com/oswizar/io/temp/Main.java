package com.oswizar.io.temp;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("相似度匹配：").append("开启").append("\n");
        sb.append("负荷相似度：").append(5).append("%\n");
        sb.append("发电相似度：").append(6).append("%\n");
        sb.append("天气相似度：").append(7).append("%\n");
        System.out.println(sb);

        System.out.println(LocalDate.now());
    }


    public static List<Map<String, String>> splitTimeRange(String timeDur) {
        // 验证输入不为空
        if (timeDur == null || timeDur.trim().isEmpty()) {
            throw new IllegalArgumentException("时间区间不能为空");
        }
        List<Map<String, String>> result = new ArrayList<>();
        // 使用、分隔字符串(如：00:00~00:30、01:30~03:30)
        String[] timeDurStrArr = timeDur.split("、");
        for (String timeDurItem : timeDurStrArr) {
            // 使用~分割字符串
            String[] parts = timeDurItem.split("~");
            // 验证分割结果
            if (parts.length != 2) {
                throw new IllegalArgumentException("时间区间格式不正确，应为'HH:mm~HH:mm'，实际为：" + timeDurItem);
            }
            // 验证时间格式
            String startTime = parts[0].trim();
            String endTime = parts[1].trim();
            // 封装结果
            Map<String, String> item = new HashMap<>();
            item.put("start_time", startTime);
            item.put("end_time", endTime);
            result.add(item);
        }
        return result;
    }

    public static List<LocalDate> getDateRange(LocalDate forecastDateStart, LocalDate forecastDateEnd) {
        // 非空校验
        Objects.requireNonNull(forecastDateStart, "起始日期forecastDateStart不能为null");
        Objects.requireNonNull(forecastDateEnd, "结束日期forecastDateEnd不能为null");

        List<LocalDate> dateList = new ArrayList<>();

        // 确保start <= end，若start > end则交换
        LocalDate start = forecastDateStart;
        LocalDate end = forecastDateEnd;
        if (start.isAfter(end)) {
            start = forecastDateEnd;
            end = forecastDateStart;
        }

        // 从start开始，逐天添加到列表，直到end
        LocalDate currentDate = start;
        while (!currentDate.isAfter(end)) {
            dateList.add(currentDate);
            currentDate = currentDate.plusDays(1); // 加1天
        }

        return dateList;
    }
}

