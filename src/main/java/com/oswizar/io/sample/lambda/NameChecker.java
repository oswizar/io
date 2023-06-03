package com.oswizar.io.sample.lambda;

import com.oswizar.io.sample.entity.Person;

@FunctionalInterface
public interface NameChecker {
    boolean check(Person person);
}
