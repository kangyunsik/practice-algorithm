package com.codingtest.algorithm.q1167;

import java.io.*;
import java.util.*;

public class Main {
    Map<Integer, Integer>[] edges;
    int n;
    int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Main main = new Main(n);
        for (int i = 0; i < n; i++) {
            main.set(br.readLine());
        }
        main.run();
        bw.write(main.getAnswer()+"\n");
        bw.flush();
    }

    public Main(int n) {
        edges = new HashMap[n + 1];
        this.n = n;
        answer = 0;
    }

    void set(String input) {
        StringTokenizer st = new StringTokenizer(input, " ");
        int s = Integer.parseInt(st.nextToken());
        edges[s] = new HashMap<>();
        int t;
        while ((t = Integer.parseInt(st.nextToken())) != -1) {
            int value = Integer.parseInt(st.nextToken());
            edges[s].put(t, value);
        }
    }

    void run(){
        int index = getMaxDist(1,false);
        this.answer = getMaxDist(index,true);
    }

    int getMaxDist(int index, boolean isValue) {
        int[] dist = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[index] = 0;
        for (Integer key : edges[index].keySet()) {
            dist[key] = edges[index].get(key);
        }

        PriorityQueue<Index> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));
        queue.add(new Index(index,0));
        while(!queue.isEmpty()){
            Index polled = queue.poll();
            int value = polled.value;
            int dest = polled.dest;
            if(dist[dest] >= value){
                for (Integer tDest : edges[dest].keySet()) {
                    int tValue = edges[dest].get(tDest);
                    if(dist[tDest] >= value + tValue){
                        dist[tDest] = value + tValue;
                        queue.add(new Index(tDest,dist[tDest]));
                    }
                }
            }
        }

        int max_value = Integer.MIN_VALUE;
        int max_index = -1;
        for (int i = 1; i <= n; i++) {
            if(dist[i] > max_value){
                max_value = dist[i];
                max_index = i;
            }
        }

        return isValue ? max_value : max_index;
    }

    int getAnswer(){
        return this.answer;
    }

    class Index{
        int dest;
        int value;

        public Index(int dest, int value) {
            this.dest = dest;
            this.value = value;
        }
    }
}
