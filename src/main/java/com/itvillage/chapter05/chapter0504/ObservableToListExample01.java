package com.itvillage.chapter05.chapter0504;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.Observable;
import io.reactivex.Single;

import java.util.List;

/**
 * 각각의 통지 데이터를 List로 변환해서 Single로 한번만 통지하는 예제
 */
public class ObservableToListExample01 {
    public static void main(String[] args) {
        Single<List<Integer>> single = Observable.just(1, 3, 5, 7, 9)
                                                .toList();

        single.subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
