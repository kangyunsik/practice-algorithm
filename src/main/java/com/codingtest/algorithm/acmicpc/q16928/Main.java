package com.codingtest.algorithm.acmicpc.q16928;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public int n;
    public int m;
    int[] array;
    Map<Integer, Integer> map;
    StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Main main = new Main();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        main.init(n,m);
        for (int i = 0; i < n+m; i++) {
            main.set(br.readLine());
        }
        main.run(1,0);
        bw.write(main.getAnswer()+"\n");
        bw.flush();
    }

    public void init(int n, int m) {
        this.n = n;
        this.m = m;
        array = new int[101];
        array[1] = 0;
        map = new HashMap<>();
        Arrays.fill(array, Integer.MAX_VALUE);
    }

    public void set(String input) {
        st = new StringTokenizer(input, " ");
        map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    public void run(int index, int dep) {
        array[index] = dep;
        for (int i = 1; i <= 6 && index + i <= 100; i++) {
            int next_index = map.getOrDefault(index+i,index+i);
            if (array[next_index] > array[index] + 1)
                run(next_index, dep + 1);
        }
    }

    public int getAnswer() {
        return this.array[100];
    }
}
