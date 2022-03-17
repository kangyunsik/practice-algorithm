package com.codingtest.algorithm.acmicpc.q16637;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[n / 2 + 1];
        char[] ops = new char[n / 2];
        char[] input = br.readLine().toCharArray();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) ints[i / 2] = input[i] - '0';
            else ops[i / 2] = input[i];
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < 1 << n / 2; i++) {
            String binaryString = Integer.toBinaryString(i);
            if (binaryString.contains("11")) continue;
            List<Integer> numList = new ArrayList<>();
            List<Character> opList = new ArrayList<>();
            for (int t : ints) numList.add(t);
            for (char c : ops) opList.add(c);
            for (int j = n / 2 - 1; j >= 0; j--) {
                if ((i & 1 << j) == 0) continue;
                operateListAt(numList, j, opList);
            }
            while (numList.size() != 1) {
                operateListAt(numList, 0, opList);
            }
            ans = Math.max(ans, numList.get(0));
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static void operateListAt(List<Integer> numList, int j, List<Character> opList) {
        numList.set(j, calc(numList.get(j), numList.get(j + 1), opList.get(j)));
        numList.remove(j + 1);
        opList.remove(j);
    }

    private static int calc(int v1, int v2, char op) {
        if (op == '+') return v1 + v2;
        else if (op == '-') return v1 - v2;
        else return v1 * v2;
    }
}
