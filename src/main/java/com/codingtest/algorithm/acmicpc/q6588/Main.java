package com.codingtest.algorithm.acmicpc.q6588;

import java.io.*;

public class Main {
    static boolean[] isNotPrime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        isNotPrime = new boolean[1000001];

        for (int i = 3; i < 1000001; i++) {
            if(!isNotPrime[i]){
                for (int j = i*2; j < 1000001; j+=i) {
                    isNotPrime[j] = true;
                }
            }
        }

        while(n != 0){
            boolean find = false;
            for (int i = 3; i <= n/2; i+=2) {
                if(!isNotPrime[i] && !isNotPrime[n-i]){
                    find = true;
                    bw.write(n + " = " + i + " + " + (n - i) + "\n");
                    bw.flush();
                    break;
                }
            }
            if(!find){
                bw.write("Goldbach's conjecture is wrong.\n");
                bw.flush();
            }
            n = Integer.parseInt(br.readLine());
        }
    }
}
