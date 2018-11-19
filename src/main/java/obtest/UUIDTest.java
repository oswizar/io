package obtest;

import java.util.UUID;

/**
 * Copyright (C): 长安新生(深圳)金融投资有限公司
 * FileName: obtest.UUIDTest
 * Author:   xiexing
 * Date:     2018/11/13 16:50
 * Description: UUID生成
 */

public class UUIDTest {
    public static void main(String[] args) {
        String s = UUID.randomUUID().toString();
        System.out.println(s);
    }
}
