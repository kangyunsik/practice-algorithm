package com.codingtest.algorithm.acmicpc.q2458;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int ans = 0;
        edges = new boolean[n + 1][n + 1];
        for (int i = 0, a, b; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            edges[a][b] = true;
        }

        for (int mid = 1; mid <= n; mid++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    edges[i][j] |= (edges[i][mid] && edges[mid][j]);
                }
            }
        }

        for (int i = 1, cnt = 0; i <= n; i++, cnt = 0) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                if (edges[i][j] || edges[j][i]) cnt++;
            }
            if(cnt == n - 1) ans++;
        }
        System.out.println(ans);
    }
}