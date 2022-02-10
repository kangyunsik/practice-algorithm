package com.codingtest.algorithm.acmicpc.q15666;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> list = new ArrayList<>();
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static int[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        selected = new int[m];
        int input;
        for (int i = 0; i < n; i++) {
            input = Integer.parseInt(st.nextToken());
            if (!list.contains(input)) {
                list.add(input);
            }
        }
        Collections.sort(list);
        comb(0, 0);
        bw.write(sb.toString());
        bw.flush();
    }

    private static void comb(int cur, int start) {
        if (cur == m) {
            for (int i = 0; i < cur; i++) {
                sb.append(list.get(selected[i])).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < list.size(); i++) {
            selected[cur] = i;
            comb(cur + 1, i);
        }

    }
}
