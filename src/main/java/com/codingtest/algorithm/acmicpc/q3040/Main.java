package com.codingtest.algorithm.acmicpc.q3040;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int[] input = new int[9];
        int sum = 0;
        int i, j = -1;

        for (i = 0; i < 9; i++) {
            input[i] = Integer.parseInt(br.readLine());
            sum += input[i];
        }

        lb:
        for (i = 0; i < 8; i++)
            for (j = i + 1; j < 9; j++)
                if (sum - input[i] - input[j] == 100)
                    break lb;

        for (int a = 0; a < 9; a++)
            if (a != i && a != j)
                sb.append(input[a]).append("\n");
        bw.write(sb.toString());
        bw.flush();
    }
}
