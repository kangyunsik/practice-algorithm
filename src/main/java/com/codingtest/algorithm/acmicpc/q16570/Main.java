package com.codingtest.algorithm.acmicpc.q16570;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] pi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        pi = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[n-1-i] = Integer.parseInt(st.nextToken());
        }
        getPi(arr);
        int max = 0;
        int cnt = 0;
        for (int v : pi) {
            if(v > max){
                max = v;
                cnt = 1;
            }else if(v == max){
                cnt++;
            }
        }
        if(max == 0) bw.append("-1");
        else bw.append(String.valueOf(max)).append(" ").append(String.valueOf(cnt));
        bw.flush();
    }

    private static void getPi(int[] arr) {
        for (int i = 1, j = 0, len = arr.length; i < len; i++) {
            while (j > 0 && arr[i] != arr[j]) j = pi[j - 1];
            if (arr[i] == arr[j]) pi[i] = ++j;
        }
    }
}
