package com.codernav.demo.hwod;

import java.util.Scanner;

/**
 * @title 容器盛水问题
 * @Description 给定一个整形数组arr，已知其中所有的值都是非负的，将这个数组看作一个容器，请返回容器能装多少水。
 * @Author 开发者导航
 * @website https://www.codernav.com
 * @date 2023/3/9
 */
public class OdTest42 {
    public static void main(String[] args) {
        // 输入：[3,1,2,5,2,4] 输出：5
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] sArr = s.split(",");
            // 转成int
            int[] nums = new int[sArr.length];
            for (int i = 0; i < sArr.length; i++) {
                nums[i] = Integer.parseInt(sArr[i]);
            }
            if (nums.length < 1) {
                System.out.println("0");
            }

            // 定义左指针、右指针、左最小值、右最小值
            int left = 0;
            int right = nums.length - 1;
            int leftMaxValue = nums[left];
            int rightMaxValue = nums[right];
            // 定义盛水总量
            int result = 0;
            while (left < right) {
                // 左边比右边低
                if (leftMaxValue < rightMaxValue) {
                    left++;
                    // 当前位置大于左边最大值，更新左边最大值
                    if (nums[left] > leftMaxValue) {
                        leftMaxValue = nums[left];
                    } else {
                        // 当前位置小于左边最大值，就可以盛水了
                        result += leftMaxValue - nums[left];
                    }
                } else {
                    right--;
                    // 当前位置大于右边最大值，更新右边最大值
                    if (nums[right] > rightMaxValue) {
                        rightMaxValue = nums[right];
                    } else {
                        // 当前位置小于右边最大值，就可以盛水了
                        result += rightMaxValue - nums[right];
                    }
                }
            }
            System.out.println(result);
        }
    }
}
