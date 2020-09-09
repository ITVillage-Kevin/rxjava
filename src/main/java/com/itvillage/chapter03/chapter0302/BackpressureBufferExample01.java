package com.itvillage.chapter03.chapter0302;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;
/**
 * - DROP_LATEST 전략 : 버퍼가 가득 차면 생산자쪽에서 통지된 데이터는 DROP이 되고 버퍼가 비워지는 시점에 가장 나중에
 * DROP 된 데이터부터 버퍼에 다시 채워진다.
 * - 처리 과정
 *            생산자                            버퍼                                 소비자
 *      0.5초 후, 0을 통지 함 -> 0을 버퍼에 저장 후, 소비자쪽에 통지            ->   0을 전달 받음(처리 시작)
 *
 *      0.5초 후, 1을 통지 함 -> 소비자 쪽에서 전달 받은 0이                   ->   0을 처리중(처리 누적 시간: 0.5초)
 *                              처리 되지 않았으므로 버퍼 비우지 않음(1 DROP)
 *
 *      0.5초 후, 2를 통지 함 -> 소비자 쪽에서 전달 받은 0이                   ->    0 처리 완료(처리 누적 시간: 1초)
 *                              처리 되지 않았으므로 버퍼 비우지 않음(2 DROP)
 *
 *      0.5초 후, 3을 통지 함 -> 가장 최근에 DROP 된 2를 버퍼에 저장 후,        ->   2를 전달 받음(처리 시작)
 *                              소비자 쪽에 2를 통지(3 DROP)
 *
 *      0.5초 후, 4를 통지 함 -> 소비자 쪽에서 전달 받은 2가
 *                              처리 되지 않았으므로 버퍼 비우지 않음(3 DROP)   -> 2를 처리 중(처리 누적 시간: 0.5초)
 *
 *      0.5초 후, 5를 통지 함 -> 소비자 쪽에서 전달 받은 0이
 *                              처리 되지 않았으므로 버퍼 비우지 않음(4 DROP)   -> 2 처리 완료(처리 누적 시간: 1초)
 *
 *      0.5초 후, 6을 통지 함 -> 가장 최근에 DROP 된 4를 버퍼에 저장 후,         -> 4를 전달 받음(처리 시작)
 *                              소비자 쪽에 4를 통지(6 DROP)
 *
 *      0.5초 후, 7을 통지 함 -> 소비자 쪽에서 전달 받은 4가
 *                              처리 되지 않았으므로 버퍼 비우지 않음(7 DROP)   -> 4를 처리 중(처리 누적 시간: 0.5초)
 *
 *      통지 완료            ->  소비자 쪽에서 전달 받은 4가
 *                              처리 되지 않았으므로 버퍼 비우지 않음           -> 4를 처리 완료(처리 누적 시간: 1초)
 *
*/
public class BackpressureBufferExample01 {
    public static void main(String[] args){

        Flowable.interval(500L, TimeUnit.MILLISECONDS)
                .onBackpressureBuffer(
                        1,
                        () -> Logger.log(LogType.PRINT, ""),
                        BackpressureOverflowStrategy.DROP_LATEST)
//                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
                .observeOn(Schedulers.computation(), false, 1)
                .subscribe(
                        data -> {
                            TimeUtil.sleep(1000L);
                            Logger.log(LogType.ON_NEXT, data);
                        },
                        error -> Logger.log(LogType.ON_ERROR, error)
                );

        TimeUtil.sleep(4000L);
    }
}
