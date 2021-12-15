package com.codingtest.algorithm.acmicpc.q1208;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static Map<Integer, Integer> firstMap = new HashMap<>();
    static int[] inputs;
    static int n, s;
    static long answer = 0L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        inputs = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dfsFirst(0, 0);
        dfsSecond(1,0);

        if(s == 0) answer--;
        bw.write(answer + "");
        bw.flush();

    }

    static void dfsFirst(int index, int sum){
        if(index >= n){
            firstMap.put(sum,firstMap.getOrDefault(sum,0)+1);
            return;
        }
        dfsFirst(index+2,sum + inputs[index]);
        dfsFirst(index+2,sum);
    }

    static void dfsSecond(int index, int sum){
        if(index >= n){
            answer += firstMap.getOrDefault((s - sum), 0);
            return;
        }
        dfsSecond(index+2,sum + inputs[index]);
        dfsSecond(index+2,sum);
    }
}
