package com.codingtest.algorithm.acmicpc.q1450;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static int[] w;
    static int n, c, ans;
    static Map<Integer, Integer> even = new HashMap<>();
    static TreeMap<Integer, Integer> odd = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        w = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dfsEven(0, 0);
        dfsOdd(1, 0);
        List<Pair> list = new ArrayList<>();
        for (Integer key : odd.keySet()) {
            list.add(new Pair(key, odd.get(key)));
        }
        for (int i = 1; i < list.size(); i++) {
            list.get(i).y += list.get(i - 1).y;
            odd.put(list.get(i).x, list.get(i).y);
        }

        for (Integer key : even.keySet()) {
            Integer next = odd.floorKey(c - key);
            if (next != null) {
                ans += odd.get(next) * even.get(key);
            }
        }
        bw.write(ans + "\n");
        bw.flush();
    }

    private static void dfsEven(int index, int sum) {
        if (sum > c) {
            return;
        }
        if (index >= w.length) {
            even.put(sum, even.getOrDefault(sum, 0) + 1);
            return;
        }
        dfsEven(index + 2, sum + w[index]);
        dfsEven(index + 2, sum);
    }

    private static void dfsOdd(int index, int sum) {
        if (sum > c) {
            return;
        }
        if (index >= w.length) {
            odd.put(sum, odd.getOrDefault(sum, 0) + 1);
            return;
        }
        dfsOdd(index + 2, sum + w[index]);
        dfsOdd(index + 2, sum);
    }

}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
