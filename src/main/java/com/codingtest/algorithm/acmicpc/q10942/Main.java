package com.codingtest.algorithm.acmicpc.q10942;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static int[][] dp;
    static int[] array;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        array = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(br.readLine());
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
            dp[i][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int ans = getDP(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1);
            bw.write(ans+"\n");
        }
        bw.flush();
    }

    static int getDP(int a,int b){
        if(dp[a][b] != Integer.MAX_VALUE) return dp[a][b];
        if(a == b-1) return dp[a][b] = (array[a] == array[b] ? 1 : 0);

        if(array[a] == array[b]){
            return dp[a][b] = getDP(a+1,b-1);
        }else{
            return dp[a][b] = 0;
        }
    }
}
