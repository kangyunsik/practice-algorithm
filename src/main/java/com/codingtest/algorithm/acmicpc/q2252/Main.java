package com.codingtest.algorithm.acmicpc.q2252;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int[] inCount;
    static Set<Integer>[] set;
    static boolean[] already;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        inCount = new int[n];
        set = new HashSet[n];
        already = new boolean[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            if(set[a] == null) set[a] = new HashSet<>();
            set[a].add(b);
            inCount[b]++;
        }

        for (int i = 0; i < n; i++) {
            int v = peak();
            if(set[v] != null) {
                for (Integer out : set[v]) {
                    inCount[out]--;
                }
            }
            bw.write((v+1)+" ");
        }
        bw.flush();

    }
    private static int peak(){
        for (int i = 0; i < set.length; i++) {
            if(!already[i] && inCount[i] == 0){
                already[i] = true;
                return i;
            }
        }
        return -1;
    }
}
