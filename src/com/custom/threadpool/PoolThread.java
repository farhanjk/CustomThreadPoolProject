package com.custom.threadpool;

import java.util.ArrayDeque;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * User: farhan
 * Date: 2013-08-04
 * Time: 10:59 AM
 **/
public class PoolThread extends Thread {

    private ArrayDeque<Runnable> taskStack = null;
    private boolean       isStopped = false;

    public PoolThread(ArrayDeque<Runnable> taskStack){
        this.taskStack = taskStack;
    }

    public void run(){
        while(!isStopped()){
            try{
                Runnable runnable = (Runnable) taskStack.removeFirst();
                runnable.run();
            } catch(Exception e){
                //log or otherwise report exception,
                //but keep pool thread alive.
            }
        }
    }

    public synchronized void setStopped(boolean stopped){
        isStopped = stopped;
    }

    public synchronized boolean isStopped(){
        return isStopped;
    }
}