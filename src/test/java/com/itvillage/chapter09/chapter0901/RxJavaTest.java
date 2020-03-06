package com.itvillage.chapter09.chapter0901;

import org.junit.BeforeClass;

public class RxJavaTest {
    protected static SampleObservable sampleObservable;

    @BeforeClass
    public static void setup(){
        sampleObservable = new SampleObservable();
    }
}
