package com.codingtest.algorithm.acmicpc.q1025;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] values;
    static int n,m,ans = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> dxs = new ArrayList<>();
        List<Integer> dys = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dxs.add(0);
        for (int i = 1; i < n; i++) {
            dxs.add(i);
            dxs.add(-i);
        }

        dys.add(0);
        for (int i = 1; i < m; i++) {
            dys.add(i);
            dys.add(-i);
        }

        values = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                values[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (Integer dx : dxs) {
                    for (Integer dy : dys) {
                        find(i, j, dx, dy);
                    }
                }
            }
        }

        bw.write(ans+"\n");
        bw.flush();
    }

    static void find(int x, int y, int dx, int dy){
        int value = values[x][y];
        if(isSquare(value)){
            ans = Math.max(ans, value);
        }
        while(inRange(x+dx,y+dy) && !(dx == 0 && dy == 0)){
            x += dx;
            y += dy;
            value *= 10;
            value += values[x][y];
            if (isSquare(value)) {
                ans = Math.max(ans, value);
            }
        }
    }

    static boolean isSquare(int value){
        int temp = (int)Math.sqrt(value);
        return temp*temp == value;
    }

    static boolean inRange(int x, int y){
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}
