package com.codingtest.algorithm.acmicpc.q18511;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_LEN = 9;
    static int kind, min, ans;
    static int[] seq = new int[MAX_LEN];
    static int[] val;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        min = Integer.parseInt(st.nextToken());
        kind = Integer.parseInt(st.nextToken());
        val = new int[kind + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= kind; i++) {
            val[i] = Integer.parseInt(st.nextToken());
        }

        findCases(0);
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static void findCases(int cur) {
        if (cur == MAX_LEN) {
            int temp = makeInt();
            if(temp <= min){
                ans = Math.max(ans, temp);
            }
            return;
        }
        for (int i = 0; i <= kind; i++) {
            seq[cur] = i;
            findCases(cur + 1);
        }
    }

    private static int makeInt() {
        int ret = 0;
        int cur = 0;
        while(cur < MAX_LEN && seq[cur] == 0) cur++;
        for (int i = cur; i < MAX_LEN; i++) {
            if(seq[i] == 0) return 0;
            ret *= 10;
            ret += val[seq[i]];
        }
        return ret;
    }
}
