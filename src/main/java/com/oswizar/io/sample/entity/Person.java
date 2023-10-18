package com.oswizar.io.sample.entity;

import lombok.*;

/**
 * @author : oswizar
 * @date : 2019/8/30 10:43
 * @description :
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String firstName;
    private String lastName;
    private int age;
}
