package com.codingtest.algorithm.acmicpc.q1644;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static boolean[] prime;
    static int n, answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Long> primeDP = new ArrayList<>();
        n = sc.nextInt();
        prime = new boolean[n + 1];
        Arrays.fill(prime, true);

        getEratos();
        for (int i = 0; i < prime.length; i++) {
            if(prime[i]){
                if(primeDP.size() == 0)
                    primeDP.add((long)i);
                else
                    primeDP.add(primeDP.get(primeDP.size() - 1) + i);
            }
        }

        int left = 0;
        int right = 0;
        while(right < primeDP.size()){
            long sum;
            sum = primeDP.get(right);
            if(left != 0)
                sum -= primeDP.get(left - 1);

            if(sum == n){
                right++;
                answer++;
            }else if(sum > n){
                left++;
            }else{
                right++;
            }
        }

        System.out.println(answer);
    }

    private static void getEratos() {
        prime[0] = false;
        prime[1] = false;
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                for (int j = i * 2; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
    }
}
