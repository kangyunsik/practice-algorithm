package com.codingtest.algorithm.acmicpc.q10157;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};
    static int r, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int curX = 0, curY = 0, cur = 0, dir = 0;
        int exp = Integer.parseInt(br.readLine());
        if(r * c < exp){
            bw.write("0");
            bw.flush();
            return;
        }
        boolean[][] board = new boolean[r][c];
        while(++cur <= r * c){
            board[curX][curY] = true;
            if(cur == exp){
                bw.write((curX + 1) + " " + (curY + 1));
            }
            int px = curX + dx[dir];
            int py = curY + dy[dir];
            if(!inRange(px, py) || board[px][py]){
                dir = (dir + 1) % 4;
            }
            curX += dx[dir];
            curY += dy[dir];
        }
        bw.flush();
    }

    private static boolean inRange(int x, int y){
        return x >= 0 && y >= 0 && x < r && y < c;
    }
}
