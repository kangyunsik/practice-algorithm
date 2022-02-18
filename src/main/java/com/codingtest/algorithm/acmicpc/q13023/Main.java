package com.codingtest.algorithm.acmicpc.q13023;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] edges;
    static boolean[] isSelected;
    static int n, m, cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        edges = new List[n];
        isSelected = new boolean[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }

        int a, b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dfs(i)) {
                ans = 1;
                break;
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static boolean dfs(int cur) {
        isSelected[cur] = true;
        cnt++;
        if (cnt == 5) {
            return true;
        }
        for (Integer next : edges[cur]) {
            if(!isSelected[next] && dfs(next))
                return true;
        }
        isSelected[cur] = false;
        cnt--;
        return false;
    }
}
