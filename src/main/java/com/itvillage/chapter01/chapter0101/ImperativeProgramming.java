package com.itvillage.chapter01.chapter0101;

import java.util.Arrays;
import java.util.List;

public class ImperativeProgramming {
    public static void main(String[] args){
        // List에 있는 숫자들 중에서 6보다 큰 홀수들의 합계를 구하세요.
        List<Integer> numbers = Arrays.asList(1, 3, 21, 10, 8, 11);
        int sum = 0;

        for(int number : numbers){
             if(number > 6 && (number % 2 != 0)){
                 sum += number;
             }
        }

        System.out.println("# 명령형 프로그래밍 사용: " + sum);
    }
}
