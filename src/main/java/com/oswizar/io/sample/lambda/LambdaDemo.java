package com.oswizar.io.sample.lambda;

import com.oswizar.io.sample.entity.Person;
import lombok.extern.slf4j.Slf4j;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @date: 2019/5/6 14:23
 * @author: oswizar
 * @description:
 */
@Slf4j
public class LambdaDemo {

//    public static void checkAndExecute(
//            List<Person> personList,
//            Predicate<Person> nameChecker,
//            Consumer<Person> executor) {
//
//        for (Person person : personList) {
//            if (nameChecker.test(person)) {
//                executor.accept(person);
//            }
//        }
//
//        personList.forEach(p -> {
//            if (nameChecker.test(p)) {
//                executor.accept(p);
//            }
//        });
//    }

    
    public void print() {

        List<Person> guiltyPersons = Arrays.asList(
//                new Person("Yixing", "Zhao", 25),
//                new Person("Yanggui", "Li", 30),
//                new Person("Chao", "Ma", 29)
        );

//        checkAndExecute(
//                guiltyPersons,
//                p -> p.getLastName().startsWith("Z"),
//                p -> System.out.println(p.getFirstName())
//        );
        guiltyPersons.stream()
                .filter(person -> person.getLastName().startsWith("Z"))
//                .forEach(person -> System.out.println(person.getFirstName()));
                .forEach(System.out::println);
    }

    public Person getPerson() {
        return new Person("Chao", "Ma", 29);
    }


    
    public void optionalTest() {
//        Person person = new Person("Chao", "Ma", 25);
        Person person = null;
        Optional<Person> personOpt = Optional.ofNullable(person);
//        personOpt.ifPresent(System.out::println);

//        System.out.println(personOpt.orElse(getPerson()));

//        System.out.println(personOpt.orElseGet(()->getPerson()));


        System.out.println(personOpt.map(p -> p.getLastName())
                .map(name -> name.toUpperCase())
                .orElseGet(() -> String.valueOf(getPerson())));


    }
}
