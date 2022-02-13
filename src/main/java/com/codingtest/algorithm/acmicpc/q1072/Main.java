package com.codingtest.algorithm.acmicpc.q1072;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());

        int prev = (int) ((double) 100 * y / x);
        if (prev >= 99) {
            bw.write("-1");
            bw.flush();
            return;
        }

        int winP;
        long begin = 1;
        long end = x + 1;
        long ans = 1;

        do {
            long m = (begin + end) / 2;
            winP = (int) ((double) 100 * (y + m) / (x + m));
            if (winP == prev) {
                begin = m;
                if (begin == end - 1) break;
            } else if (winP >= prev + 1) {
                ans = m;
                end = m;
            }
        } while (begin != end);

        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
