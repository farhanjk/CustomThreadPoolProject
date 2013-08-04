package com.custom.threadpool;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * User: farhan
 * Date: 2013-08-04
 * Time: 10:56 AM
 * To change this template use File | Settings | File Templates.
 */
public class ThreadPool {

    private ArrayDeque<Runnable> taskStack = null;
    private List<PoolThread> threads = new ArrayList<PoolThread>();
    private boolean isStopped = false;

    public ThreadPool(int noOfThreads, int maxNoOfTasks){
        taskStack = new ArrayDeque<Runnable>(maxNoOfTasks);

        for(int i=0; i<noOfThreads; i++){
            threads.add(new PoolThread(taskStack));
        }
        for(PoolThread thread : threads){
            thread.start();
        }
    }

    public synchronized void  execute(Runnable task){
        if(this.isStopped) throw
                new IllegalStateException("ThreadPool is stopped");

        this.taskStack.addFirst(task);
    }

    public synchronized void stop(){
        this.isStopped = true;
        for(PoolThread thread : threads){
            thread.setStopped(true);
        }
    }

}