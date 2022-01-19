package com.codingtest.algorithm.acmicpc.q15683;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static List<Cctv> cctvs;
    static int ans = 0;
    static int n, m, all;
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, -1, 0, 1};
    static final int[] ca = {4, 2, 4, 4, 1};
    static final int[][] helper = {{0}, {0, 2}, {0, 1}, {0, 1, 2}, {0, 1, 2, 3}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int input;
        board = new int[n][m];
        cctvs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                input = Integer.parseInt(st.nextToken());
                board[i][j] = input;
                if (input > 0 && input < 6) {
                    cctvs.add(new Cctv(i, j, input));
                } else if (input == 0) {
                    ans++;
                }
            }
        }
        all = ans;

        findCases(0, new Stack<>());
        bw.write(ans + "\n");
        bw.flush();
    }

    private static int findLookable(Stack<Integer> stack) {
        int[][] temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            temp[i] = Arrays.copyOf(board[i],m);
        }

        int result = 0;
        int idx = 0;
        for (Cctv cctv : cctvs) {
            Integer i = stack.get(idx);
            for (int j = 0; j < helper[cctv.kind - 1].length; j++) {
                int next = (i + helper[cctv.kind - 1][j]) % 4;
                result += cctv.draw(dx[next], dy[next], temp);
            }
            idx++;
        }
        return result;
    }

    private static void findCases(int depth, Stack<Integer> stack) {
        if (depth == cctvs.size()) {
            ans = Math.min(ans, all - findLookable(stack));
            return;
        }

        for (int i = 0; i < ca[cctvs.get(depth).kind - 1]; i++) {
            stack.push(i);
            findCases(depth + 1, stack);
            stack.pop();
        }

    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    static class Cctv {
        int x;
        int y;
        int kind;

        public Cctv(int x, int y, int kind) {
            this.x = x;
            this.y = y;
            this.kind = kind;
        }

        public int draw(int dx, int dy, int[][] temp) {
            int result = 0;
            int px = x + dx;
            int py = y + dy;
            while (inRange(px, py) && temp[px][py] != 6) {
                if (temp[px][py] == 0) {
                    result++;
                    temp[px][py] = -1;
                }
                px += dx;
                py += dy;
            }
            return result;
        }
    }
}
