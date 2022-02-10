package com.codingtest.algorithm.acmicpc.q1014;

import java.io.*;
import java.util.*;

public class Main {
    static int[] banned;
    static int[][] dp;
    static Set<Integer> possible = new HashSet<>();
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            banned = new int[n];
            dp = new int[n][1 << m];
            for (int i = 0, temp = 0; i < n; i++) {
                char[] board = br.readLine().toCharArray();
                for (int idx = 0; idx < m; idx++) {
                    temp *= 2;
                    if (board[idx] == 'x') temp += 1;
                }
                banned[i] = temp;
            }

            possible.clear();
            initPossibleStatus(0, 0);
            initPossibleStatus(0, 1);
            int ans = 0;
            for (Integer status : possible) {
                if (isValidWithBoard(status, n - 1)) {
                    ans = Math.max(ans, getDP(n - 1, status));
                }
            }

            sb.append(ans).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isValidWithBoard(Integer status, int cur) {
        if (cur < 0) return false;
        return (banned[cur] & status) == 0;
    }

    private static void initPossibleStatus(int cur, int value) {
        if (cur == m - 1) {
            possible.add(value);
            return;
        }

        if (value % 2 != 1) {
            initPossibleStatus(cur + 1, (value << 1) + 1);
        }
        initPossibleStatus(cur + 1, value << 1);
    }


    private static int getDP(int cur, int status) {
        if (dp[cur][status] != 0) return dp[cur][status];

        int temp = 0;
        for (int next : getNextValidStatus(status)) {
            if (isValidWithBoard(next, cur - 1))
                temp = Math.max(temp, getDP(cur - 1, next));
        }
        return dp[cur][status] = Integer.bitCount(status) + temp;
    }

    private static List<Integer> getNextValidStatus(int status) {
        List<Integer> ret = new ArrayList<>();
        int notValid = (status << 1) | (status >> 1);
        for (Integer integer : possible) {
            if ((integer & notValid) == 0) {
                ret.add(integer);
            }
        }
        return ret;
    }
}
