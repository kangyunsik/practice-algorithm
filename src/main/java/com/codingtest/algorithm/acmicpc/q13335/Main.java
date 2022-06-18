package com.codingtest.algorithm.acmicpc.q13335;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> queue = new LinkedList<>();
        int time = 0, idx = 0;
        for (int i = 0; i < w; i++) {
            queue.offer(0);
        }

        while (idx < n) {
            l += queue.poll();
            if (arr[idx] > l) {
                queue.offer(0);
            } else {
                l -= arr[idx];
                queue.offer(arr[idx]);
                idx++;
            }
            time++;
        }
        time += queue.size();
        System.out.println(time);
    }
}