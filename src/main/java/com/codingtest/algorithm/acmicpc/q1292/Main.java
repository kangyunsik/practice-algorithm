package com.codingtest.algorithm.acmicpc.q1292;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] sum = new int[1001];
        int cnt = 1;
        int cur = 1;
        for (int i = 1; i <= 1000; i++) {
            if(cnt == 0){
                cur++;
                cnt = cur;
            }
            sum[i] = sum[i-1] + cur;
            cnt--;
        }
        System.out.println((sum[b] - sum[a-1]));
    }
}
