package com.itvillage.chapter05.chapter0504;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.Observable;
import io.reactivex.Single;

import java.util.Map;

/**
 * 통지된 데이터에서 map의 키를 생성한 후, 각각의 키별로 원본 통지 데이터를 매핑해서 Map으로 반환하는 예제
 */
public class ObservableToMapExample01 {
    public static void main(String[] args) {
        Single<Map<String, String>> single =
                Observable.just("a-Alpha", "b-Bravo", "c-Charlie", "e-Echo")
                        .toMap(data -> data.split("-")[0]); // 반환값은 Map의 key가 된다.

        single.subscribe(map -> Logger.log(LogType.ON_NEXT, map));
    }
}
