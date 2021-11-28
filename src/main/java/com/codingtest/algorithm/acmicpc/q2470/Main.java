package com.codingtest.algorithm.acmicpc.q2470;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[] value;
        int answer = Integer.MAX_VALUE;
        int n = Integer.parseInt(br.readLine());
        value = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(value);
        int left = 0;
        int right = n-1;
        int rem_a = 0, rem_b = 0;

        while(left < right){
            int temp = Math.abs(value[left] + value[right]);
            if(answer > temp){
                answer = temp;
                rem_a = left;
                rem_b = right;
            }
            if(value[left] + value[right] > 0){
                right--;
            }else{
                left++;
            }
        }
        if(value[rem_a] < value[rem_b])
            bw.write(value[rem_a] +" "+ value[rem_b]);
        else
            bw.write(value[rem_b] +" "+ value[rem_a]);
        bw.flush();
    }
}
