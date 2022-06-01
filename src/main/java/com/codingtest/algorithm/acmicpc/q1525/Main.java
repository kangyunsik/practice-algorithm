package com.codingtest.algorithm.acmicpc.q1525;

import java.io.*;
import java.util.*;

public class Main {

    static final int[] dx = {-3, -1, 1, 3};
    static final int EXPECT = 123456780;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int init = 0;
        for (int i = 0, v; i < 9; i++) {
            if (i % 3 == 0) st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            init *= 10;
            init += v;
        }
        System.out.println(bfs(init));
    }

    private static int bfs(int init) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(init);
        if (init == EXPECT) return 0;
        int depth = 0;
        Set<Integer> visit = new HashSet<>();
        visit.add(init);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                Integer curStatus = queue.poll();
                int zeroIdx = findZeroIdx(curStatus);
                for (int j = 0; j < 4; j++) {
                    int nextIdx = zeroIdx + dx[j];
                    if (nextIdx < 0 || nextIdx >= 9) continue;
                    if (zeroIdx % 3 == 0 && j == 1) continue;
                    if (zeroIdx % 3 == 2 && j == 2) continue;
                    int nextStatus = swap(curStatus, zeroIdx, nextIdx);
                    if (!visit.add(nextStatus)) continue;
                    if (nextStatus == EXPECT) return depth;
                    queue.offer(nextStatus);
                }
            }
        }
        return -1;
    }

    private static int findZeroIdx(int status) {
        int ret = 0;
        while (status > 0) {
            if (status % 10 == 0) return ret;
            status /= 10;
            ret++;
        }
        return ret;
    }

    private static int swap(int status, int zeroIdx, int nextIdx) {
        int nextVal = (status / (int) Math.pow(10, nextIdx)) % 10;
        status += nextVal * (int) Math.pow(10, zeroIdx);
        status -= nextVal * (int) Math.pow(10, nextIdx);
        return status;
    }
}