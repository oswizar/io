package com.oswizar.lambda;

import com.oswizar.entity.Person;

@FunctionalInterface
public interface Executor {
    void execute(Person person);
}
