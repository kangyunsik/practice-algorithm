package com.codingtest.algorithm.acmicpc.q14501;

import java.io.*;

public class Main {
    static int[] t;
    static int[] p;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        max = Integer.MIN_VALUE;
        int n = Integer.parseInt(br.readLine());
        t = new int[n];
        p = new int[n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            t[i] = Integer.parseInt(input[0]);
            p[i] = Integer.parseInt(input[1]);
        }

        find(0, 0, 0);
        bw.write(max+"");
        bw.flush();
    }

    private static void find(int current, int sum, int next_avail){
        if(current == t.length){
            if(next_avail <= t.length && max < sum) {
                max = sum;
            }
            return;
        }

        if(next_avail <= current){
            find(current+1,sum + p[current], t[current] + current);
        }
        find(current+1,sum,next_avail);

    }
}
