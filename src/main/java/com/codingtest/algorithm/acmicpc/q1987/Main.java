package com.codingtest.algorithm.acmicpc.q1987;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static final int[] dx = {0,1,0,-1};
    static final int[] dy = {1,0,-1,0};
    static String[] board;
    static Set<Character> already;
    static int answer, r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        already = new HashSet<>();

        st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new String[r];
        for (int i = 0; i < r; i++) {
            board[i] = br.readLine();
        }

        find(0,0, 1);
        System.out.println(answer);
    }

    private static void find(int i, int j, int depth){
        already.add(board[i].charAt(j));
        answer = Math.max(depth, answer);

        for (int k = 0; k < 4; k++) {
            int px = i + dx[k];
            int py = j + dy[k];

            if(inRange(px,py) && !already.contains(board[px].charAt(py))){
                find(px,py,depth+1);
            }
        }
        already.remove(board[i].charAt(j));
    }

    private static boolean inRange(int i, int j){
        return i >= 0 && i < r && j >= 0 && j < c;
    }
}
