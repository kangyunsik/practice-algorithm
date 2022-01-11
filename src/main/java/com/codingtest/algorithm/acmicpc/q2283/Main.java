package com.codingtest.algorithm.acmicpc.q2283;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] lines = new int[n][2];
        int max = 1000000;
        PriorityQueue<Integer> headQ = new PriorityQueue<>();
        PriorityQueue<Integer> tailQ = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
            if (lines[i][0] == 0) {
                headQ.offer(lines[i][1]);
                tailQ.offer(lines[i][1]);
            }
        }
        Arrays.sort(lines, Comparator.comparingInt(i -> i[0]));

        int headIndex = headQ.size(), tailIndex = tailQ.size();
        int sum = 0, start = 0, end = 0;
        while (end <= max) {
            if (sum > k) {
                start++;
                while (!headQ.isEmpty() && headQ.peek() < start) {
                    headQ.poll();
                }
                sum -= headQ.size();

                while (headIndex < n && lines[headIndex][0] <= start) {
                    headQ.offer(lines[headIndex][1]);
                    headIndex++;
                }
            } else if (sum < k) {
                end++;
                while (!tailQ.isEmpty() && tailQ.peek() < end) {
                    tailQ.poll();
                }
                sum += tailQ.size();

                while (tailIndex < n && lines[tailIndex][0] <= end) {
                    tailQ.offer(lines[tailIndex][1]);
                    tailIndex++;
                }

            }

            if (sum == k) {
                bw.write(start + " " + end + "\n");
                bw.flush();
                return;
            }
        }

        bw.write("0 0\n");
        bw.flush();
    }
}
