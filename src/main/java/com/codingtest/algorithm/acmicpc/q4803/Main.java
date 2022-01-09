package com.codingtest.algorithm.acmicpc.q4803;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int ans;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] edges;
        int[] parent;
        Map<Integer, Integer> temp = new HashMap<>();
        for(int cnt = 1; n!=0 || m!=0;cnt++){
            ans = 0;
            parent = new int[n];
            edges = new int[m][2];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                edges[i][0] = Integer.parseInt(st.nextToken()) - 1;
                edges[i][1] = Integer.parseInt(st.nextToken()) - 1;
                union(parent, edges[i][0], edges[i][1]);
            }

            for (int i = 0; i < m; i++) {
                int p = getParent(parent, edges[i][0]);
                temp.put(p, temp.getOrDefault(p, 0) + 1);
            }
            for (int i = 0; i < n; i++) {
                int p = getParent(parent, i);
                temp.put(p, temp.getOrDefault(p, 0) - 1);
            }
            for (Integer value : temp.values()) {
                if (value == -1) {
                    ans++;
                }
            }

            bw.write("Case " + cnt + ": ");
            if (ans == 0) bw.write("No trees.\n");
            else if (ans == 1) bw.write("There is one tree.\n");
            else bw.write("A forest of " + ans + " trees.\n");

            bw.flush();

            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            temp.clear();
        }
    }

    private static void union(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    private static int getParent(int[] parent, int a) {
        if (parent[a] == a) return a;
        return parent[a] = getParent(parent, parent[a]);
    }
}
