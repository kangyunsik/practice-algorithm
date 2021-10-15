package com.codingtest.algorithm.acmicpc.q11723;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    int m;
    boolean[] set;
    List<Integer> answer;

    public void init(int m) {
        this.m = m;
        this.set = new boolean[21];
        this.answer = new ArrayList<>();
    }

    public void run(String w) {
        int target;
        String order = w.split(" ")[0];
        switch (order) {
            case "add":
                target = Integer.parseInt(w.split(" ")[1]);
                set[target] = true;
                break;
            case "remove":
                target = Integer.parseInt(w.split(" ")[1]);
                set[target] = false;
                break;
            case "check":
                target = Integer.parseInt(w.split(" ")[1]);
                answer.add(set[target] ? 1 : 0);
                break;
            case "toggle":
                target = Integer.parseInt(w.split(" ")[1]);
                set[target] = !set[target];
                break;
            case "all":
                for (int j = 0; j < 21; j++)
                    set[j] = true;
                break;
            case "empty":
                for (int j = 0; j < 21; j++)
                    set[j] = false;
                break;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());

        Main main = new Main();
        main.init(m);

        for (int i = 0; i < m; i++)
            main.run(br.readLine());

        for (Integer integer : main.answer)
            bw.write(integer.toString()+"\n");
        bw.flush();
    }
}
