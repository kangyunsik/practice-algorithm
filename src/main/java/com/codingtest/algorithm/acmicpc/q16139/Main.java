package com.codingtest.algorithm.acmicpc.q16139;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String input = br.readLine();
        int n = Integer.parseInt(br.readLine());
        prevCalc(input);
        StringBuilder sb = new StringBuilder();
        for (int i = 0, a, b, c; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a = st.nextToken().charAt(0) - 'a';
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            sb.append(executeQuery(a, b, c)).append("\n");
        }
        System.out.println(sb);
    }

    private static int executeQuery(int a, int b, int c) {
        if(b == 0) return sum[c][a];
        return sum[c][a] - sum[b - 1][a];
    }

    private static void prevCalc(String input){
        int len = input.length();
        sum = new int[len][26];
        sum[0][input.charAt(0) - 'a']++;
        for (int i = 1; i < len; i++) {
            sum[i][input.charAt(i) - 'a']++;
            for (int j = 0; j < 26; j++) {
                sum[i][j] += sum[i - 1][j];
            }
        }
    }
}