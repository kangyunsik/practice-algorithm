package com.codingtest.algorithm.acmicpc.q1205;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int rate = 1;
        if(n != 0)
            st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = n;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] < s) {
                ans = i;
            } else {
                break;
            }
        }

        if (ans < p) {
            int temp = ans;
            while (temp > 0 && arr[temp - 1] == s) temp--;
            bw.write(String.valueOf(temp+1));
        } else {
            bw.write("-1");
        }
        bw.flush();
    }
}


