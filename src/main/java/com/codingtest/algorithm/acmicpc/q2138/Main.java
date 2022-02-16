package com.codingtest.algorithm.acmicpc.q2138;

import java.io.*;
import java.util.Arrays;

public class Main {

    private static final int INF = 1 << 20;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        char[] expect = br.readLine().toCharArray();

        char[] firstPassed = br.readLine().toCharArray();
        char[] firstPushed = Arrays.copyOf(firstPassed, n);

        firstPushed[0] = (char) ('0' + '1' - firstPushed[0]);
        firstPushed[1] = (char) ('0' + '1' - firstPushed[1]);

        int passCnt = getPassCnt(n, expect, firstPassed);
        int pushCnt = getPassCnt(n, expect, firstPushed) + 1;

        if (passCnt >= INF && pushCnt >= INF)
            bw.write("-1");
        else
            bw.write(String.valueOf(Math.min(passCnt, pushCnt)));
        bw.flush();
    }

    private static int getPassCnt(int n, char[] expect, char[] current) {
        int cnt = 0;
        for (int i = 1; i < n - 1; i++) {
            if (current[i - 1] != expect[i - 1]) {
                cnt++;
                current[i] = (char) ('0' + '1' - current[i]);
                current[i + 1] = (char) ('0' + '1' - current[i + 1]);
            }
        }
        boolean tailEqual = current[n - 1] == expect[n - 1];
        boolean preTailEqual = current[n - 2] == expect[n - 2];
        if (!tailEqual && !preTailEqual) cnt++;
        if (tailEqual ^ preTailEqual) return INF;
        return cnt;
    }
}
