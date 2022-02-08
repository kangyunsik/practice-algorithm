package com.codingtest.algorithm.acmicpc.q1039;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{n, k});
        Set<Integer>[] already = new Set[11];
        for (int i = 0; i <= 10; i++) {
            already[i] = new HashSet<>();
        }

        int ans = -1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if(poll[1] == 0) {
                ans = Math.max(ans, poll[0]);
                continue;
            }
            char[] chars = String.valueOf(poll[0]).toCharArray();
            int len = chars.length;
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    if(i == 0 && chars[j] == '0') continue;
                    swap(chars, i, j);
                    int temp = Integer.parseInt(new String(chars));
                    if(already[poll[1]-1].add(temp))
                        queue.offer(new int[]{temp, poll[1] - 1});
                    swap(chars, i, j);
                }
            }
        }
        bw.write(ans + "\n");
        bw.flush();
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
