package com.codingtest.algorithm.acmicpc.q2116;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] dices;
    static int n;
    static int[] map = {5, 3, 4, 1, 2, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        dices = new int[n][6];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 6; j++) {
                dices[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        for (int i = 0; i < 6; i++) {
            ans = Math.max(ans, findCase(dices[0][i], 0));
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static int findCase(int botValue, int cur) {
        if (cur == n) {
            return 0;
        }
        int index = -1;
        for (int i = 0; i < 6; i++) {
            if (botValue == dices[cur][i]) {
                index = i;
                break;
            }
        }

        int curMax = 0;
        for (int i = 0; i < 6; i++) {
            if (dices[cur][i] != botValue && i != map[index]) {
                curMax = Math.max(curMax, dices[cur][i]);
            }
        }
        return (curMax + findCase(dices[cur][map[index]], cur + 1));
    }
}
