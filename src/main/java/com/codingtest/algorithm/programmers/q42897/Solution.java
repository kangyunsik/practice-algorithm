package com.codingtest.algorithm.programmers.q42897;

import java.util.Arrays;

class Solution {
    int[] before;
    int[] not_before;
    int[] money;
    boolean flag = false;

    public int solution(int[] money) {
        int len = money.length;
        before = new int[len];
        not_before = new int[len];
        Arrays.fill(before, -1);
        Arrays.fill(not_before, -1);
        before[0] = money[0];
        before[1] = money[1];
        not_before[0] = 0;
        not_before[1] = money[0];
        this.money = money;

        getDP();

        for (int i = 0; i < len; i++) {
            System.out.print(before[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < len; i++) {
            System.out.print(not_before[i] + " ");
        }
        System.out.println();
        System.out.println("flag = " + flag);

        return Math.max(not_before[len - 1], before[len - 1]- money[0]);
//        if (flag) {
//            return Math.max(not_before[len-1], before[len-1]);
//        }else{
//            return Math.max(not_before[len-1], before[len-1] - money[0]);
//        }
    }

    public void getDP() {
        for (int i = 2; i < money.length; i++) {
            int stolen = not_before[i - 1] + money[i];
            int not_stolen = Math.max(before[i - 1], not_before[i - 1]);
            not_before[i] = not_stolen;
            before[i] = stolen;
            before[i] = Math.max(stolen , not_stolen);
        }
    }
}