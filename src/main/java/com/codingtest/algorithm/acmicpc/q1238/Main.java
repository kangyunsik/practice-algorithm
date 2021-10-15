package com.codingtest.algorithm.acmicpc.q1238;

import java.io.*;
import java.util.*;

public class Main {
    int n,m,x;
    int answer;
    Map<Integer,Integer>[] edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        Main main = new Main(n,m,x);
        for (int i = 0; i < m; i++) {
            main.set(br.readLine());
        }
        main.run();
        bw.write(main.getAnswer()+"\n");
        bw.flush();
    }

    public Main(int n, int m, int x) {
        this.n = n;
        this.m = m;
        this.x = x;
        edges = new HashMap[n+1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new HashMap<>();
        }
    }

    void set(String input){
        StringTokenizer st = new StringTokenizer(input," ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int value = Integer.parseInt(st.nextToken());
        edges[a].put(b,value);
    }

    void run(){
        int max_dist = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int dist1 = getDistFromTo(i,x);
            int dist2 = getDistFromTo(x,i);
            max_dist = Math.max(dist1 + dist2,max_dist);
        }
        this.answer = max_dist;
    }

    int getDistFromTo(int start,int end){
        int[] dist = new int[n+1];
        Map<Integer, Integer> edge = edges[start];

        Arrays.fill(dist,Integer.MAX_VALUE);
        for (Integer key : edge.keySet()) {
            dist[key] = edge.get(key);
        }
        dist[start] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        queue.add(new Node(start,0));
        while(!queue.isEmpty()){
            Node mid = queue.poll();
            int mDest = mid.dest;
            int mCost = mid.cost;
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

        return dist[end];
    }

    int getAnswer(){
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
