package com.codingtest.algorithm.acmicpc.q1325;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer>[] connect = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            connect[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            connect[y].add(x);
        }

        int max = 0;

        for (int i = 1; i <= n; i++) {
            Queue<Integer> queue = new LinkedList<>();
            boolean[] already = new boolean[n + 1];
            already[i] = true;
            queue.offer(i);
            int cnt = 0;
            while (!queue.isEmpty()) {
                Integer next = queue.poll();
                cnt++;
                for (int dest : connect[next]) {
                    if(!already[dest]){
                        already[dest] = true;
                        queue.offer(dest);
                    }
                }
            }
            if (cnt >= max) {
                if (cnt != max)
                    sb = new StringBuilder();
                max = cnt;
                sb.append(i).append(" ");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
