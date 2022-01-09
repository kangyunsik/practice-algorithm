package com.codingtest.algorithm.acmicpc.q1956;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int v, e, a, b, c, ans = INF;
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        int[][] dist = new int[v][v];
        for (int i = 0; i < v; i++) {
            Arrays.fill(dist[i], INF);
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken());
            dist[a][b] = c;
        }

        for (int mid = 0; mid < v; mid++) {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][mid] + dist[mid][j]);
                }
            }
        }

        for (int i = 0; i < v-1; i++) {
            for (int j = i+1; j < v; j++) {
                ans = Math.min(ans , dist[i][j] + dist[j][i]);
            }
        }
        bw.write((ans == INF ? -1 : ans)+"\n");
        bw.flush();
    }
}
