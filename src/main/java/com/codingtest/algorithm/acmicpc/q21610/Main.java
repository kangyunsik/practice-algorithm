package com.codingtest.algorithm.acmicpc.q21610;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static int n;
    static List<int[]> cloud;
    static final int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
    static final int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
    static final int[] diaR = {-1, -1, 1, 1};
    static final int[] diaC = {-1, 1, 1, -1};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        initCloudLocation();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int d, s;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken()) - 1;
            s = Integer.parseInt(st.nextToken());
            simulate(d, s);
        }

        System.out.println(getSum());
    }

    private static void initCloudLocation() {
        cloud = new ArrayList<>();
        cloud.add(new int[]{n - 1, 0});
        cloud.add(new int[]{n - 1, 1});
        cloud.add(new int[]{n - 2, 0});
        cloud.add(new int[]{n - 2, 1});
    }

    private static void simulate(int dir, int speed) {
        movePositions(dir, speed);
        rain();
        magic();
        reconstructCloud();
    }

    private static void movePositions(int dir, int speed) {
        for (int[] position : cloud) {
            position[0] += (dr[dir] + n) * speed;
            position[1] += (dc[dir] + n) * speed;
            position[0] %= n;
            position[1] %= n;
        }
    }

    private static void rain() {
        int row, col;
        for (int[] position : cloud) {
            row = position[0];
            col = position[1];
            board[row][col]++;
        }
    }

    private static void magic() {
        int row, col, score, nextR, nextC;
        for (int[] position : cloud) {
            row = position[0];
            col = position[1];
            score = 0;
            for (int dir = 0; dir < 4; dir++) {
                nextR = row + diaR[dir];
                nextC = col + diaC[dir];
                if (isInvalidRange(nextR, nextC) || board[nextR][nextC] == 0) continue;
                score++;
            }
            board[row][col] += score;
        }
    }

    private static void reconstructCloud() {
        List<int[]> reconstruct = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] < 2 || isPrevCloudPosition(i, j)) continue;
                reconstruct.add(new int[]{i, j});
                board[i][j] -= 2;
            }
        }
        cloud = reconstruct;
    }

    private static boolean isPrevCloudPosition(int r, int c) {
        for (int[] position : cloud) {
            if (position[0] == r && position[1] == c) return true;
        }
        return false;
    }

    private static boolean isInvalidRange(int r, int c) {
        return r < 0 || c < 0 || r >= n || c >= n;
    }

    private static int getSum() {
        int ret = 0;
        for (int[] arr : board) {
            for (int i : arr) {
                ret += i;
            }
        }
        return ret;
    }
}