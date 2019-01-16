package com.example.rxjavaimpl;

import org.junit.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.Observer;


/**
 * @author linghailong
 * @date on 2019/1/16
 * @email 105354999@qq.com
 * @describe :
 */
public class TestRx {
    @Test
    public void testSubscribe() {
        final Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext in thread" + Thread.currentThread().getName());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("onError in thread" + Thread.currentThread().getName());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete in thread" + Thread.currentThread().getName());
            }
        };

    }


}
