package com.itvillage.chapter05;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * 설정한 시간이 지난 후에 특정 동작을 수행하고자 할때 사용
 */
public class TimerExample {
    public static void main(String[] args){
        Observable<String> source = Observable.timer(2000, TimeUnit.MILLISECONDS)
                .map(count -> "Do work!");

        source.subscribe(msg -> Logger.on(msg));

        TimeUtil.sleep(3000);
    }
}
