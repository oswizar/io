package com.xiexing.lambda;

import com.xiexing.entity.Person;

@FunctionalInterface
public interface Executor {
    void execute(Person person);
}
