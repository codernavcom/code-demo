package com.codernav.demo.juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 任务串行化，后者使用前者的数据
 */
public class CompletableFutureDemo2 {
    public static void main(String[] args) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            String result1 = "1";
            System.out.println("task1 result:"+result1);
            return result1;
        });

        CompletableFuture<String> future = future1.thenApply(result -> {
            System.out.println("task2 success, task1 result:" + result);
            return result;
        });


        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}
