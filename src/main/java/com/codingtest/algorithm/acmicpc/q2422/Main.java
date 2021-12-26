package com.codingtest.algorithm.acmicpc.q2422;

import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] notAllow;
    static int n, ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m, a, b;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        notAllow = new boolean[n][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken()) - 1;
            notAllow[a][b] = true;
            notAllow[b][a] = true;
        }
        dfs(0, new Stack<>());
        bw.write(ans + "\n");
        bw.flush();
    }

    private static void dfs(int depth, Stack<Integer> stack) {
        if (stack.size() == 3) {
            if (!notAllow[stack.get(0)][stack.get(1)] &&
                    !notAllow[stack.get(0)][stack.get(2)] &&
                    !notAllow[stack.get(1)][stack.get(2)])
                ans++;
            return;
        } else if (depth == n) {
            return;
        }

        stack.push(depth);
        dfs(depth + 1, stack);
        stack.pop();
        dfs(depth + 1, stack);
    }
}
