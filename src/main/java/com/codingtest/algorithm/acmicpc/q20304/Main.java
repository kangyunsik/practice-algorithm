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
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            queue.offer(new int[]{Integer.parseInt(st.nextToken()), 0});
        }

        int ans = 0;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int depth = Integer.bitCount(poll[1]);
            if(depth >= dist[poll[0]]) continue;
            dist[poll[0]] = depth;

            for (int i = 0; i < len; i++) {
                int bit = 1 << i;
                int next = poll[0] ^ bit;
                depth = Integer.bitCount(poll[1] + bit);
                if (next <= n && (poll[1] & bit) == 0 && depth < dist[next]) {
                    queue.offer(new int[]{next, poll[1] + bit});
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
