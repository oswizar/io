package com.xiexing.lambda;

import com.xiexing.entity.Person;

@FunctionalInterface
public interface NameChecker {
    boolean check(Person person);
}
