package com.chris.demo.practice;

/**
 * Created by wangchaohui on 2018/7/17.
 */
public class Generic<T> {
    private T value;

    public Generic(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
