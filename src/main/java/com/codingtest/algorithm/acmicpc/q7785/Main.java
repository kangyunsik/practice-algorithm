package com.codingtest.algorithm.acmicpc.q7785;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        String input;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            input = st.nextToken();
            if(st.nextToken().equals("enter")){
                set.add(input);
            }else{
                set.remove(input);
            }
        }
        List<String> list = new ArrayList<>(set);
        Collections.sort(list, Comparator.reverseOrder());
        for (String s : list) {
            sb.append(s).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
