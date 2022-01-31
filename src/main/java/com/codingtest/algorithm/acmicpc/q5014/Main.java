package com.codingtest.algorithm.acmicpc.q5014;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    static boolean[] already;
    static int f, s, g, u, d;
    static int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        dp = new int[f + 1];
        already = new boolean[f + 1];
        Arrays.fill(dp, INF);
        dp[s] = 0;

        Queue<Integer> positionQ = new LinkedList<>();
        Queue<Integer> costQ = new LinkedList<>();
        positionQ.offer(s);
        costQ.offer(0);
        while (!positionQ.isEmpty()) {
            Integer pos = positionQ.poll();
            Integer cost = costQ.poll();
            if (dp[pos] < cost) continue;
            dp[pos] = cost;
            if (u != 0 && pos + u <= f && !already[pos + u]) {
                already[pos + u] = true;
                positionQ.offer(pos + u);
                costQ.offer(cost + 1);
            }
            if (d != 0 && pos - d > 0 && !already[pos - d]) {
                already[pos - d] = true;
                positionQ.offer(pos - d);
                costQ.offer(cost + 1);
            }
        }

        bw.write(dp[g] == INF ? "use the stairs\n" : dp[g] + "\n");
        bw.flush();
    }
}
