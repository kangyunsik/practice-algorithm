package com.codingtest.algorithm.acmicpc.q1410;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static final int MOD = 1000003;
    static int len, n;
    static int[][] values;
    static long tmp, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[] input;
        values = new int[n][];
        for (int i = 0; i < n; i++) {
            input = br.readLine().toCharArray();
            len = input.length;
            values[i] = new int[len];
            for (int j = 0; j < len; j++) {
                values[i][j] = input[j] == '?' ? ((1 << 26) - 1) : (1 << (input[j] - 'a'));
            }
        }

        int cur = k;
        while (cur <= n) {
            tmp = 0;
            findCases(0, new boolean[n], 0, cur);
            long com = comb(cur, k);
            if (cur % 2 != k % 2)
                tmp = MOD - tmp;
            ans += tmp * com;
            ans %= MOD;
            cur++;
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static long comb(int n, int r) {
        long ret = 1L;
        for (int i = 0; i < r; i++) {
            ret *= n--;
        }
        for (int i = 0; i < r; i++) {
            ret /= (i + 1);
        }
        return ret;
    }

    private static void findCases(int cur, boolean[] selected, int cnt, int k) {
        if (cnt == k) {
            calcTmp(selected);
            return;
        } else if (cur == n) {
            return;
        }
        selected[cur] = true;
        findCases(cur + 1, selected, cnt + 1, k);
        selected[cur] = false;
        findCases(cur + 1, selected, cnt, k);
    }

    private static void calcTmp(boolean[] selected) {
        int[] temp = new int[len];
        Arrays.fill(temp, (1 << 26) - 1);
        for (int index = 0; index < n; index++) {
            if (!selected[index]) continue;
            for (int i = 0; i < len; i++) {
                temp[i] &= values[index][i];
            }
        }
        long ret = 1L;
        for (int bit : temp) {
            ret *= Integer.bitCount(bit);
            ret %= MOD;
        }
        tmp += ret;
        tmp %= MOD;
    }
}
