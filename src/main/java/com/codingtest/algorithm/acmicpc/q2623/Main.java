package com.codingtest.algorithm.acmicpc.q2623;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int remain = 0;

        boolean[][] has = new boolean[m][n];
        boolean[] check = new boolean[n];
        Queue<Integer>[] queues = new Queue[m];
        for (int i = 0; i < m; i++) {
            queues[i] = new LinkedList<>();
            st = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                int input = Integer.parseInt(st.nextToken()) - 1;
                remain++;
                queues[i].offer(input);
                has[i][input] = true;
            }
        }

        int prev;
        do {
            prev = remain;
            lb:
            for (int qIdx = 0; qIdx < m; qIdx++) {
                while (!queues[qIdx].isEmpty() && !has[qIdx][queues[qIdx].peek()]) {
                    queues[qIdx].poll();
                    remain--;
                }
                if (queues[qIdx].isEmpty()) continue;
                int peek = queues[qIdx].peek();
                for (int i = 0; i < m; i++) {
                    if (i == qIdx) continue;
                    if (has[i][peek] && !queues[i].isEmpty() && queues[i].peek() != peek)
                        continue lb;
                }
                for (int i = 0; i < m; i++) {
                    has[i][peek] = false;
                }
                check[peek] = true;
                sb.append(queues[qIdx].poll() + 1).append("\n");
                remain--;
            }
        } while (remain > 0 && remain != prev);

        if(remain > 0){
            bw.write("0");
            bw.flush();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!check[i]) sb.append(i + 1).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
