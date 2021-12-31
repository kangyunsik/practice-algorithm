package com.codingtest.algorithm.acmicpc.q1069;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int x,y,d,t;
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        int cnt = 0;
        double current = Math.sqrt(x*x+y*y);
        double ans = current;
        if(current > d){
            int ceil = (int) Math.ceil(current / d);
            ans = Math.min(ans, ceil * t);
        }else{
            ans = Math.min(ans, t*2);
        }

        do{
            cnt++;
            ans = Math.min(ans, Math.abs(current - d * cnt) + t * cnt);
        }while(current - cnt * d >= 0);

        bw.write(ans+"\n");
        bw.flush();

    }
}
