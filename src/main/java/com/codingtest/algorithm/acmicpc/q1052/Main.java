package com.codingtest.algorithm.acmicpc.q1052;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int ans = 0;
        while(getCount(n) > k){
            n++;
            ans++;
        }
        bw.write(ans+"");
        bw.flush();
    }

    private static int getCount(int value){
        int count = 0;
        while(value > 0){
            count += (value & 1);
            value >>= 1;
        }
        return count;
    }
}
