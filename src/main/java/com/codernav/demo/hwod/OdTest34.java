package com.codernav.demo.hwod;

/**
 * 柠檬水找零（吊炸天！）
 * 在柠檬水摊上，每一杯柠檬水的售价为5美元。
 * 顾客排队购买你的产品，一次购买一杯。
 * 每位顾客只买一杯柠檬水，然后向你付5美元,10元或20美元。你必须给每个顾客正确找零。
 * 注意，一开始你手头没有任何零钱。
 * 如果你能给每位顾客正确找零，返回true，否则返回false。
 * 原文地址：https://www.codernav.com/2845.html
 * 更多算法详解：https://www.codernav.com
 */
public class OdTest34 {
    public static void main(String[] args) {
        boolean result = f(new int[]{5, 5, 5, 10, 5, 20, 5, 10, 5, 20});
        System.out.println(result);
    }

    private static boolean f(int[] bills) {
        // 5元零钱个数
        int five = 0;
        // 10元零钱个数
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                ten++;
                five--;
            } else if (bill == 20) {
                if (ten > 0) {
                    ten--;
                    five--;
                } else {
                    five -= 3;
                }
            }
            // 核心代码：5元零钱够不够用，小于0说明不够找零
            if (five < 0) {
                return false;
            }
        }
        return true;
    }
}
