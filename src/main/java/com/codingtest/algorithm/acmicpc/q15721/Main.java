package com.codingtest.algorithm.acmicpc.q15721;

import java.io.*;

public class Main {
    static int level = 0;
    static int seq = 0;
    static int pIdx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (true) {
            int ret = getNext();
            if (c == ret) cnt++;
            if (cnt == b) break;
            if (++pIdx == a) {
                pIdx = 0;
            }
            if (++seq == getAll()) {
                seq = 0;
                level++;
            }
        }
        bw.write(String.valueOf(pIdx));
        bw.flush();
    }

    public static int getNext() {
        if (seq <= 3) return seq % 2;
        int right = getAll() - 4;
        if (seq < 4 + right / 2) return 0;
        else return 1;
    }

    private static int getAll() {
        return level * 2 + 8;
    }
}
