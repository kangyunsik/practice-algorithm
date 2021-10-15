package com.codingtest.algorithm.acmicpc.q11660;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    int n;
    int[][] sum;
    int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Main main = new Main(n, m);
        for (int i = 0; i < n; i++) {
            main.set(i,br.readLine());
        }
        for (int i = 0; i < m; i++) {
            main.run(i,br.readLine());
        }
        for (int i : main.getAnswer()) {
            bw.write(i+"\n");
        }
        bw.flush();

    }

    public Main(int n, int m) {
        this.n = n;
        sum = new int[n][n + 1];
        answer = new int[m];
    }

    void set(int index, String input) {
        StringTokenizer st = new StringTokenizer(input, " ");
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            sum[index][i + 1] = value + sum[index][i];
        }
    }

    void run(int index, String input) {
        StringTokenizer st = new StringTokenizer(input, " ");
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        for (int i = x1 - 1; i < x2; i++) {
            answer[index] += sum[i][y2] - sum[i][y1-1];
        }
    }

    int[] getAnswer() {
        return this.answer;
    }
}
