package com.codingtest.algorithm.acmicpc.q1058;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static boolean[][] connect;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int ans = 0, n = Integer.parseInt(br.readLine());
        String input;
        connect = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            input = br.readLine();
            for (int j = 0; j < n; j++) {
                if (input.charAt(j) == 'Y') connect[i][j] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> next = new HashSet<>();
            Set<Integer> temp = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (connect[i][j]) {
                    next.add(j);
                    temp.add(j);
                }
            }

            for (Integer v : temp) {
                for (int j = 0; j < n; j++) {
                    if (connect[v][j] && j != i)
                        next.add(j);
                }
            }
            ans = Math.max(ans, next.size());
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

}

