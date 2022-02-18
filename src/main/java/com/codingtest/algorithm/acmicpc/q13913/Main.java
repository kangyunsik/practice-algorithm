package com.codingtest.algorithm.acmicpc.q13913;

import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX = 100000;
    public static final int INF = 1000000;
    static int[] distance, route;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        distance = new int[MAX + 1];
        route = new int[MAX + 1];
        Arrays.fill(distance, INF);
        Arrays.fill(route, INF);

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{n, 0, n});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cur = poll[0];
            int cost = poll[1];
            int prev = poll[2];
            if (cost >= distance[cur]) continue;
            distance[cur] = cost;
            route[cur] = prev;
            if (cur != 0 && cur * 2 <= MAX) {
                queue.offer(new int[]{cur * 2, cost + 1, cur});
            }
            if (cur + 1 <= MAX) {
                queue.offer(new int[]{cur + 1, cost + 1, cur});
            }
            if (cur - 1 >= 0) {
                queue.offer(new int[]{cur - 1, cost + 1, cur});
            }
        }

        int cur = k;
        Stack<Integer> stack = new Stack<>();
        while(route[cur] != cur){
            stack.push(route[cur]);
            cur = route[cur];
        }
        sb.append(distance[k]).append("\n");
        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        sb.append(k);
        bw.write(sb.toString());
        bw.flush();
    }
}
