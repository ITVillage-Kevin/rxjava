package com.itvillage.chapter05.chapter0503.quiz;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;

public class QuizAnswerForChapter050302 {
    public static void main(String[] args) {
        Observable.range(2, 8)
                .filter(num -> num % 2 == 0)
                .flatMap(
                        num -> Observable.range(1, 9)
                        .map(row -> num + " * " + row + " = " + num * row)
                ).subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
