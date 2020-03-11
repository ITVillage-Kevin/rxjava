package com.itvillage.chapter09.chapter0901;

import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * blockingForEach를 사용해 통지된 데이터 전부를 테스트 한다.
 */
public class blockingForEachTest extends RxJavaTest {
    // A 구간의 속도 중에서 110 이상인 속도만 필터링이 되었는지 테스트
    @Test
    public void getSpeedOfSectionAForEachTest() {
        sampleObservable.getSpeedOfSectionA()
                .filter(speed -> speed > 110)
                .blockingForEach(speed -> assertThat(speed, greaterThan(110)));

    }
}
