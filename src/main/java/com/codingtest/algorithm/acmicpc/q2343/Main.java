package com.codingtest.algorithm.acmicpc.q2343;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static final int INF = (int) 1e9;
    static int n;
    static int[] values;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        values = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        int begin = 0, end = INF;
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(st.nextToken());
            begin = Math.max(begin, values[i]);
        }

        while (begin < end) {
            int mid = (begin + end) / 2;
            int div = getDivSize(mid);
            if(div > m){
                begin = mid;
                if(begin == end-1){
                    break;
                }
            }else{
                end = mid;
            }
        }
        bw.write(String.valueOf(end));
        bw.flush();
    }

    private static int getDivSize(int size){
        int sum = 0;
        int cnt = 1;
        for (int i = 0; i < n; i++) {
            sum += values[i];
            if(sum > size){
                cnt++;
                sum = values[i];
            }
        }
        return cnt;
    }
}
