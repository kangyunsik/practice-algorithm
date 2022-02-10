package com.codingtest.algorithm.acmicpc.q10163;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Square[] squares = new Square[n];
        board = new int[1001][1001];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            squares[i] = new Square(i + 1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            squares[i].draw();
        }

        for (Square square : squares) {
            sb.append(square.getArea()).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    static class Square {
        int index;
        int x, y, dx, dy;

        public Square(int index, int x, int y, int dx, int dy) {
            this.index = index;
            this.x = x;
            this.y = y;
            this.dx = dx;
            this.dy = dy;
        }

        public void draw() {
            for (int i = x; i < x + dx; i++) {
                for (int j = y; j < y + dy; j++) {
                    board[i][j] = index;
                }
            }
        }

        public int getArea() {
            int cnt = 0;
            for (int i = x; i < x + dx; i++) {
                for (int j = y; j < y + dy; j++) {
                    if (board[i][j] == index) {
                        cnt++;
                    }
                }
            }
            return cnt;
        }
    }
}
