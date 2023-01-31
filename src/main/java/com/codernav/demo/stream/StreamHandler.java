package com.codernav.demo.stream;

import com.codernav.demo.common.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamHandler {
    public static void main(String[] args) {
        Person person = new Person("zhangsan", 34, "1989-11-26");
        Person person1 = new Person("lisi", 30, "1992-05-30");
        Person person2 = new Person("wanger", 6, "2017-12-16");
        List<Person> persons = Arrays.asList(person, person1, person2);
        handler(persons);
    }

    public static void handler(List<Person> persons) {
        // 转name集合
        List<String> names = persons.stream().map(Person::getName).collect(Collectors.toList());
        System.out.println(names);

        // 过滤
        List<Person> persons1 = persons.stream().filter(p -> "zhangsan".equals(p.getName())).collect(Collectors.toList());
        System.out.println(persons1);

        // 转map 可重复
        Map<String, List<Person>> collect = persons.stream().collect(Collectors.groupingBy(Person::getName));
        System.out.println(collect);

        // 转map 重复取最后一个
        Map<String, Person> collect1 = persons.stream().collect(Collectors.toMap(Person::getName, Function.identity(), (key1, key2) -> key2));
        System.out.println(collect1);

        // 正序排序
        List<Person> collect2 = persons.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());
        System.out.println(collect2);

        // 倒叙排序
        List<Person> collect3 = persons.stream().sorted(Comparator.comparing(Person::getAge).reversed()).collect(Collectors.toList());
        System.out.println(collect3);

        // 最小值
        String s = persons.stream().map(Person::getBirthday).min(String::compareTo).get();
        System.out.println(s);

    }
}
