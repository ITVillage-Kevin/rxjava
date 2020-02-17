package com.itvillage.chapter05.chapter0502;

import com.itvillage.utils.Logger;
import io.reactivex.Observable;

public class ObservableSkipExample01 {
    public static void main(String[] args) {
        Observable.range(1, 15)
                .skip(3)
                .subscribe(Logger::on);
    }
}
