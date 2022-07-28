package com.codingtest.algorithm.acmicpc.q13019;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        if(isParallel(a, b)){
            System.out.println(-1);
            return;
        }
        int i, j, len = a.length(), ans = 0;
        i = j = len - 1;
        while(i >= 0){
            if(a.charAt(i) != b.charAt(j)) ans++;
            else j--;
            i--;
        }
        System.out.println(ans);
    }

    private static boolean isParallel(String a, String b) {
        char[] x = a.toCharArray();
        char[] y = b.toCharArray();
        Arrays.sort(x);
        Arrays.sort(y);
        for (int i = 0; i < x.length; i++) {
            if(x[i] != y[i]) return true;
        }
        return false;
    }
}