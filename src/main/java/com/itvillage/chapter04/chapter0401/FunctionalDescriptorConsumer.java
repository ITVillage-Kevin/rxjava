package com.itvillage.chapter04.chapter0401;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * 함수 디스크립터의 Consumer 예제
 */
public class  FunctionalDescriptorConsumer {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 6, 10, 30, 65, 70, 102);
        forEachPrint(numbers, n -> System.out.println(n));
    }

    public static <T> void forEachPrint(List<T> numbers, Consumer<T> c) {
        for(T number : numbers)
            c.accept(number);
    }
}
