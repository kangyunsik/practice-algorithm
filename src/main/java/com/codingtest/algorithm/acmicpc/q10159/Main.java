package com.codingtest.algorithm.acmicpc.q10159;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<Integer>[] lessThan = new List[n + 1];
        List<Integer>[] largerThan = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            lessThan[i] = new ArrayList<>();
            largerThan[i] = new ArrayList<>();
        }

        for (int i = 0, a, b; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            largerThan[a].add(b);
            lessThan[b].add(a);
        }

        for (int i = 1, less, larger; i <= n; i++) {
            larger = dfs(i, new boolean[n + 1], largerThan);
            less = dfs(i, new boolean[n + 1], lessThan);
            bw.write(String.valueOf(n - larger - less - 1));
            bw.newLine();
        }
        bw.flush();
    }

    private static int dfs(int i, boolean[] check, List<Integer>[] edges) {
        int temp = 0;
        for (int next : edges[i]) {
            if (check[next]) continue;
            check[next] = true;
            temp += dfs(next, check, edges) + 1;
        }
        return temp;
    }
}
