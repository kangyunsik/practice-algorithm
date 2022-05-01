package com.codingtest.algorithm.acmicpc.q16931;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = getLeftView() + getBottomView() + n * m * 2;
        System.out.println(ans);
    }

    private static int getLeftView() {
        int cur = 0;
        int ret = 0;
        for (int i = 0; i < n; i++, cur = 0) {
            for (int j = 0; j < m; j++) {
                ret += Math.abs(arr[i][j] - cur);
                cur = arr[i][j];
            }
            ret += cur;
        }
        return ret;
    }

    private static int getBottomView() {
        int cur = 0;
        int ret = 0;
        for (int i = 0; i < m; i++, cur = 0) {
            for (int j = 0; j < n; j++) {
                ret += Math.abs(arr[j][i] - cur);
                cur = arr[j][i];
            }
            ret += cur;
        }
        return ret;
    }
}