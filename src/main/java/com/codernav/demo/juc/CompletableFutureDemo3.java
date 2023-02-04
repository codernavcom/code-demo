package com.codernav.demo.juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 任务串行化，后者不使用前者的数据
 */
public class CompletableFutureDemo3 {
    public static void main(String[] args) {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("task1 success.");
        });

        // 串行任务2，待上面任务结束后执行
        future.thenApply(unused -> {
            System.out.println("task2 success");
            return null;
        });


        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}
