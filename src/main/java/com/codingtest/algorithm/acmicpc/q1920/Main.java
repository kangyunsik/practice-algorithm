package com.codingtest.algorithm.acmicpc.q1920;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Set<Integer> set = new HashSet<>();

        int n,m;
        String input;

        br.readLine();
        input = br.readLine();
        st = new StringTokenizer(input," ");

        while(st.hasMoreTokens()){
            set.add(Integer.parseInt(st.nextToken()));
        }

        br.readLine();
        input = br.readLine();
        st = new StringTokenizer(input, " ");

        while(st.hasMoreTokens()){
            if(set.contains(Integer.parseInt(st.nextToken()))){
                bw.write("1\n");
            }else{
                bw.write("0\n");
            }
        }

        bw.flush();
    }
}
