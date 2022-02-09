package com.codingtest.algorithm.acmicpc.q2578;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<Integer, int[]> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[] rows = {5, 5, 5, 5, 5};
        int[] cols = {5, 5, 5, 5, 5};
        int[] dia = {5, 5};
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                map.put(Integer.parseInt(st.nextToken()), new int[]{i, j});
            }
        }

        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                int[] pos = map.get(Integer.parseInt(st.nextToken()));
                if (--rows[pos[0]] == 0) cnt++;
                if (--cols[pos[1]] == 0) cnt++;
                if (pos[0] == pos[1] && --dia[0] == 0) cnt++;
                if (pos[0] + pos[1] == 4 && --dia[1] == 0) cnt++;
                if (cnt >= 3) {
                    bw.write(String.valueOf(5 * i + j + 1));
                    bw.flush();
                    return;
                }
            }
        }
    }
}
