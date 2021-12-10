package com.codingtest.algorithm.acmicpc.q14889;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Main {

    static int[][] array;
    static int n, answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        array = new int[n][n];
        for (int i = 0; i < n; i++) {
            array[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        find(0, 0, 0, 0, 0);
        bw.write(answer + "");
        bw.flush();
    }

    static void find(int remain, int score1, int score2, int t1, int t2) {
        if (remain == n) {
            if(t1 == t2) {
                answer = Integer.min(answer, Math.abs(score1 - score2) / 2);
            }
            return;
        }
        int sc = 0;
        for (int i = 0; i < n; i++) {
            sc += array[i][remain];
            sc += array[remain][i];
        }

        find(remain + 1, score1 + sc, score2, t1+1, t2);
        find(remain + 1, score1, score2 + sc, t1, t2+1);

    }
}
