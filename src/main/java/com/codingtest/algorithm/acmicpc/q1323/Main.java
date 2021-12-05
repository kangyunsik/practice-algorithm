package com.codingtest.algorithm.acmicpc.q1323;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Set<Long> already = new HashSet<>();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long remain = 0L;
        long ten = 1L;
        while(ten <= n) ten *= 10;

        do {
            remain *= ten;
            remain += n;
            remain %= k;
            if (already.contains(remain)) {
                break;
            }
            already.add(remain);
        } while (remain != 0);

        bw.write(remain == 0 ? already.size() + "" : "-1");
        bw.flush();
    }
}
