package com.codingtest.algorithm.acmicpc.q1976;

import java.io.*;
import java.util.stream.Stream;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] input;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < n; j++) {
                if(input[j] == 1){
                    union(i,j);
                }
            }
        }
        String ans = "YES\n";
        int[] route = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < m-1; i++) {
            if(getParent(route[i]-1) != getParent(route[i+1]-1)){
                ans = "NO\n";
                break;
            }
        }
        bw.write(ans);
        bw.flush();
    }

    private static void union(int a, int b){
        a = getParent(a);
        b = getParent(b);
        if(a > b) parent[a] = b;
        else parent[b] = a;
    }

    private static int getParent(int a){
        if(a == parent[a]) return a;
        return parent[a] = getParent(parent[a]);
    }
}
