package com.codingtest.algorithm.acmicpc.q17822;

import java.io.*;
import java.util.*;

public class Main {
    static int n, m, t;
    static Pane[] panes;
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};
    static boolean[] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        panes = new Pane[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int[] input = new int[m];
            for (int j = 0; j < m; j++) {
                input[j] = Integer.parseInt(st.nextToken());
            }
            panes[i] = new Pane(input);
        }

        int x, d, k;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                checked = new boolean[m + 1];
                for (int p = x; p <= n; p += x) {
                    if (d == 0) panes[p].rotateRight();
                    else panes[p].rotateLeft();
                }
            }
            if (!compact()) flatten();
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += panes[i].getSum();
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static void flatten() {
        double avg = 0.0;
        int cnt = 0;
        for (int idx = 1; idx <= n; idx++) {
            avg += panes[idx].getSum();
            cnt += panes[idx].getZeroCnt();
        }
        if (cnt == n * m) return;
        avg /= (n * m - cnt);
        for (int idx = 1; idx <= n; idx++) {
            for (int pos = 0; pos < m; pos++) {
                if (panes[idx].values[pos] == 0) continue;
                if (panes[idx].values[pos] > avg) panes[idx].values[pos]--;
                else if (panes[idx].values[pos] < avg) panes[idx].values[pos]++;
            }
        }
        return;
    }

    private static boolean compact() {
        Set<Integer> willRemoved = new HashSet<>();
        for (int idx = 1; idx <= n; idx++) {
            if (panes[idx].getZeroCnt() == m) continue;
            for (int pos = 0; pos < m; pos++) {
                if (panes[idx].values[pos] == 0) continue;
                for (int i = 0; i < 4; i++) {
                    int nextX = idx + dx[i];
                    int nextY = (pos + dy[i] + m) % m;
                    if (nextX > n || nextX <= 0) continue;
                    if (panes[idx].values[pos] == panes[nextX].values[nextY]) {
                        willRemoved.add(idx * 100 + pos);
                        willRemoved.add(nextX * 100 + nextY);
                    }
                }
            }
        }
        if (willRemoved.isEmpty()) return false;
        for (int pos : willRemoved) {
            panes[pos / 100].values[pos % 100] = 0;
        }
        return true;
    }

    static class Pane {
        int[] values;

        public Pane(int[] values) {
            this.values = values;
        }

        public int getSum() {
            int ret = 0;
            for (int value : values) {
                ret += value;
            }
            return ret;
        }

        public void rotateLeft() {
            int temp = values[0];
            for (int j = 0; j < m - 1; j++) {
                values[j] = values[j + 1];
            }
            values[m - 1] = temp;
        }

        public void rotateRight() {
            int temp = values[m - 1];
            for (int j = m - 1; j > 0; j--) {
                values[j] = values[j - 1];
            }
            values[0] = temp;
        }

        private int getZeroCnt() {
            int zeroCnt = 0;
            for (int value : values) {
                if (value == 0) zeroCnt++;
            }
            return zeroCnt;
        }
    }
}