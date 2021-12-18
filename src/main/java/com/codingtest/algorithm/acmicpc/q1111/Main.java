package com.codingtest.algorithm.acmicpc.q1111;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] values = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if (n == 1) {
            bw.write("A");
            bw.flush();
            return;
        }

        Set<Index> pos = new HashSet<>();
        Set<Index> forRemove = new HashSet<>();
        Set<Integer> answer = new HashSet<>();
        for (int a = -100000; a <= 100000; a++) {
            int b = values[1] - a * values[0];
            pos.add(new Index(a, b));

        }

        for (int i = 1; i < n - 1; i++) {
            forRemove.clear();
            for (Index p : pos) {
                if (p.a * values[i] + p.b != values[i + 1]) {
                    forRemove.add(p);
                }
            }

            for (Index p : forRemove) {
                pos.remove(p);
            }
        }

        for (Index p : pos) {
            answer.add(p.a * values[n - 1] + p.b);
        }

        if (answer.size() == 0) {
            bw.write("B");
        } else if (answer.size() == 1) {
            bw.write(answer.iterator().next() + "");
        } else {
            bw.write("A");
        }
        bw.flush();
    }
}

class Index {
    int a, b;

    public Index(int a, int b) {
        this.a = a;
        this.b = b;
    }
}