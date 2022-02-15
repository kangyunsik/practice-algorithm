package com.codingtest.algorithm.acmicpc.q17281;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] info;
    static int[] seq = new int[9];
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        info = new int[n][9];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        seq[3] = 0;
        findCases(0, 1);

        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static void findCases(int cur, int flag) {
        if (cur == 3) cur++;
        if (cur == 9) {
            int mem = dfs(0, 0, 0, 0);
            ans = Math.max(ans, mem);
            return;
        }

        for (int i = 0; i < 9; i++) {
            if ((flag & (1 << i)) == 0) {
                seq[cur] = i;
                findCases(cur + 1, flag | (1 << i));
            }
        }
    }

    static int dfs(int depth, int idx, int out, int status) {
        if (depth == n) return 0;
        int temp = info[depth][seq[idx]];
        if (temp == 0) {
            if (++out == 3) {
                out = 0;
                depth++;
                status = 0;
            }
        } else {
            status++;
            status <<= temp;
        }
        int score = Integer.bitCount(status / (1 << 4));
        return score + dfs(depth, (idx + 1) % 9, out, status % (1 << 4));
    }
}
