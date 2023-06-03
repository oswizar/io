package com.oswizar.io.sample.lambda;

import com.oswizar.io.sample.entity.Person;

@FunctionalInterface
public interface Executor {
    void execute(Person person);
}
