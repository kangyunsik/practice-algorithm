package com.codingtest.algorithm.acmicpc.q22866;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int[] rightVisible, leftVisible;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] height = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }
        rightVisible = new int[n];
        leftVisible = new int[n];
        dp = new int[2][n];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);
        Arrays.fill(rightVisible, -1);
        Arrays.fill(leftVisible, -1);
        int[][] ans = new int[n][2];

        Stack<Integer> right = new Stack<>();
        Stack<Integer> left = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!right.isEmpty() && height[right.peek()] < height[i]) {
                rightVisible[right.pop()] = (i);
            }
            while (!left.isEmpty() && height[left.peek()] < height[n - i - 1]) {
                leftVisible[left.pop()] = (n - i - 1);
            }
            left.push(n - i - 1);
            right.push(i);
        }

        for (int i = 0; i < n; i++) {
            ans[i][0] += getDP(i, 0) - 1;
            ans[i][0] += getDP(i, 1) - 1;
            if (leftVisible[i] == -1) {
                ans[i][1] = rightVisible[i];
            } else if (rightVisible[i] == -1) {
                ans[i][1] = leftVisible[i];
            } else {
                ans[i][1] = (i - leftVisible[i] <= rightVisible[i] - i ? leftVisible[i] : rightVisible[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] an : ans) {
            if (an[1] == -1)
                sb.append("0\n");
            else
                sb.append(an[0]).append(" ").append((an[1] + 1)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static int getDP(int n, int left) {
        if(n == -1) return 0;
        if(dp[left][n] != -1) return dp[left][n];
        if(left == 0){
            return dp[left][n] = getDP(rightVisible[n], left) + 1;
        }else{
            return dp[left][n] = getDP(leftVisible[n], left) + 1;
        }
    }
}
