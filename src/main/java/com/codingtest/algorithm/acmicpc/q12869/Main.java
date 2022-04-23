package com.codingtest.algorithm.acmicpc.q12869;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static final int INF = 99999;
    static int[][][] dp;
    static int n;
    static int[][] sequences = {{0, 1, 2}, {0, 2, 1}, {1, 0, 2}, {1, 2, 0}, {2, 0, 1}, {2, 1, 0}};
    static final int[] damage = {9, 3, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[3];
        dp = new int[61][61][61];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = find(arr);
        System.out.println(ans);
    }

    private static int find(int[] arr) {
        if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0) return 0;
        if(dp[arr[0]][arr[1]][arr[2]] != 0) return dp[arr[0]][arr[1]][arr[2]];
        int ret = INF;
        for (int[] sequence : sequences) {
            int[] effect = decreaseBySeq(arr, sequence);
            ret = Math.min(ret, find(arr));
            rollbackBySeq(arr, effect);
        }
        return dp[arr[0]][arr[1]][arr[2]] = ret + 1;
    }

    private static void rollbackBySeq(int[] arr, int[] effect) {
        for (int i = 0; i < 3; i++) {
            arr[i] += effect[i];
        }
    }

    private static int[] decreaseBySeq(int[] arr, int[] sequence) {
        int[] ret = new int[3];
        for (int i = 0; i < 3; i++) {
            if(arr[sequence[i]] - damage[i] < 0){
                ret[sequence[i]] = arr[sequence[i]];
            }else{
                ret[sequence[i]] = damage[i];
            }
            arr[sequence[i]] -= ret[sequence[i]];
        }
        return ret;
    }
}