package com.codingtest.algorithm.acmicpc.q2075;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n,temp;
        int[][] array;
        int[] ptr;
        n = Integer.parseInt(br.readLine());
        array = new int[n][n];
        ptr = new int[n];
        Arrays.fill(ptr,n-1);
        for (int i = 0; i < n; i++) {
            array[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        temp = n;
        int max = 0;
        while(temp-->0){
            int index = 0;
            max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                if(max < array[ptr[i]][i]){
                    max = array[ptr[i]][i];
                    index = i;
                }
            }
            ptr[index]--;
        }
        bw.write(max+"");
        bw.flush();
    }
}
