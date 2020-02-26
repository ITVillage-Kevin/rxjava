package com.itvillage.chapter05.chapter0508;

import com.itvillage.utils.Logger;
import io.reactivex.Observable;

/**
 * 통지되는 데이터가 없을 경우, 디폴트 값을 통지하는 예제
 */
public class ObservableDefaultIfEmptyExample {
    public static void main(String[] args) {
        Observable.empty()
                .defaultIfEmpty("There is no item.")
                .subscribe(Logger::on);
    }
}
