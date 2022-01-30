package com.beniregev.exam_challenges.simple_pojos;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>(Arrays.asList("a", "b", "c", "d", "e"));
        System.out.println("System.out.println(set): " + set);
        System.out.print("Using .forEach() method: ");
        set.forEach(System.out::print);
        System.out.println();
        System.out.print("Using Stream API: ");
        set.stream().forEach(System.out::print);
        System.out.println();
    }
}
