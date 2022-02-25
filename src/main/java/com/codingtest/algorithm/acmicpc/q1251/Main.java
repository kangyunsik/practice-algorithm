package com.codingtest.algorithm.acmicpc.q1251;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        String ans = "z";
        for (int i = 1, len = input.length(); i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(reverse(input.substring(0, i)))
                        .append(reverse(input.substring(i, j)))
                        .append(reverse(input.substring(j)));
                if(ans.compareTo(sb.toString()) > 0){
                    ans = sb.toString();
                }
            }
        }
        bw.write(ans);
        bw.flush();
    }

    private static String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
