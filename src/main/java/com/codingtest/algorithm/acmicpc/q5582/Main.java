package com.codingtest.algorithm.acmicpc.q5582;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a,b;
        a = br.readLine();
        b = br.readLine();

        bw.write(getAnswer(a,b)+"");
        bw.flush();
    }

    private static int getAnswer(String a,String b){
        int n = a.length();
        int m = b.length();
        int max = 0;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(a.charAt(i) == b.charAt(j)){
                    if(i>0 && j>0)
                        dp[i][j] = dp[i-1][j-1] + 1;
                    else
                        dp[i][j] = 1;
                    max = Integer.max(max,dp[i][j]);
                }
            }
        }

        return max;
    }
}
