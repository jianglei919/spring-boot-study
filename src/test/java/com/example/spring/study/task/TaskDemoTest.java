package com.example.spring.study.task;

import com.example.spring.study.task.timer.TimerTaskDemo;
import org.junit.Test;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * Created by jianglei on 2019/9/4.
 */
public class TaskDemoTest {

    @Test
    public void test1() {
        TimerTaskDemo taskDemo = new TimerTaskDemo();
        Timer timer = new Timer();
        //立刻开始执行timerTest任务，只执行一次
//        timer.schedule(taskDemo, new Date());

        //立刻开始执行timerTest任务，执行完本次任务后，隔2秒再执行一次
//        timer.schedule(taskDemo, new Date(), TimeUnit.SECONDS.toMillis(2));

        //一秒钟后开始执行timerTest任务，只执行一次
//        timer.schedule(taskDemo, TimeUnit.SECONDS.toMillis(1));

        //一秒钟后开始执行timerTest任务，执行完本次任务后，隔2秒再执行一次
//        timer.schedule(taskDemo, TimeUnit.SECONDS.toMillis(1), TimeUnit.SECONDS.toMillis(2));

        //立刻开始执行timerTest任务，每隔2秒执行一次
//        timer.scheduleAtFixedRate(taskDemo, new Date(), TimeUnit.SECONDS.toMillis(2));

        //一秒钟后开始执行timerTest任务，每隔2秒执行一次
        timer.scheduleAtFixedRate(taskDemo, TimeUnit.SECONDS.toMillis(1), TimeUnit.SECONDS.toMillis(2));

        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //结束任务执行，程序终止
        timer.cancel();
        //结束任务执行，程序并不终止,因为线程是JVM级别的
        taskDemo.cancel();
    }

}
