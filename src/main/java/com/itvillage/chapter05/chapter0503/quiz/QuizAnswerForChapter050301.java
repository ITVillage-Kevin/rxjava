package com.itvillage.chapter05.chapter0503.quiz;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.Observable;

public class QuizAnswerForChapter050301 {
    public static void main(String[] args) {
        Observable.range(1, 15)
                .filter(num -> num % 2 == 0)
                .map(num -> Math.pow(num, 2))
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
