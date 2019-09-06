package com.xiexing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : oswizar
 * @date : 2019/8/30 10:43
 * @description :
 */
@Data
@AllArgsConstructor
public class Person {
    private String firstName;
    private String lastName;
    private int age;
}
