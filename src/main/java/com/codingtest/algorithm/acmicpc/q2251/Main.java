package com.codingtest.algorithm.acmicpc.q2251;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<Integer> ans = new TreeSet<>();
        int[] bound = new int[3];
        for (int i = 0; i < 3; i++) {
            bound[i] = Integer.parseInt(st.nextToken());
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, bound[2]});
        boolean[][][] visit = new boolean[bound[0] + 1][bound[1] + 1][bound[2] + 1];
        visit[0][0][bound[2]] = true;
        int diff;
        while (!queue.isEmpty()) {
            int[] status = queue.poll();
            if (status[0] == 0) {
                ans.add(status[2]);
            }

            for (int from = 0; from < 3; from++) {
                if (status[from] == 0) {
                    continue;
                }
                for (int to = 0; to < 3; to++) {
                    if (from == to) {
                        continue;
                    }
                    diff = Math.min(status[from], bound[to] - status[to]);
                    int[] nst = {status[0], status[1], status[2]};
                    nst[from] -= diff;
                    nst[to] += diff;
                    if (visit[nst[0]][nst[1]][nst[2]]) {
                        continue;
                    }
                    queue.offer(nst);
                    visit[nst[0]][nst[1]][nst[2]] = true;
                }
            }
        }
        for (Integer p : ans) {
            sb.append(p).append(" ");
        }
        System.out.println(sb);
    }
}