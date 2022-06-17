package com.codingtest.algorithm.acmicpc.q2250;

import java.io.*;
import java.util.*;

public class Main {

    static int n, cnt;
    static int[] leftIdx, rightIdx, min, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        leftIdx = new int[n + 1];
        rightIdx = new int[n + 1];
        min = new int[n + 1];
        max = new int[n + 1];
        Arrays.fill(min, Integer.MAX_VALUE);
        StringTokenizer st;
        int a, b, c, sum = 0;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            leftIdx[a] = b;
            rightIdx[a] = c;
            sum += a;
            if (b > 0) sum += b;
            if (c > 0) sum += c;
        }

        dfs(n * (n + 1) - sum, 0);
        int depth = 1, width = 1;
        for (int i = 2; i <= n; i++) {
            int diff = max[i] - min[i] + 1;
            if (diff > width) {
                depth = i;
                width = diff;
            }
        }
        System.out.println(depth + " " + width);
    }

    private static void dfs(int cur, int depth) {
        depth++;
        if (leftIdx[cur] != -1) dfs(leftIdx[cur], depth);
        ++cnt;
        min[depth] = Math.min(min[depth], cnt);
        max[depth] = Math.max(max[depth], cnt);
        if (rightIdx[cur] != -1) dfs(rightIdx[cur], depth);
    }
}