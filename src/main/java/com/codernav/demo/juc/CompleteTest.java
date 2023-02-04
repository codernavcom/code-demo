package com.codernav.demo.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class CompleteTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<CompletableFuture<Integer>> tasks = new ArrayList<>();
        // 创建五个任务异步处理任务
        for (int i = 0; i < 5; i++) {
            final int t = i;
            CompletableFuture<Integer> task = CompletableFuture.supplyAsync(() -> {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(t + 1);
                return t + 1;
            });
            tasks.add(task);
        }

        // 待任务全部结束后求和
        int sum = 0;
        CompletableFuture.allOf(tasks.toArray(new CompletableFuture[tasks.size()]));
        for (CompletableFuture<Integer> task : tasks) {
            sum += task.get();
        }

        System.out.println(sum);

    }
}
