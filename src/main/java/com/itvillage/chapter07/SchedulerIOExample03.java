package com.itvillage.chapter07;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.io.File;

/**
 * Scheduler.io()를 이용한 파일 입/출력 예제
 * observeOn()을 여러개 지정하면 지정한 다음의 데이터 처리를 각각 개별 쓰레드에서 진행한다.
 */
public class SchedulerIOExample03 {
    public static void main(String[] args) {
        File[] files = new File("src/main/java/com/itvillage/").listFiles();

        Observable.fromArray(files)
                .doOnNext(file -> Logger.don("# 데이터 통지"))
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .filter(data -> data.isDirectory())
                .observeOn(Schedulers.computation())
                .map(dir -> dir.getName())
                .observeOn(Schedulers.computation())
                .subscribe(Logger::on);

        TimeUtil.sleep(1000L);
    }
}
