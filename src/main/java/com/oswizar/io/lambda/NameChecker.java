package com.oswizar.io.lambda;

import com.oswizar.io.entity.Person;

@FunctionalInterface
public interface NameChecker {
    boolean check(Person person);
}
