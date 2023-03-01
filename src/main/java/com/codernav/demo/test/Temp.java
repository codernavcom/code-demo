package com.codernav.demo.test;

import java.util.*;

public class Temp {
    public static void main(String[] args) {
        // 249->37 8->6
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++)
                list.add(i);
            int ind = 0;
            while (list.size() > 1) {
                ind = (ind + 2) % list.size();
                System.out.println("移除的元素索引："+ind);
                list.remove(ind);
            }
            System.out.println(list.get(0));
        }







    }
}
