package com.codingtest.algorithm.acmicpc.q11066;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static long[][] dp;
    static long[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int test_case = Integer.parseInt(br.readLine());
        for (int test = 0; test < test_case; test++) {
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), " ");
            dp = new long[n][n];
            sum = new long[n];
            for(int i=0;st.hasMoreTokens();i++){
                int input = Integer.parseInt(st.nextToken());
                if(i > 0)
                    sum[i] = sum[i-1] + input;
                else
                    sum[i] = input;
            }

            bw.write(getValue(0,n-1)+ "\n");
        }
        bw.flush();
    }

    private static long getSum(int i, int j){
        if(i == 0) return sum[j];
        else return sum[j] - sum[i-1];
    }

    private static long getValue( int i, int j){
        if(i == j || dp[i][j] != 0) return dp[i][j];

        long min = Long.MAX_VALUE;
        for (int k = i; k < j; k++) {
            min = Math.min(getValue(i, k) + getValue(k + 1, j), min);
        }
        return dp[i][j] = min + getSum(i,j);
    }
}
