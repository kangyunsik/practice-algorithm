package com.codingtest.algorithm.acmicpc.q1806;

import java.io.*;
import java.util.Arrays;

public class Main {
    public int solution(int n, int s, int[] array) {
        int sum = 0;
        int start = 0;
        int end = 0;
        int ans = Integer.MAX_VALUE;

        while (start <= end) {
            if (s <= sum) {
                ans = Math.min(ans, end - start);
                sum -= array[start++];
            } else if (end != n) {
                sum += array[end++];
            } else {
                break;
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int[] ints = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Main main = new Main();
        int result = main.solution(Integer.parseInt(input[0]), Integer.parseInt(input[1]), ints);

        bw.write(result + "");
        bw.flush();
    }
}
