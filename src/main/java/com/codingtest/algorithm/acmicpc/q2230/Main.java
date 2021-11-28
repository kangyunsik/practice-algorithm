package com.codingtest.algorithm.acmicpc.q2230;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = Integer.MAX_VALUE;
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        Arrays.sort(value);

        int left = 0;
        int right = 0;
        while(right < n){
            int diff = value[right] - value[left];
            if(diff >= m){
                answer = Math.min(answer, diff);
                if(++left > right) right++;
            }else{
                right++;
            }
        }

        bw.write(answer+"");
        bw.flush();
        bw.close();
    }
}
