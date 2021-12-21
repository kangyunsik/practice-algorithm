package com.codingtest.algorithm.acmicpc.q1946;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int test = 0; test < t; test++){
            int n = Integer.parseInt(br.readLine());
            int ans = 0;
            Member[] members = new Member[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                members[i] = new Member(a,b);
            }
            Arrays.sort(members, Comparator.comparingInt(m -> m.a));
            int max = n;
            for (int i = 0; i < n; i++) {
                if(members[i].b <= max){
                    max = members[i].b;
                    ans++;
                }
            }

            bw.write(ans+"\n");
            bw.flush();
        }
    }
}

class Member{
    int a,b;

    public Member(int a, int b) {
        this.a = a;
        this.b = b;
    }
}