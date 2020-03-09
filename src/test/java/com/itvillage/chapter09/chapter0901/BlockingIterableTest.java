package com.itvillage.chapter09.chapter0901;

import com.itvillage.common.CarMaker;
import io.reactivex.Observable;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
/**
 * blogkingIterable을 사용한 통지 데이터 테스트 예제
 */
public class BlockingIterableTest extends RxJavaTest {
    // 전체 CarMaker의 요소가 맞는지 모두 테스트한다.
    @Test
    public void getCarMakerIterableTest() {
        // when
        Iterable<CarMaker> iterable = sampleObservable.getCarMakerStream()
                .blockingIterable();

        Iterator<CarMaker> iterator = iterable.iterator();

        // then
        assertThat(iterator.hasNext(), is(true));

        assertThat(iterator.next(), is(CarMaker.CHEVROLET));
        assertThat(iterator.next(), is(CarMaker.HYUNDAE));
        assertThat(iterator.next(), is(CarMaker.SAMSUNG));
        assertThat(iterator.next(), is(CarMaker.SSANGYOUNG));
        assertThat(iterator.next(), is(CarMaker.KIA));

    }
}
