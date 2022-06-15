package com.codingtest.algorithm.acmicpc.q13904;

import java.io.*;
import java.util.*;

public class Main {
    static Queue<Integer>[] queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        queue = new Queue[1001];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 1; i <= 1000; i++) {
            queue[i] = new LinkedList<>();
        }
        int d,w;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            d  = Integer.parseInt(st.nextToken());
            w  = Integer.parseInt(st.nextToken());
            queue[d].offer(w);
        }

        int ans = 0;
        for (int time = 1000; time > 0; time--) {
            while(!queue[time].isEmpty()){
                pq.offer(queue[time].poll());
            }
            if(!pq.isEmpty())
                ans += pq.poll();
        }
        System.out.println(ans);
    }
}