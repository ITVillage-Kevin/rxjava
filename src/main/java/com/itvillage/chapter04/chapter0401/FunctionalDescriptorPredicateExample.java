package com.itvillage.chapter04.chapter0401;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 함수 디스크립터의 Predicate 예제
 */
public class FunctionalDescriptorPredicateExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 6, 10, 30, 65, 70, 102);
        List<Integer> result = filter(numbers, n -> n > 30);

        for(int number : result)
            System.out.println(number);
    }

    private static <T> List<T> filter(List<T> numbers, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for(T number : numbers)
            if(p.test(number))
                result.add(number);

        return result;
    }
}
