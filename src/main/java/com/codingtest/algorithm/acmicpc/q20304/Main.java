package com.codingtest.algorithm.acmicpc.q20304;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int len = Integer.toBinaryString(n).length();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int ans = 0;
        int[] dist = new int[n + 1];
        boolean[] already = new boolean[n + 1];

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            int input = Integer.parseInt(st.nextToken());
            queue.offer(input);
            already[input] = true;
        }

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            for (int i = 0; i < len; i++) { //  1010 len = 4 [i =0~ i =3]
                int next = poll ^ (1 << i); // i=0 -> 1, i=1 -> 10, i=2 -> 100, i=3 -> 1000
                if (next <= n && !already[next]) {
                    already[next] = true;
                    dist[next] = dist[poll] + 1;
                    queue.offer(next);
                }
            }
        }

        for (int i : dist) {
            ans = Math.max(ans, i);
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }
}

