package com.custom.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

/**
 * Created with IntelliJ IDEA.
 * User: farhan
 * Date: 2013-08-04
 * Time: 10:54 AM
 */
public class MainClass {
    public static void main(String argv[]) throws InterruptedException {
        ThreadPool tp = new ThreadPool(3,4);
        tp.execute(new TheTask("mytask1"));
        tp.execute(new TheTask("mytask2"));
        tp.execute(new TheTask("mytask3"));
        tp.execute(new TheTask("mytask4"));
        sleep(4000);
        tp.stop();
    }}
