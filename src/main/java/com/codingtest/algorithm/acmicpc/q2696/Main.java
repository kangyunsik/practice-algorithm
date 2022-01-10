package com.codingtest.algorithm.acmicpc.q2696;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test_case = Integer.parseInt(br.readLine());
        for (int TEST_CASE = 0; TEST_CASE < test_case; TEST_CASE++) {
            int n = Integer.parseInt(br.readLine());
            int[] values = new int[n];
            StringTokenizer st;
            for (int i = 0; i < (n%10 == 0 ? n/10 : n/10+1); i++) {
                int[] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                System.arraycopy(input, 0, values, i * 10, input.length);
            }
            PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> minQ = new PriorityQueue<>();

            // always maxQ < minQ
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if(i%2==0){
                    if(!minQ.isEmpty() && minQ.peek() < values[i]){
                        maxQ.offer(minQ.poll());
                        minQ.offer(values[i]);
                    }else{
                        maxQ.offer(values[i]);
                    }
                    ans.add(maxQ.peek());
                }else{
                    if(!maxQ.isEmpty() && maxQ.peek() > values[i]){
                        minQ.offer(maxQ.poll());
                        maxQ.offer(values[i]);
                    }else{
                        minQ.offer(values[i]);
                    }
                }
            }
            bw.write(String.valueOf(ans.size()));
            for (int i = 0; i < ans.size(); i++) {
                if(i % 10 == 0){
                    bw.write("\n");
                }
                bw.write(ans.get(i)+" ");
            }
            if(ans.size() % 10 != 0){
                bw.write("\n");
            }
            bw.flush();

        }
    }
}
