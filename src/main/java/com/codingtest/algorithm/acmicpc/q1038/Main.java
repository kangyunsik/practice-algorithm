package com.codingtest.algorithm.acmicpc.q1038;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static List<Long> temp = new ArrayList<>();
    static int[] numbers = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        addTemp(0, 0);
        Collections.sort(temp);

        if (n + 1 >= temp.size()) {
            bw.write("-1");
        } else {
            bw.write(temp.get(n+1) + "");
        }
        bw.flush();
    }

    static void addTemp(int cur, long sum) {
        if(cur == 10){
            temp.add(sum);
            return;
        }

        addTemp(cur + 1, sum * 10 + numbers[cur]);
        addTemp(cur + 1, sum);
    }
}
