package com.codingtest.algorithm.acmicpc.q21937;

import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x, y;
        edges = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            edges[y].add(x);
        }

        boolean[] already = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        int input = Integer.parseInt(br.readLine());
        queue.offer(input);
        already[input] = true;
        int ans = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (Integer next : edges[poll]) {
                if(!already[next]){
                    already[next] = true;
                    ans++;
                    queue.offer(next);
                }
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
