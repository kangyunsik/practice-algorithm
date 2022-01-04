package com.codingtest.algorithm.acmicpc.q11497;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test_case = Integer.parseInt(br.readLine());
        int n, max;
        int[] array;
        int[] temp;
        for (int test = 0; test < test_case; test++) {
            n = Integer.parseInt(br.readLine());
            array = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(array);
            max = 0;
            temp = new int[n];
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    temp[i / 2] = array[i];
                } else {
                    temp[n - 1 - (i / 2)] = array[i];
                }
            }
            for (int i = 0; i < n - 1; i++) {
                max = Math.max(max, Math.abs(temp[i] - temp[i + 1]));
            }
            max = Math.max(max, Math.abs(temp[0] - temp[n - 1]));
            bw.write(max + "\n");
            bw.flush();
        }
    }
}
