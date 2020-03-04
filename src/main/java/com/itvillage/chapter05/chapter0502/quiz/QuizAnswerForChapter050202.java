package com.itvillage.chapter05.chapter0502.quiz;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * interval, takeWhile을 이용하여 발행된 숫자가 10이 아닌동안 데이터를 1초에 한번씩 계속 출력하세요.
 */
public class QuizAnswerForChapter050202 {
    public static void main(String[] args) {
        Observable.interval(1000L, TimeUnit.MILLISECONDS)
                .takeWhile(data -> data != 10)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(10000L);
    }
}
