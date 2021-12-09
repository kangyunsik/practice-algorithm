package com.codingtest.algorithm.acmicpc.q11004;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        st.nextToken();
        int k = Integer.parseInt(st.nextToken());
        int[] values = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(values);
        System.out.println(values[k-1]);
    }

}
