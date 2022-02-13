package com.codingtest.algorithm.acmicpc.q2529;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] selected;
    static char[] cs;
    static int m;
    static String min, max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        m = Integer.parseInt(br.readLine());
        selected = new int[m+1];
        cs = new char[m];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            cs[i] = st.nextToken().charAt(0);
        }
        perm(0, 0);
        bw.write(max + "\n");
        bw.write(min + "\n");
        bw.flush();
    }

    private static void perm(int cur, int already){
        if(cur == m + 1){
            if(isValid()){
                StringBuilder sb = new StringBuilder();
                for (int i : selected) {
                    sb.append(i);
                }
                String result = sb.toString();
                if(min == null || result.compareTo(min) < 0){
                    min = result;
                }
                if(max == null || result.compareTo(max) > 0){
                    max = result;
                }
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            if(((1 << i) & already) == 0) {
                selected[cur] = i;
                perm(cur + 1, (1 << i) + already);
            }
        }
    }

    private static boolean isValid() {
        for (int i = 0; i < m; i++) {
            if(cs[i] == '<' && selected[i] >= selected[i+1]){
                return false;
            }else if(cs[i] == '>' && selected[i] <= selected[i+1]){
                return false;
            }
        }
        return true;
    }
}
