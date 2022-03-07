package com.codingtest.algorithm.acmicpc.q2146;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};
    static int n;
    static List<List<int[]>> lists = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        bfsForSetAreaList();
        bw.write(String.valueOf(getMinDistFromAreaList()));
        bw.flush();
    }

    private static int getMinDistFromAreaList() {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < lists.size() - 1; i++) {
            for (int j = i + 1; j < lists.size(); j++) {
                ans = Math.min(ans, getMinDist(lists.get(i), lists.get(j)));
            }
        }
        return ans;
    }

    private static void bfsForSetAreaList() {
        boolean[][] visit = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j] || board[i][j] == 0) continue;
                visit[i][j] = true;
                queue.offer(new int[]{i, j});
                lists.add(new ArrayList<>());
                while (!queue.isEmpty()) {
                    int[] pos = queue.poll();
                    lists.get(cnt).add(pos);
                    for (int k = 0; k < 4; k++) {
                        int nextX = pos[0] + dx[k];
                        int nextY = pos[1] + dy[k];
                        if (!isValidRange(nextX, nextY) || visit[nextX][nextY] || board[nextX][nextY] == 0) continue;
                        visit[nextX][nextY] = true;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
                cnt++;
            }
        }
    }

    private static int getMinDist(List<int[]> area1, List<int[]> area2) {
        int ret = Integer.MAX_VALUE;
        for (int[] pos1 : area1) {
            for (int[] pos2 : area2) {
                ret = Math.min(ret, getDist(pos1, pos2));
            }
        }
        return ret;
    }

    private static int getDist(int[] pos1, int[] pos2) {
        return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]) - 1;
    }

    private static boolean isValidRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}
