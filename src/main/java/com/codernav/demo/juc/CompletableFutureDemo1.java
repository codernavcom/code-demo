package com.codernav.demo.juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 任务完成对结果进行处理，可同时处理有没有异常两种情况
 */
public class CompletableFutureDemo1 {
    public static void main(String[] args) {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            int j = 2 / 0;
        });

        future.handle((result, throwable)->{
            if (throwable == null) {
                System.out.println("任务没有异常");
            } else {
                System.out.println("任务有异常");
            }
            return result;
        });

        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}
