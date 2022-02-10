package com.codingtest.algorithm.acmicpc.q2304;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] height = new int[1001];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            height[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        int left = 0, right = 1001, ans = 0;
        int leftMax = height[left], rightMax = height[right - 1];

        while(left < right - 1){
            if(leftMax <= rightMax){
                leftMax = Math.max(leftMax, height[++left]);
                ans += leftMax;
            }else{
                rightMax = Math.max(rightMax, height[--right]);
                ans += rightMax;
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
