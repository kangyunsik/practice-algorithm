package com.codingtest.algorithm.acmicpc.q2531;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();
        int[] arr = new int[n * 2];
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i + n] = Integer.parseInt(br.readLine());
        }

        int[] count = new int[d + 1];
        for (int i = 0; i < k; i++) {
            set.add(arr[i]);
            count[arr[i]]++;
        }
        int ans = 0;
        for (int i = k; i < n * 2; i++) {
            if (count[c] == 0) {
                ans = Math.max(ans, set.size() + 1);
            } else {
                ans = Math.max(ans, set.size());
            }
            count[arr[i - k]]--;
            if (count[arr[i - k]] == 0) {
                set.remove(arr[i - k]);
            }
            if (count[arr[i]] == 0) set.add(arr[i]);
            count[arr[i]]++;
        }

        if (count[c] == 0) {
            ans = Math.max(ans, set.size() + 1);
        } else {
            ans = Math.max(ans, set.size());
        }
        System.out.println(ans);
    }
}
