package com.example.spring.study.testthread;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * Created by jianglei on 2019/12/16.
 */
public class Reconciliation {

    //订单队列
    private Queue pos;

    //派送单队列
    private Queue dos;

    private Executor executor = Executors.newFixedThreadPool(1);

    private final CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
        executor.execute(() -> doReconciliation());
    });

    public Object doReconciliation() {
        Object p = pos.peek();
        Object d = dos.peek();

        //执行对账操作

        //差异写入库
        return new Object();
    }

    public void future() {
        CompletableFuture<List> pFuture = CompletableFuture.supplyAsync(this::getDOrders);
        CompletableFuture<List> dFuture = CompletableFuture.supplyAsync(this::getDOrders);
//        pFuture.thenCombine(dFuture, this::doReconciliation).thenAccept();
    }

    public List<Object> getPOrders() {
        return Lists.newArrayList();
    }

    public List<Object> getDOrders() {
        return Lists.newArrayList();
    }

    private void selectOrderInfo() {
        Thread t1 = new Thread(() -> {
            while (true) {
                Object p = new Object();
                pos.add(p);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                Object d = new Object();
                dos.add(d);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
