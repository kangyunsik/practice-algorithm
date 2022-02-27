package com.codingtest.algorithm.acmicpc.q12104;

import java.io.*;

public class Main {
    static int[] pi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String binary1 = br.readLine();
        String binary2 = br.readLine();
        int binary1Len = binary1.length();
        int binary2Len = binary2.length();
        pi = new int[binary2Len];
        getPi(binary2);
        int cnt = 0;
        for (int i = 0, j = 0; i < binary1Len * 2 - 1; i++) {
            while(j > 0 && binary1.charAt(i % binary1Len) != binary2.charAt(j)) j = pi[j - 1];
            if(binary1.charAt(i % binary1Len) != binary2.charAt(j)) continue;
            if(++j == binary2Len){
                cnt++;
                j = pi[j - 1];
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static void getPi(String binary) {
        for (int i = 1, j = 0, len = binary.length(); i < len; i++) {
            while (j > 0 && binary.charAt(i) != binary.charAt(j)) j = pi[j - 1];
            if (binary.charAt(i) == binary.charAt(j)) pi[i] = ++j;
        }
    }
}
