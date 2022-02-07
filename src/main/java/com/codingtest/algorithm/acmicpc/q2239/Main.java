package com.codingtest.algorithm.acmicpc.q2239;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[][] map = new int[9][9];
    static List<int[]> zeros = new ArrayList<>();
    static boolean[][] rows = new boolean[9][10];
    static boolean[][] cols = new boolean[9][10];
    static boolean[][][] boxes = new boolean[3][3][10];
    static boolean find = false;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < 9; j++) {
                int value = input[j] - '0';
                if(value == 0){
                    zeros.add(new int[]{i, j});
                }else {
                    map[i][j] = value;
                    rows[i][value] = true;
                    cols[j][value] = true;
                    boxes[i / 3][j / 3][value] = true;
                }
            }
        }
        backTrack(0);
        bw.flush();
    }

    private static void backTrack(int cur) throws IOException {
        if(cur == zeros.size()){
            for (int[] m : map) {
                for (int i : m) {
                    bw.write(Integer.toString(i));
                }
                bw.write("\n");
            }
            find = true;
            return;
        }

        int x = zeros.get(cur)[0];
        int y = zeros.get(cur)[1];
        for (int i = 1; i <= 9; i++) {
            if(!find && !rows[x][i] && !cols[y][i] && !boxes[x/3][y/3][i]){
                rows[x][i] = true;
                cols[y][i] = true;
                boxes[x/3][y/3][i] = true;
                map[x][y] = i;
                backTrack(cur + 1);
                rows[x][i] = false;
                cols[y][i] = false;
                boxes[x/3][y/3][i] = false;
            }
        }
    }
}
