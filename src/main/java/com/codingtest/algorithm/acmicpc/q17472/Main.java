package com.codingtest.algorithm.acmicpc.q17472;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static List<List<int[]>> areas = new ArrayList<>();
    static boolean[][] visit;
    static final int[] dr = {0, 0, 1, -1};
    static final int[] dc = {1, -1, 0, 0};
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j] || board[i][j] == 0) continue;
                visit[i][j] = true;
                bfs(i, j);
            }
        }

        int ans = playMst();
        if (ans == Integer.MAX_VALUE) ans = -1;
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static int playMst() {
        int k = areas.size();
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < k; j++) {
                int[] edge = {i, j, getDist(i, j)};
                edges.add(edge);
            }
        }
        Collections.sort(edges, Comparator.comparingInt(i -> i[2]));
        int[] parent = new int[k];
        for (int i = 0; i < k; i++) {
            parent[i] = i;
        }
        int ret = 0;
        int cnt = 0;
        for (int i = 0; cnt < k - 1 && i < edges.size(); i++) {
            int[] info = edges.get(i);
            if (info[2] != Integer.MAX_VALUE && union(parent, info[0], info[1])) {
                cnt++;
                ret += info[2];
            }
        }
        if (cnt != k - 1) return Integer.MAX_VALUE;
        return ret;
    }

    private static int getParent(int[] parent, int a) {
        if (parent[a] == a) return a;
        else return parent[a] = getParent(parent, parent[a]);
    }

    private static boolean union(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if (a == b) return false;
        if (a > b) parent[a] = b;
        else parent[b] = a;
        return true;
    }

    private static int getDist(int idx1, int idx2) {
        List<int[]> left = areas.get(idx1);
        List<int[]> right = areas.get(idx2);
        int ret = Integer.MAX_VALUE;
        int temp = Integer.MAX_VALUE;
        for (int[] leftPos : left) {
            for (int[] rightPos : right) {
                if (leftPos[0] == rightPos[0] && isClearHorizon(leftPos[0], leftPos[1], rightPos[1])) {
                    temp = Math.abs(leftPos[1] - rightPos[1]) - 1;
                } else if (leftPos[1] == rightPos[1] && isClearVertical(leftPos[1], leftPos[0], rightPos[0])) {
                    temp = Math.abs(leftPos[0] - rightPos[0]) - 1;
                }
                if (temp != 1) ret = Math.min(ret, temp);
            }
        }
        return ret;
    }

    private static boolean isClearVertical(int th, int lower, int higher) {
        if (lower > higher) return isClearVertical(th, higher, lower);
        for (int i = lower + 1; i < higher; i++) {
            if (board[i][th] == 1) return false;
        }
        return true;
    }

    private static boolean isClearHorizon(int th, int lower, int higher) {
        if (lower > higher) return isClearHorizon(th, higher, lower);
        for (int i = lower + 1; i < higher; i++) {
            if (board[th][i] == 1) return false;
        }
        return true;
    }

    private static void bfs(int r, int c) {
        areas.add(new ArrayList<>());
        Queue<int[]> queue = new LinkedList<>();
        int[] cur = {r, c};
        areas.get(areas.size() - 1).add(cur);
        queue.offer(cur);
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextR = pos[0] + dr[i];
                int nextC = pos[1] + dc[i];
                if (!isValidRange(nextR, nextC) || visit[nextR][nextC] || board[nextR][nextC] == 0) continue;
                visit[nextR][nextC] = true;
                int[] nextPos = {nextR, nextC};
                queue.offer(nextPos);
                areas.get(areas.size() - 1).add(nextPos);
            }
        }
    }

    private static boolean isValidRange(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }
}
