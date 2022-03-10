package com.codingtest.algorithm.acmicpc.q1263;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int[][] input;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
         n = Integer.parseInt(br.readLine());
        input = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input, Comparator.comparingInt(i -> i[1]));
        int begin = 0;
        int end = 1000001;
        while(begin < end){
            int mid = (begin + end)/2;
            if(binarySearch(mid)){
                begin = mid + 1;
            }else{
                end = mid;
            }
        }
        bw.write(String.valueOf(begin - 1));
        bw.flush();
    }

    private static boolean binarySearch(int beginTime) {
        int curTime = beginTime;
        for (int i = 0; i < n; i++) {
            curTime += input[i][0];
            if(curTime > input[i][1]) {
                return false;
            }
        }
        return true;
    }
}
