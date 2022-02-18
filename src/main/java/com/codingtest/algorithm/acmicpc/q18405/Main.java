package com.codingtest.algorithm.acmicpc.q18405;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<int[]> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int input = Integer.parseInt(st.nextToken());
                if(input != 0){
                    temp.add(new int[]{input, i, j});
                }
            }
        }
        Collections.sort(temp, Comparator.comparingInt(i -> i[0]));

        st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken())-1;
        int y = Integer.parseInt(st.nextToken())-1;
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for (int[] pos : temp) {
            int dist = calcDist(pos[1], pos[2], x, y);
            if(dist < min && dist <= s){
                min = dist;
                ans = pos[0];
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static int calcDist(int x1, int y1, int x2, int y2){
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
