package com.itvillage.chapter05.chapter0502.quiz;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.Observable;

public class QuizAnswerForChapter050204 {
    public static void main(String[] args) {
        Observable.range(1, 15)
                .skipLast(3)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
