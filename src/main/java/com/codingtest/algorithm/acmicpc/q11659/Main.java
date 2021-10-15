package com.codingtest.algorithm.acmicpc.q11659;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    int[] array;
    int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n, m;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[] array = new int[n];
        for (int i = 0; st.hasMoreTokens(); i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Main main = new Main();
        main.init(array);
        main.run();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            bw.write(main.getAnswer(s,e) + "\n");
        }
        bw.flush();
    }

    public void init(int[] array) {
        this.array = array;
        this.sum = new int[array.length+1];
    }

    public void run() {
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i-1] + array[i-1];
        }
    }

    public int getAnswer(int s, int e) {
        return sum[e] - sum[s-1];
    }
}
