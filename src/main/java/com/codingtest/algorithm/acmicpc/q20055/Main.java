package com.codingtest.algorithm.acmicpc.q20055;

import java.io.*;
import java.util.*;

public class Main {
    static int putLocation;
    static int pollLocation;
    static int len, cnt;
    static boolean[] robots;
    static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        len = 2 * n;
        input = new int[len];
        robots = new boolean[len];
        for (int i = 0; i < len; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        putLocation = 0;
        pollLocation = n - 1;
        int step = 0;
        do {
            step++;
            rotate();
            move();
            putRobotFirst();
        } while (cnt < k);
        bw.write(String.valueOf(step));
        bw.flush();
    }

    private static void putRobotFirst() {
        if (input[putLocation] > 0) {
            if (--input[putLocation] == 0) cnt++;
            robots[putLocation] = true;
        }
    }

    private static void move() {
        int cur = (pollLocation - 1 + len) % len;
        int lower = (putLocation - 1 + len) % len;
        while (lower != cur) {
            int next = (cur + 1 + len) % len;
            if (robots[cur]) {
                if (!robots[next] && input[next] > 0) {
                    if (--input[next] == 0) cnt++;
                    robots[next] = true;
                    robots[cur] = false;
                }
            }
            cur = (cur - 1 + len) % len;
        }
        robots[pollLocation] = false;
    }

    private static void rotate() {
        putLocation = (putLocation + len - 1) % len;
        pollLocation = (pollLocation + len - 1) % len;
        robots[pollLocation] = false;
    }
}
