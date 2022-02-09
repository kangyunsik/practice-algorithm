package com.codingtest.algorithm.acmicpc.q2491;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int incIndex, incValue, decIndex, decValue, ans = 1;
        incIndex = decIndex = 0;
        incValue = decValue = input[0];
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, i - incIndex);
            ans = Math.max(ans, i - decIndex);
            if(incValue > input[i]){
                incIndex = i;
            }
            if(decValue < input[i]){
                decIndex = i;
            }
            incValue = input[i];
            decValue = input[i];
        }
        ans = Math.max(ans, n - incIndex);
        ans = Math.max(ans, n - decIndex);

        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
