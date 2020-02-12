package com.itvillage.chapter04.chapter0402;

import java.util.function.Function;

/**
 * Class Name::static method 메서드 레퍼런스 예
 */
public class ClassNameStaticMethodExample {
    public static void main(String[] args) {
        // 람다 표현식 메서드 레퍼런스로 축약 전
        Function<String, Integer> f1 = (String s) -> Integer.parseInt(s);
        Integer result1 = f1.apply("3");
        System.out.println(result1);

        // 람다 표현식 메서드 레퍼런스로 축약 전
        Function<String, Integer> f2 = s -> Integer.parseInt(s);
        Integer result2 = f2.apply("3");
        System.out.println(result2);

        // 람다 표현식을 메서드 레퍼런스로 축약
        Function<String, Integer> f3 = Integer::parseInt;
        Integer result3 = f3.apply("3");
        System.out.println(result3);

    }
}
