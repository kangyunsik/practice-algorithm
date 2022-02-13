package com.codingtest.algorithm.acmicpc.q15664;

import java.io.*;
import java.util.*;

public class Main {
    static int[] selected, input;
    static int n, m;
    static List<String> ans = new ArrayList<>();
    static Set<String> already = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        input = new int[n];
        selected = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        find(0,0);
        for (String a : ans) {
            sb.append(a);
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static void find(int cur, int start) {
        if (cur == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(input[selected[i]]).append(" ");
            }
            sb.append("\n");
            if(already.add(sb.toString())){
                ans.add(sb.toString());
            }
            return;
        }
        for (int i = start; i < n; i++) {
            selected[cur] = i;
            find(cur + 1, i + 1);
        }
    }
}
