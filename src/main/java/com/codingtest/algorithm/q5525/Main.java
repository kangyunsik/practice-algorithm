package com.codingtest.algorithm.q5525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public int n, m;
    public String string;
    public int answer;

    public void init(int n, int m, String string) {
        this.n = n;
        this.m = m;
        this.string = string;
        answer = 0;
    }

    public void run() {
        int value = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == 'I' && i + 1 < string.length() && string.charAt(i + 1) == 'O' &&
                    i + 2 < string.length() && string.charAt(i + 2) == 'I') {
                value++;
                i++;
            } else {
                answer += value >= n ? (value - n + 1) : 0;
                value = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main main = new Main();
        main.init(Integer.parseInt(br.readLine()),
                Integer.parseInt(br.readLine()),
                br.readLine());
        main.run();
        System.out.println(main.answer);
    }
}
