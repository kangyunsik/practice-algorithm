package com.codingtest.algorithm.acmicpc.q14499;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int[][] map;
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int x, y, k, c, px, py;
        n = sc.nextInt(); m = sc.nextInt(); x = sc.nextInt(); y = sc.nextInt(); k = sc.nextInt();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        Dice dice = new Dice();
        for (int i = 0; i < k; i++) {
            c = sc.nextInt() - 1;
            px = x + dx[c];
            py = y + dy[c];
            if (inRange(px, py)) {
                dice.move(dx[c], dy[c]);
                x = px;
                y = py;
                if (map[x][y] == 0) {
                    map[x][y] = dice.status[1][1];
                } else {
                    dice.status[1][1] = map[x][y];
                    map[x][y] = 0;
                }
                System.out.println(dice.status[3][1]);
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    static class Dice {
        int[][] status;

        public Dice() {
            status = new int[4][3];
        }

        public void move(int dx, int dy) {
            int temp;
            if (dx == 0) {
                if (dy == -1) {   // 동쪽
                    temp = status[1][2];status[1][2] = status[1][1];
                    status[1][1] = status[1][0];status[1][0] = status[3][1];
                } else {  // 서쪽
                    temp = status[1][0];status[1][0] = status[1][1];
                    status[1][1] = status[1][2];status[1][2] = status[3][1];
                }
                status[3][1] = temp;
            } else if (dx == -1) { // 북쪽
                temp = status[3][1];status[3][1] = status[2][1];status[2][1] = status[1][1];
                status[1][1] = status[0][1];status[0][1] = temp;
            } else { // 남쪽
                temp = status[3][1];status[3][1] = status[0][1];status[0][1] = status[1][1];
                status[1][1] = status[2][1];status[2][1] = temp;
            }
        }

    }
}
