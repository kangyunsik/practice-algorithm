package com.codingtest.algorithm.acmicpc.q1717;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int getParent(int a){
        if(parent[a] == a) return a;
        else return parent[a] = getParent(parent[a]);
    }

    private static void union(int a, int b){
        a = getParent(a);
        b = getParent(b);

        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    private static void find(int a,int b) throws IOException {
        a = getParent(a);
        b = getParent(b);
        if(a==b){
            bw.write("YES\n");
        }else{
            bw.write("NO\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n,m,o,a,b;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine()," ");
            o = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if(o == 0){
                union(a,b);
            }else{
                find(a,b);
            }
        }
        bw.flush();

    }
}
