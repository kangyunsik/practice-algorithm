package com.codingtest.algorithm.acmicpc.q15649;

import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static BufferedWriter bw;
    static List<String> saved;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        saved = new ArrayList<>();

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = i+1;
        }
        permute(ints,0);
        Collections.sort(saved);
        for (String s : saved) {
            bw.write(s+"\n");
        }
        bw.flush();
    }

    private static void save(int[] ints, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(ints[i]).append(" ");
        }
        saved.add(sb.toString());
    }

    private static void permute(int[] ints, int depth) {
        if(depth == m){
            save(ints, m);
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(ints, i, depth);
            permute(ints, depth+1);
            swap(ints, i, depth);
        }
    }

    private static void swap(int[] ints, int a, int b){
        int temp = ints[a];
        ints[a] = ints[b];
        ints[b] = temp;
    }
}
