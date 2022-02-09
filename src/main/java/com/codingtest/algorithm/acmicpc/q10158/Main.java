package com.codingtest.algorithm.acmicpc.q10158;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());
        x = calc((x + t) % (2 * w), w);
        y = calc((y + t) % (2 * h), h);

        sb.append(x).append(" ").append(y);
        bw.write(sb.toString());
        bw.flush();
    }

    private static int calc(int pos, int len) {
        if (pos >= len && pos <= 2 * len) {
            return len - (pos % len);
        } else {
            return pos % len;
        }
    }
}
