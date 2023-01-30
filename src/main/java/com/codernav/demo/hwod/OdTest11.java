package com.codernav.demo.hwod;

/**
 * 青蛙跳楼梯
 */
public class OdTest11 {
    public static void main(String[] args) {
        int way = f(10);
        System.out.println(way);
    }

    private static int f(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
//        if (n == 3) {
//            return 3;
//        }
        return f(n - 1) + f(n - 2);
    }


}
