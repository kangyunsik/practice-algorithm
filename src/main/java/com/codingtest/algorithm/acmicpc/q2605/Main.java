package com.codingtest.algorithm.acmicpc.q2605;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] student = new int[n];
        for (int i = 0; i < n; i++) {
            student[i] = i + 1;
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            for (int j = 0; j < input; j++) {
                swap(student, i - j, i - j - 1);
            }
        }
        for (int i : student) {
            sb.append(i).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
