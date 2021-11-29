package com.oswizar.lambda;

import com.oswizar.entity.Person;

@FunctionalInterface
public interface NameChecker {
    boolean check(Person person);
}
