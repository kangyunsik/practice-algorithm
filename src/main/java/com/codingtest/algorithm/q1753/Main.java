package com.codingtest.algorithm.q1753;

import java.io.*;
import java.util.*;

public class Main {
    int n,m,start;
    Map<Integer,Integer>[] edges;
    String[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        Main main = new Main(n, m, start);
        for (int i = 0; i < m; i++) {
            main.set(br.readLine());
        }
        main.run();
        for (String s : main.answer) {
            bw.write(s+"\n");
        }
        bw.flush();

    }

    public Main(int n, int m,int start) {
        this.n = n;
        this.m = m;
        this.start = start;
        edges = new HashMap[n+1];
        for (int i = 0; i <= n; i++) {
            edges[i] = new HashMap<>();
        }
        answer = new String[n];
    }

    void set(String input){
        StringTokenizer st = new StringTokenizer(input," ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int value = Integer.parseInt(st.nextToken());
        edges[a].merge(b, value, Math::min);
    }

    void run(){
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Map<Integer, Integer> edge = edges[start];
        for (Integer dest : edge.keySet()) {
            dist[dest] = edge.get(dest);
        }
        dist[start] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        queue.add(new Node(start,0));
        while(!queue.isEmpty()){
            Node polled = queue.poll();
            int mDest = polled.dest;
            int mCost = polled.cost;

            if(dist[mDest] >= mCost){
                for (Integer tDest : edges[mDest].keySet()) {
                    int tCost = edges[mDest].get(tDest);
                    if(dist[tDest] >= mCost + tCost){
                        dist[tDest] = mCost + tCost;
                        queue.add(new Node(tDest,dist[tDest]));
                    }
                }
            }
        }

        for (int i = 1; i < dist.length; i++) {
            if(dist[i] != Integer.MAX_VALUE)
                answer[i-1] = dist[i]+"";
            else
                answer[i-1] = "INF";
        }
    }

    String[] getAnswer(){
        return this.answer;
    }

    class Node{
        int dest;
        int cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
}
