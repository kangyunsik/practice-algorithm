package com.codingtest.algorithm.acmicpc.q16943;

import java.io.*;
import java.util.*;

public class Main {
    static char[] input;
    static char[] sel;
    static int maxBound, len;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        input = st.nextToken().toCharArray();
        len = input.length;
        sel = new char[len];
        Arrays.sort(input);
        reverse(input);

        maxBound = Integer.parseInt(st.nextToken());
        System.out.println(findCases(0, 0));
    }

    private static void reverse(char[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            swap(arr, i, arr.length - 1 - i);
        }
    }

    private static void swap(char[] arr, int a, int b) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static int findCases(int depth, int selected) {
        int ret;
        if (depth == len) {
            String string = new String(sel);
            ret = Integer.parseInt(string);
            if (string.charAt(0) != '0' && ret < maxBound) {
                return ret;
            }
            else return -1;
        }

        ret = -1;
        for (int i = 0; i < len; i++) {
            if ((selected & 1 << i) > 0) continue;
            sel[depth] = input[i];
            ret = Math.max(ret, findCases(depth + 1, selected | 1 << i));
        }
        return ret;
    }
}