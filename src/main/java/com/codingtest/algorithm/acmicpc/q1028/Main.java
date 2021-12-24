package com.codingtest.algorithm.acmicpc.q1028;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m, ans = 0;
    static char[][] map;
    static int[][] leftDP, rightDP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        leftDP = new int[n][m];
        rightDP = new int[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().trim().toCharArray();
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (map[i][j] == '0')
                    leftDP[i][j] = 0;
                else
                    leftDP[i][j] = leftDP[i - 1][j - 1] + 1;
                if (map[i][j - 1] == '0')
                    rightDP[i][j - 1] = 0;
                else
                    rightDP[i][j - 1] = rightDP[i - 1][j] + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                findMaxDiamond(i, j);
            }
        }
        bw.write(ans + "\n");
        bw.flush();
    }

    private static void findMaxDiamond(int a, int b) {
        for (int i = ans; i * 2 < n - a; i++) {
            if (map[a][b] == '1' &&
                    b + i < m && b - i >= 0 &&
                    leftDP[a + i][b + i] >= i &&
                    rightDP[a + i][b - i] >= i &&
                    leftDP[a + 2 * i][b] >= i &&
                    rightDP[a + 2 * i][b] >= i) {
                ans = Math.max(ans, i + 1);
            }
        }
    }
}
