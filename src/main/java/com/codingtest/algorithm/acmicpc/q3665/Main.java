package com.codingtest.algorithm.acmicpc.q3665;

import java.io.*;
import java.util.*;

public class Main {

    static int[] required, rank;
    static List<Integer>[] next;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        lb:
        for (int test_case = 0; test_case < T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n + 1];
            next = new List[n + 1];
            required = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                next[i] = new ArrayList<>();
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i < n; i++) {
                required[arr[i]] = rank[arr[i]] = n - i;
                for (int j = i + 1; j <= n; j++) {
                    next[arr[j]].add(arr[i]);
                }
            }
            int m = Integer.parseInt(br.readLine());
            for (int i = 0, a, b; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                reverse(a, b);
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if (required[arr[i]] == 0) {
                    q.offer(arr[i]);
                }
            }

            Stack<Integer> ans = new Stack<>();
            while (!q.isEmpty()) {
                if (q.size() > 1) {
                    sb.append("?").append("\n");
                    continue lb;
                }
                Integer cur = q.poll();
                ans.push(cur);
                for (Integer tmp : next[cur]) {
                    if (--required[tmp] == 0) {
                        q.offer(tmp);
                    }
                }
            }
            if(ans.size() != n){
                sb.append("IMPOSSIBLE").append("\n");
                continue;
            }

            while(!ans.isEmpty()){
                sb.append(ans.pop()).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void reverse(int a, int b) {
        if(rank[a] < rank[b]){
            required[a]++;
            required[b]--;
            for (int i = 0; i < next[a].size(); i++) {
                if(next[a].get(i) == b) {
                    next[a].remove(i);
                    break;
                }
            }
            next[b].add(a);
        }else{
            reverse(b, a);
        }
    }
}