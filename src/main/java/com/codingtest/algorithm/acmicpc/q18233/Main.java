package com.codingtest.algorithm.acmicpc.q18233;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, p, e;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        int[][] range = new int[n][];
        for (int i = 0, begin, end; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            begin = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            range[i] = new int[]{begin, end};
        }

        int begin, end, status;
        for (int i = 1; i < 1 << n; i++) {
            if (Integer.bitCount(i) != p) continue;
            begin = end = 0;
            status = i;
            for (int j = 0; j < n; j++) {
                if ((status & (1 << j)) > 0) {
                    begin += range[j][0];
                    end += range[j][1];
                }
            }

            if (begin <= e && e <= end) {
                for (int val : getAns(range, i)) {
                    bw.append(String.valueOf(val)).append(" ");
                }
                bw.flush();
                return;
            }
        }
        bw.write("-1");
        bw.flush();
    }

    static int[] getAns(int[][] range, int status) {
        int[] temp = new int[n];
        List<Integer> idxes = new ArrayList<>();
        int remain = e;
        for (int i = 0; i < n; i++) {
            if ((status & (1 << i)) > 0) {
                idxes.add(i);
                temp[i] = range[i][0];
                remain -= temp[i];
            }
        }

        int cur = 0;
        while (remain > 0) {
            int score = Math.min(range[idxes.get(cur)][1] - temp[cur], remain);
            remain -= score;
            temp[idxes.get(cur++)] += score;
        }
        return temp;
    }
}
