package com.codingtest.algorithm.acmicpc.q12904;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s, t;
        s = br.readLine();
        t = br.readLine();
        int len = s.length();

        for(int r = t.length() - 1; r != len - 1; r--){
            if (t.charAt(r) == 'B') {
                t = reverse(t.substring(0,r));
            }else{
                t = t.substring(0,r);
            }
        }

        bw.write(s.equals(t) ? "1" : "0");
        bw.flush();
    }

    private static String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        int len = s.length();
        for (int i = 0; i < len/2; i++) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(len-i-1));
            sb.setCharAt(len-i-1, temp);
        }
        return sb.toString();
    }
}
