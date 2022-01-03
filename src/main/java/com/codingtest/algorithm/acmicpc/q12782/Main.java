package com.codingtest.algorithm.acmicpc.q12782;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test_case = Integer.parseInt(br.readLine());
        String []input;
        String left, right;
        int lcnt, rcnt;
        for (int test = 0; test < test_case; test++) {
            input = br.readLine().split(" ");
            lcnt = rcnt = 0;
            left = input[0];
            right = input[1];
            for (int i = 0; i < left.length(); i++) {
                if(left.charAt(i) != right.charAt(i)){
                    if(left.charAt(i) == '1'){
                        lcnt++;
                    }else{
                        rcnt++;
                    }
                }
            }
            bw.write(Math.max(lcnt,rcnt)+"\n");
            bw.flush();
        }
    }
}
