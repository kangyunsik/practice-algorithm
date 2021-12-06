package com.codingtest.algorithm.acmicpc.q1865;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int test_case = Integer.parseInt(br.readLine());
        int n, m, w, a, b, c;
        int[][] map;
        boolean answer;
        for (int t = 0; t < test_case; t++) {
            answer = false;
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(map[i], Integer.MAX_VALUE);
                map[i][i] = 0;
            }

            for (int i = 0; i < m + w; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                a = Integer.parseInt(st.nextToken()) - 1;
                b = Integer.parseInt(st.nextToken()) - 1;
                c = Integer.parseInt(st.nextToken());
                if (i < m) {
                    map[a][b] = Integer.min(map[a][b], c);
                    map[b][a] = Integer.min(map[b][a], c);
                } else {
                    map[a][b] = Integer.min(map[a][b], -c);
                }
            }

            for (int mid = 0; mid < n; mid++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if(map[i][mid] != Integer.MAX_VALUE && map[mid][j] != Integer.MAX_VALUE)
                            map[i][j] = Integer.min(map[i][j], map[i][mid] + map[mid][j]);
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                if (map[i][i] < 0) {
                    answer = true;
                    break;
                }
            }
            bw.write(answer ? "YES\n" : "NO\n");
            bw.flush();
        }
    }
}
