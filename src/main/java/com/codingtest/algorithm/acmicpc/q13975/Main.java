package com.codingtest.algorithm.acmicpc.q13975;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int test_case = Integer.parseInt(br.readLine());
        long sum;
        for (int test = 0; test < test_case; test++) {
            br.readLine();
            PriorityQueue<Long> pq = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()){
                pq.offer(Long.parseLong(st.nextToken()));
            }

            sum = 0;
            while(pq.size() > 1){
                long a = pq.poll();
                long b = pq.poll();
                pq.offer(a+b);
                sum += a+b;
            }
            bw.write(sum+"\n");
        }
        bw.flush();
    }
}
