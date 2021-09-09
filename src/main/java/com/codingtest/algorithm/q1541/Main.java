package com.codingtest.algorithm.q1541;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    int[] number;
    char[] op;
    int[][] dynamic;
    StringTokenizer st;
    int count;

    public void init(String string) {
        st = new StringTokenizer(string, "+|-");
        count = st.countTokens();
        number = new int[count];

        op = string.replaceAll("[0-9]", "").toCharArray();

        for (int i = 0; st.hasMoreTokens(); i++)
            number[i] = Integer.parseInt(st.nextToken());

        dynamic = new int[count][count];

        for (int i = 0; i < count * count; i++) {
            if (i / count == i % count) {
                dynamic[i / count][i % count] = number[i / count];
            } else
                dynamic[i / count][i % count] = Integer.MAX_VALUE;
        }
    }

    public void run() {
        find(0, count - 1);
    }

    public int find(int start, int end) {
        if (dynamic[start][end] != Integer.MAX_VALUE)
            return dynamic[start][end];
        else {
            int temp = Integer.MAX_VALUE;
            int target;
            for (int i = start; i < end; i++) {
                target  = op[i] == '+' ?
                        find(start, i) + find(i + 1, end) :
                        find(start, i) - find(i + 1, end);

                temp    = temp > target ? target : temp;
            }

            return dynamic[start][end] = temp;
        }
    }

    public int getAnswer() {
        return dynamic[0][count - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Main main = new Main();
        main.init(br.readLine());
        main.run();

        bw.write(Integer.toString(main.getAnswer()));
        bw.flush();
    }
}
