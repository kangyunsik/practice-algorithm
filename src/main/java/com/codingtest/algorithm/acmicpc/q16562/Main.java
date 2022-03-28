package com.codingtest.algorithm.acmicpc.q16562;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] cost, parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        cost = new int[n];
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0, a, b; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            union(a,b);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[1]));
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{i + 1, cost[i]});
        }

        int ans = 0;
        while(!pq.isEmpty()){
            int[] poll = pq.poll();
            if(!union(poll[0], 0)) continue;
            ans += poll[1];
        }
        if(ans > k) bw.write("Oh no");
        else bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static boolean union(int a, int b){
        a = getParent(a);
        b = getParent(b);
        if(a == b) return false;
        if(a < b) parent[b] = a;
        else parent[a] = b;
        return true;
    }

    private static int getParent(int a) {
        if(parent[a] == a) return a;
        return parent[a] = getParent(parent[a]);
    }
}
