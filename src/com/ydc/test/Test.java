package com.ydc.test;

/**
 * Created by ydc on 17-2-8.
 */
public class Test {

    public static void main(String[] args) {
        T t = new T();
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                try {
                    t.do1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                try {
                    t.do2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread1.start();
        thread2.start();
    }
}

class T {

    Object a = new Object();
    Object b = new Object();

    public void do1() throws InterruptedException {
        synchronized (this.a) {
            Thread.sleep(100);
            System.out.println("do1……");
            synchronized (this.b) {
            }
        }
    }

    public void do2() throws InterruptedException {

        synchronized (this.b) {
            Thread.sleep(100);
            System.out.println("do2……");
            synchronized (this.a) {
            }
        }

    }
}
