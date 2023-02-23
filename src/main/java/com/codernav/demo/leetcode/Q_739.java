package com.codernav.demo.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Q_739 {
    public static void main(String[] args) {
        int[] nums = f(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        int[] nums1 = dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        int[] nums2 = dailyTemperatures2(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }

    // 暴力算法
    private static int[] f(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }

    // 单调栈 方法一
    public static int[] dailyTemperatures(int[] temperatures) {

        int lens=temperatures.length;
        int []res=new int[lens];

        /**
         如果当前遍历的元素 大于栈顶元素，表示 栈顶元素的 右边的最大的元素就是 当前遍历的元素，
         所以弹出 栈顶元素，并记录
         如果栈不空的话，还要考虑新的栈顶与当前元素的大小关系
         否则的话，可以直接入栈。
         注意，单调栈里 加入的元素是 下标。
         */
        Deque<Integer> stack=new LinkedList<>();
        stack.push(0);
        for(int i=1;i<lens;i++){

            if(temperatures[i]<=temperatures[stack.peek()]){
                stack.push(i);
            }else{
                while(!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                    res[stack.peek()]=i-stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }

        return  res;
    }

    // 单调栈 方法二
    public static int[] dailyTemperatures2(int[] temperatures) {
        int lens=temperatures.length;
        int []res=new int[lens];
        Deque<Integer> stack=new LinkedList<>();
        for(int i=0;i<lens;i++){

            while(!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                res[stack.peek()]=i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        return  res;
    }
}
