package org.example.interview.Impetus.R1;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ImpetusL1 {

    public static void main(String[] args) {

        Set<Employee> set = new HashSet<>();
        set.add(new Employee("1", "Ajay"));
        set.add(new Employee("1", "Ajay"));
        System.out.println(set.size());

        String a = "stress";
        Map<Character, Long> map = a.chars().mapToObj(c-> (char) c)
                .collect(Collectors.groupingBy(e->e, LinkedHashMap::new, Collectors.counting()));
        System.out.println(map);
        Map.Entry<Character, Long> characterLongEntry = map.entrySet().stream().filter(e -> e.getValue() != 1).findFirst().get();
        System.out.println(characterLongEntry);
        char character = characterLongEntry.getKey();
        long count = characterLongEntry.getValue();
        System.out.println("Character: " + character + ", Count: " + count);

        q1();
        System.out.println();
        q3();
        System.out.println();
        q4();


    }

    static void q1() {
        try {
            int i = 10/0;
        } catch (Exception e) {
            System.out.println("Exception occurred");
//        } catch (ArithmeticException e) {
//            System.out.println("ArithmeticException occurred");
        }
    }

    static int q3() {

        try {
            return 10/0;
        } catch (Exception e) {
            System.out.println("Exception occurred");
            return 0;
        } finally {
            System.out.println("in finally");
        }
    }

    static void q4() {
        try {
            int i = 10/0;
        } catch (Exception e) {
            System.out.println("Exception occurred");
            System.exit(1);
        } finally {
            System.out.println("in finally");
        }
    }
}

class Employee {

    String id;

    String name;

    public Employee(String id, String name){
        this.id = id;
        this.name = name;
    }
}

class SingletonClass{
    private static SingletonClass obj;

    private SingletonClass(){}

    public static SingletonClass getInstance(){
        if(obj == null){
            synchronized(SingletonClass.class){
                if(obj == null){
                    obj = new SingletonClass();
                }
            }
        }
        return obj;
    }
}
