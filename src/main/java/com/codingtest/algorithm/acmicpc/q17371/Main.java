package com.codingtest.algorithm.acmicpc.q17371;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 0; i < n; i++) {
            int max = -1;
            int maxIdx = -1;
            for (int j = 0; j < n; j++) {
                int dist = getDist(arr[i], arr[j]);
                if(dist > max){
                    max = dist;
                    maxIdx = i;
                }
            }
            if(ans > max){
                ans = max;
                idx = maxIdx;
            }
        }
        System.out.println(arr[idx][0] + " " + arr[idx][1]);
    }

    private static int getDist(int[] pos1, int[] pos2) {
        return (int) (Math.pow(pos1[0] - pos2[0], 2) + Math.pow(pos1[1] - pos2[1], 2));
    }
}