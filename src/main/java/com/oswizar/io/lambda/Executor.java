package com.oswizar.io.lambda;

import com.oswizar.io.entity.Person;

@FunctionalInterface
public interface Executor {
    void execute(Person person);
}
