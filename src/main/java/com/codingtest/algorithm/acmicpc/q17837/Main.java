package com.codingtest.algorithm.acmicpc.q17837;

import java.io.*;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static final int BLUE = 2;
    public static final int RED = 1;
    static int[][] board;
    static Stack<Unit>[][] stacks;
    static Unit[] units;
    static int n;

    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        stacks = new Stack[n][n];
        units = new Unit[k];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                stacks[i][j] = new Stack<>();
            }
        }

        int x, y, d, round = 0;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken()) - 1;
            y = Integer.parseInt(st.nextToken()) - 1;
            d = Integer.parseInt(st.nextToken()) - 1;
            units[i] = new Unit(i, x, y, d);
            stacks[x][y].push(units[i]);
        }

        lb:
        while (++round <= 1000) {
            for (Unit unit : units) if (unit.move()) break lb;
        }
        if (round > 1000) bw.write("-1");
        else bw.write(String.valueOf(round));
        bw.flush();
    }

    static class Unit {
        int index, x, y, dir;

        public Unit(int index, int x, int y, int dir) {
            this.index = index;
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public boolean move() {
            Stack<Unit> temp = new Stack<>();
            while (!stacks[x][y].isEmpty() && stacks[x][y].peek().index != index) {
                temp.push(stacks[x][y].pop());
            }
            temp.push(stacks[x][y].pop());

            int nextX = this.x + dx[dir];
            int nextY = this.y + dy[dir];
            if (!isValidRange(nextX, nextY) || board[nextX][nextY] == BLUE) {
                dir = dirReverse(dir);
                nextX = this.x + dx[dir];
                nextY = this.y + dy[dir];
                if (!isValidRange(nextX, nextY) || board[nextX][nextY] == BLUE) {
                    nextX -= dx[dir];
                    nextY -= dy[dir];
                } else if (board[nextX][nextY] == RED) {
                    Collections.reverse(temp);
                }
            } else if (board[nextX][nextY] == RED) {
                Collections.reverse(temp);
            }
            return stackMove(temp, nextX, nextY);
        }

        private boolean stackMove(Stack<Unit> temp, int nextX, int nextY) {
            while (!temp.isEmpty()) {
                Unit pop = temp.pop();
                pop.x = nextX;
                pop.y = nextY;
                stacks[nextX][nextY].push(pop);
            }
            return stacks[nextX][nextY].size() >= 4;
        }

        private int dirReverse(int dir) {
            return dir < 2 ? 1 - dir : 5 - dir;
        }
    }

    private static boolean isValidRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}
