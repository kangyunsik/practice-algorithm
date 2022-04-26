package com.codingtest.algorithm.acmicpc.q2618;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] issue, dp, next;
    static final int INF = 1111111111;
    static int n, m;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        issue = new int[m + 1][2];
        next = new int[m + 1][m + 1];
        StringTokenizer st;
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            issue[i][0] = Integer.parseInt(st.nextToken());
            issue[i][1] = Integer.parseInt(st.nextToken());
        }
        dp = new int[m + 1][m + 1];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][m] = 0;
        }

        int ans = getDP(0, 0);
        System.out.println(ans);
        int p = 0, q = 0, nextIssue;
        while (p < m && q < m) {
            System.out.println(next[p][q]);
            nextIssue = Math.max(p, q) + 1;
            if (next[p][q] == 1) {
                p = nextIssue;
            } else {
                q = nextIssue;
            }
        }
    }

    private static int getDP(int a, int b) {
        if (dp[a][b] != INF) return dp[a][b];
        int nextIssue = Math.max(a, b) + 1;
        int aDist, bDist;

        if (a == 0) {
            aDist = getDP(nextIssue, b) + getInitDist(nextIssue, true);
        } else {
            aDist = getDP(nextIssue, b) + getDist(a, nextIssue);
        }
        if (b == 0) {
            bDist = getDP(a, nextIssue) + getInitDist(nextIssue, false);
        } else {
            bDist = getDP(a, nextIssue) + getDist(b, nextIssue);
        }

        if (aDist > bDist) {
            next[a][b] = 2;
            return dp[a][b] = bDist;
        } else {
            next[a][b] = 1;
            return dp[a][b] = aDist;
        }
    }

    private static int getInitDist(int idx, boolean isA) {
        if (isA) {
            return issue[idx][0] + issue[idx][1] - 2;
        } else {
            return 2 * n - issue[idx][0] - issue[idx][1];
        }
    }

    private static int getDist(int a, int b) {
        return Math.abs(issue[a][0] - issue[b][0]) + Math.abs(issue[a][1] - issue[b][1]);
    }
}