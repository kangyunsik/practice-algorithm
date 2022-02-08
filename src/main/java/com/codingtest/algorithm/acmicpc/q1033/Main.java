package com.codingtest.algorithm.acmicpc.q1033;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            bw.write("1\n");
            bw.flush();
            return;
        }
        int a, b, c, d, gcd;
        boolean first = true;
        boolean[] already = new boolean[n];
        int[] pro = new int[n];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            gcd = getGCD(c, d);
            c /= gcd;
            d /= gcd;
            queue.offer(new int[]{a, b, c, d});
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            a = poll[0];
            b = poll[1];
            c = poll[2];
            d = poll[3];
            if (first) {
                pro[a] = c;
                pro[b] = d;
                already[a] = true;
                already[b] = true;
                first = false;
                continue;
            }
            if (!already[a] && !already[b]) {
                queue.offer(poll);
                continue;
            }
            already[a] = true;
            already[b] = true;

            if (pro[a] == 0) {
                pro[a] = pro[b] * c;
                for (int j = 0; j < n; j++) {
                    if (j != a) {
                        pro[j] *= d;
                    }
                }
            } else {
                pro[b] = pro[a] * d;
                for (int j = 0; j < n; j++) {
                    if (j != b) {
                        pro[j] *= c;
                    }
                }
            }
        }

        gcd = pro[0];
        for (int i = 1; i < pro.length; i++) {
            gcd = getGCD(gcd, pro[i]);
        }
        for (int i : pro) {
            bw.write((i / gcd) + " ");
        }
        bw.flush();
    }

    private static int getGCD(int x, int y) {
        if (x < y) return getGCD(y, x);
        if (x % y == 0) return y;
        else return getGCD(y, x % y);
    }
}
