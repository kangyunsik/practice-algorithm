package com.codingtest.algorithm.acmicpc.q5052;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test_case, n;
        test_case = Integer.parseInt(br.readLine());
        for (int t = 0; t < test_case; t++) {
            n = Integer.parseInt(br.readLine());
            List<String> list = new ArrayList<>();
            Map<String, Integer> pre = new HashMap<>();
            boolean find = false;
            for (int i = 0; i < n; i++) {
                list.add(br.readLine());
                for (String prefix : getPrefixes(list.get(i))) {
                    pre.put(prefix, pre.getOrDefault(prefix,0) + 1);
                }
            }

            for (String s : list) {
                if (pre.getOrDefault(s, 0) > 1) {
                    find = true;
                    break;
                }
            }
            bw.write(find ? "NO\n" : "YES\n");
        }
        bw.flush();
    }

    private static List<String> getPrefixes(String s){
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++) {
            result.add(s.substring(0,i));
        }
        return result;
    }
}
