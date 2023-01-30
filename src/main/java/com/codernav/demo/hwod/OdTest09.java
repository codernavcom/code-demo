package com.codernav.demo.hwod;

public class OdTest09 {
    public static void main(String[] args) {
        int length = f(new int[]{0, 1, 2, 2, 3, 3, 4});
        System.out.println(length);
    }

    /**
     * 寻找不重复元素个数
     *
     * @param nums
     * @return
     */
    private static int f(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        // 第一次遍历：i=0,j=1 -> 0,1,2,2,3,3,4 i=1
        // 第二次遍历：i=1,j=2 -> 0,1,2,2,3,3,4 i=2
        // 第三次遍历：i=2,j=3 -> 0,1,2,2,3,3,4 i=2
        // 第四次遍历：i=2,j=4 -> 0,1,2,3,3,3,4 i=3
        // 第五次遍历：i=3,j=5 -> 0,1,2,3,3,3,4 i=3
        // 第六次遍历：i=3,j=6 -> 0,1,2,3,4,3,4 i=4
        for (int j = 1; j < nums.length; j++) {
            System.out.println("i:" + i + " j:" + j);
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
            for (int k = 0; k < nums.length; k++) {
                System.out.print(nums[k]);
            }
            System.out.println("\r\n"+i);
            System.out.println("\r\n");
        }


        return i+1;
    }
}
