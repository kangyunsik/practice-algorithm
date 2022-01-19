package com.codingtest.algorithm.acmicpc.q1083;

import java.io.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] values = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(br.readLine());
        int maxIdx;
        int max;
        for (int i = 0; i < n - 1; i++) {
            max = values[i];
            maxIdx = i;
            for (int j = i + 1; j < Math.min(n, i + k + 1); j++) {
                if (max < values[j]) {
                    max = values[j];
                    maxIdx = j;
                }
            }

            for (int j = maxIdx; j > i; j--) {
                swap(values, j, j - 1);
            }
            k -= maxIdx - i;
        }

        for (int value : values) {
            bw.write(value + " ");
        }
        bw.flush();
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
