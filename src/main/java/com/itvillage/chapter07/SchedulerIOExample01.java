package com.itvillage.chapter07;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.io.File;

/**
 * Scheduler.io()를 이용한 파일 입/출력 예제
 * subscribeOn() 만 지정하면 데이터 통지 및 처리를 모두 RxCachedThreadScheduler 쓰레드에서 실행한다.
 */
public class SchedulerIOExample01 {
    public static void main(String[] args) {
        File[] files = new File("src/main/java/com/itvillage/").listFiles();

        Observable.fromArray(files)
                .doOnNext(Logger::don)
                .filter(data -> data.isDirectory())
                .map(dir -> dir.getName())
                .subscribeOn(Schedulers.io())
                .subscribe(Logger::on);

        TimeUtil.sleep(1000L);

    }
}
