package com.codingtest.algorithm.acmicpc.q18115;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] array = new int[n];
        int head = 0, second = 1, tail = n - 1, cur = n;
        for (int order : input) {
            if (order == 1) {
                array[head++] = cur--;
                while (head < n && array[head] != 0) head++;
                if (head >= second) {
                    second = head + 1;
                    while (second < n && array[second] != 0) second++;
                }
            } else if (order == 2) {
                array[second++] = cur--;
                while (second < n && array[second] != 0) second++;
            } else {
                array[tail--] = cur--;
                while (tail >= 0 && array[tail] != 0) tail--;
            }
        }

        for (int i : array) {
            bw.write(i + " ");
        }
        bw.flush();
    }
}
