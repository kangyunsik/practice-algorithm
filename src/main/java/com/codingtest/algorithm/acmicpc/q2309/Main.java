package com.codingtest.algorithm.acmicpc.q2309;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] input = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            input[i] = Integer.parseInt(br.readLine());
            sum += input[i];
        }
        Arrays.sort(input);
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {

                if(sum - input[i] - input[j] == 100){
                    for (int k = 0; k < 9; k++) {
                        if(k != i && k != j){
                            bw.write(input[k]+"\n");
                        }
                    }
                    bw.flush();
                    return;
                }
            }
        }
    }
}
