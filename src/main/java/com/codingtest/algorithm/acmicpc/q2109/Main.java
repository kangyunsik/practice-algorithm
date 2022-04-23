package com.codingtest.algorithm.acmicpc.q2109;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        List<Integer>[] list = new List[10001];
        for (int i = 1; i <= 10000; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0, a, b; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            list[b].add(a);
        }

        int ans = 0;
        for (int i = 10000; i > 0 ; i--) {
            for (Integer v : list[i]) {
                pq.offer(v);
            }
            if(pq.isEmpty()) continue;
            ans += pq.poll();
        }
        System.out.println(ans);
    }
}