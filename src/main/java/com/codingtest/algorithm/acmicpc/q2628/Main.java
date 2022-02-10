package com.codingtest.algorithm.acmicpc.q2628;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer> left = new ArrayList<>();
        List<Integer> top = new ArrayList<>();
        left.add(0);
        top.add(0);
        left.add(m);
        top.add(n);

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            if(st.nextToken().equals("0")){
                left.add(Integer.parseInt(st.nextToken()));
            }else{
                top.add(Integer.parseInt(st.nextToken()));
            }
        }
        Collections.sort(left);
        Collections.sort(top);
        int ans = 0;
        for (int i = 1; i < left.size(); i++) {
            for (int j = 1; j < top.size(); j++) {
                int temp = (left.get(i) - left.get(i - 1)) * (top.get(j) - top.get(j - 1));
                ans = Math.max(ans, temp);
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
