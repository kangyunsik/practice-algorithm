package com.codingtest.algorithm.acmicpc.q11780;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int[][] dist;
    static int[][] prev;
    static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        dist = new int[n + 1][n + 1];
        prev = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    dist[i][j] = INF;
                }
                prev[i][j] = INF;
            }
        }

        int a, b, c, nDest;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken());
            if (dist[a][b] > c) {
                dist[a][b] = c;
            }
            prev[a][b] = a;
        }

        for (int mid = 0; mid < n; mid++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    nDest = dist[i][mid] + dist[mid][j];
                    if (dist[i][j] > nDest) {
                        dist[i][j] = nDest;
                        prev[i][j] = prev[mid][j];
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == INF)
                    bw.write("0 ");
                else
                    bw.write(dist[i][j] + " ");
            }
            bw.write("\n");
        }

        Stack<Integer> stack = new Stack<>();
        int cur;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || dist[i][j] == INF) {
                    bw.write(0 + "\n");
                    continue;
                }

                stack.clear();
                cur = prev[i][j];
                stack.push(j);
                while (cur != INF) {
                    stack.push(cur);
                    cur = prev[i][cur];
                }
                bw.write(stack.size() + " ");
                while (!stack.isEmpty()) {
                    bw.write((stack.pop() + 1) + " ");
                }
                bw.write("\n");
            }
        }


        bw.flush();
    }
}
