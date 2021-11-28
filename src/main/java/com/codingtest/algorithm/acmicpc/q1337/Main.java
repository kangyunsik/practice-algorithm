package com.codingtest.algorithm.acmicpc.q1337;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, count, answer = 5;
        Set<Integer> set = new HashSet<>();
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }

        for (Integer value : set) {
            count = 0;
            for (int i = 1; i < 5; i++) {
                if(!set.contains(value + i)){
                    count++;
                }
            }
            answer = Math.min(answer, count);
        }
        System.out.println(answer);
    }
}
