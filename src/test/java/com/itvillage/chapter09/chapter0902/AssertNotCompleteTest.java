package com.itvillage.chapter09.chapter0902;

import com.itvillage.chapter09.chapter0901.RxJavaTest;
import com.itvillage.utils.TimeUtil;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * assertNotComplete를 이용하여 A 지점과 B 지점의 매출 합계 처리가 지정된 시간안에 끝나지않는지 검증하는 예제
 */
public class AssertNotCompleteTest extends RxJavaTest {
    @Test
    public void assertNotCompleteTest() {
        sampleObservable.getSalesOfBranchA()
                .zipWith(
                        sampleObservable.getSalesOfBranchB(),
                        (a, b) -> {
                            TimeUtil.sleep(1000L);
                            return a + b;
                        }
                )
                .test()
                .awaitDone(3000L, TimeUnit.MILLISECONDS)
                .assertNotComplete();
    }

}
