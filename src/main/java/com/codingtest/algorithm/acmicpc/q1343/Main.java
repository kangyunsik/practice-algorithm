package com.codingtest.algorithm.acmicpc.q1343;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] input = br.readLine().toCharArray();

        int cnt = 0;
        int idx = 0;
        for (int i = 0, len = input.length; i < len; i++) {
            if (input[i] == 'X') cnt++;
            else {
                if (cnt % 2 == 1) {
                    bw.write("-1");
                    bw.flush();
                    return;
                }
                cnt = calcCntAndSetArr(input, cnt, idx);
                idx = i + 1;
            }
        }

        if (cnt % 2 == 1) {
            bw.write("-1");
            bw.flush();
            return;
        }
        calcCntAndSetArr(input, cnt, idx);
        bw.write(new String(input));
        bw.flush();

    }

    private static int calcCntAndSetArr(char[] input, int cnt, int idx) {
        while (cnt >= 4) {
            for (int j = 0; j < 4; j++) {
                input[idx + j] = 'A';
            }
            idx = idx + 4;
            cnt -= 4;
        }
        if (cnt == 2) {
            for (int j = 0; j < 2; j++) {
                input[idx + j] = 'B';
            }
            cnt -= 2;
        }
        return cnt;
    }
}
