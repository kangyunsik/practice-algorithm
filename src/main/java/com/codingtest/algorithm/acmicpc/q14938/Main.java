package com.codingtest.algorithm.acmicpc.q14938;

import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1 << 20;
    static int n, m, r;
    static int[] itemCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a, b, cost, ans = 0;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        itemCnt = new int[n];
        int[][] dist = new int[n][n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            itemCnt[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken()) - 1;
            cost = Integer.parseInt(st.nextToken());
            dist[a][b] = Math.min(dist[a][b], cost);
            dist[b][a] = Math.min(dist[b][a], cost);
        }

        for (int mid = 0; mid < n; mid++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][mid] + dist[mid][j]);
                }
            }
        }

        for (int i = 0, sum = 0; i < n; i++, sum = 0) {
            for (int j = 0; j < n; j++) {
                if(dist[i][j] <= m){
                    sum += itemCnt[j];
                }
            }
            ans = Math.max(ans, sum);
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

}
