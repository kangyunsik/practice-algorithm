package com.codingtest.algorithm.acmicpc.q8980;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        int[] remain = new int[n + 1];
        Arrays.fill(remain, c);
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1, i2) -> i1[1] == i2[1] ? i2[0] - i1[0] : i1[1] - i2[1]);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            pq.offer(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        int ans = 0;
        while(!pq.isEmpty()){
            int[] poll = pq.poll();
            int bound = Integer.MAX_VALUE;
            for (int i = poll[0]; i < poll[1]; i++) {
                bound = Math.min(bound, remain[i]);
            }
            bound = Math.min(bound, poll[2]);
            ans += bound;
            for (int i = poll[0]; i < poll[1]; i++) {
                remain[i] -= bound;
            }
        }
        bw.write(ans + "\n");
        bw.flush();
    }
}
