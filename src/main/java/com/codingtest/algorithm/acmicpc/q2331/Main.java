package com.codingtest.algorithm.acmicpc.q2331;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; !map.containsKey(a); i++, a = getNext(a, p)) {
            map.put(a, i);
        }

        bw.write(map.get(a)+"");
        bw.flush();
    }

    private static int getNext(int a, int p) {
        int sum = 0;
        while (a > 0) {
            sum += (int) Math.pow(a % 10, p);
            a /= 10;
        }
        return sum;
    }
}
