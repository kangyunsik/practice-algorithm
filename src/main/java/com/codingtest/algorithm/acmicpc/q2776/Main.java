package com.codingtest.algorithm.acmicpc.q2776;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            br.readLine();
            Set<Integer> note = new HashSet<>();
            st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()){
                note.add(Integer.parseInt(st.nextToken()));
            }
            br.readLine();
            st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()){
                if(note.contains(Integer.parseInt(st.nextToken()))){
                    sb.append("1\n");
                }else{
                    sb.append("0\n");
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
