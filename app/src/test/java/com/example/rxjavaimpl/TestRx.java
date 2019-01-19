package com.example.rxjavaimpl;

import org.junit.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


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
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {

            }
        }).observeOn(AndroidSchedulers.mainThread()) //回调在主线程
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Integer>() {


            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }

        });

    }


}
