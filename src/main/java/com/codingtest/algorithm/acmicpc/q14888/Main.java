package com.codingtest.algorithm.acmicpc.q14888;

import java.io.*;
import java.util.Arrays;

public class Main {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    int[] values;

    public int[] solution(int n, int[] values, int[] op) {
        this.values = values;
        getValue(op, n-1, values[0]);
        return new int[]{max, min};
    }

    public void getValue(int[] op, int n, int cur) {
        if (n == 0) {
            min = Math.min(min,cur);
            max = Math.max(max,cur);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                int[] ints = Arrays.copyOf(op, op.length);
                ints[i]--;
                switch(i) {
                    case 0:getValue(ints, n - 1, cur + values[values.length - n]);break;
                    case 1:getValue(ints, n - 1, cur - values[values.length - n]);break;
                    case 2:getValue(ints, n - 1, cur * values[values.length - n]);break;
                    case 3:getValue(ints, n - 1, cur / values[values.length - n]);break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] values = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] op = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Main main = new Main();
        int[] solution = main.solution(n, values, op);
        bw.write(solution[0]+"\n"+solution[1]+"\n");
        bw.flush();
    }
}
