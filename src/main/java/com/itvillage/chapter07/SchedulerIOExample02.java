package com.itvillage.chapter07;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.io.File;

/**
 * Scheduler.io()를 이용한 파일 입/출력 예제
 * subscribeOn(), observeOn()을 모두 지정하면 데이터 통지와 데이터 처리를 개별 쓰레드에서 진행한다.
 */
public class SchedulerIOExample02 {
    public static void main(String[] args) {
        File[] files = new File("src/main/java/com/itvillage/").listFiles();

        Observable.fromArray(files)
                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .filter(data -> data.isDirectory())
                .map(dir -> dir.getName())
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(1000L);
    }
}
