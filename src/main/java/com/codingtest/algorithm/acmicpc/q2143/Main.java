package com.codingtest.algorithm.acmicpc.q2143;

import java.io.*;
import java.util.*;

public class Main {

    int n, m, t;
    int[] sumA;
    int[] sumB;
    long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        String as = br.readLine();
        int m = Integer.parseInt(br.readLine());
        String bs = br.readLine();

        Main main = new Main(t);
        main.setA(n,as);
        main.setB(m,bs);
        main.run();

        bw.write(main.getAnswer()+"\n");
        bw.flush();

    }

    public Main(int t) {
        this.t = t;
        this.answer = 0;
    }

    void run() {
        Map<Integer,Integer> aMap = new HashMap<>();
        Map<Integer,Integer> bMap = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int value = sumA[j]-sumA[i-1];
                aMap.put(value, aMap.get(value) == null ? 1 : aMap.get(value) + 1);
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= m; j++) {
                int value = sumB[j]-sumB[i-1];
                bMap.put(value, bMap.get(value) == null ? 1 : bMap.get(value) + 1);
            }
        }


        for (Integer aValue : aMap.keySet()) {
            if(bMap.get(this.t - aValue) != null){
                answer += (long)bMap.get(this.t - aValue) * aMap.get(aValue);
            }
        }
    }

    long getAnswer() {
        return this.answer;
    }

    void setA(int n, String input) {
        this.n = n;
        sumA = new int[n + 1];

        StringTokenizer st = new StringTokenizer(input, " ");
        for (int i = 0; i < n; i++) {
            sumA[i + 1] = sumA[i] + Integer.parseInt(st.nextToken());
        }
    }

    void setB(int m, String input) {
        this.m = m;
        sumB = new int[m + 1];

        StringTokenizer st = new StringTokenizer(input, " ");
        for (int i = 0; i < m; i++) {
            sumB[i + 1] = sumB[i] + Integer.parseInt(st.nextToken());
        }
    }
}
