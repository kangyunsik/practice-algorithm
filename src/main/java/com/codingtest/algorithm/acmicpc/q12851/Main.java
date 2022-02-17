package com.codingtest.algorithm.acmicpc.q12851;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dist = new int[100001];
        int[] cnt = new int[100001];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{n, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (dist[poll[0]] < poll[1]) continue;
            else if (dist[poll[0]] == poll[1]) cnt[poll[0]]++;
            else cnt[poll[0]] = 1;
            dist[poll[0]] = poll[1];

            if (poll[0] + 1 <= 100000)
                queue.offer(new int[]{poll[0] + 1, poll[1] + 1});
            if (poll[0] * 2 <= 100000)
                queue.offer(new int[]{poll[0] * 2, poll[1] + 1});
            if (poll[0] - 1 >= 0)
                queue.offer(new int[]{poll[0] - 1, poll[1] + 1});
        }

        bw.write(String.valueOf(dist[k]));
        bw.write("\n");
        bw.write(String.valueOf(cnt[k]));
        bw.flush();
    }
}
