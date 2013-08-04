package com.custom.threadpool;

import static java.lang.Thread.sleep;

/**
 * Created with IntelliJ IDEA.
 * User: farhan
 * Date: 2013-08-03
 * Time: 8:16 PM
 */
public class TheTask implements Runnable{
    private String name;

    public TheTask(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        try {
            System.out.println("This is " + name);
            sleep(500);
            System.out.println("Executing " + name);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
