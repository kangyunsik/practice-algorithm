package com.codingtest.algorithm.acmicpc.q1967;

import java.io.*;
import java.util.*;

public class Main {
    int n, answer;
    Map<Integer, Integer>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Main main = new Main(n);
        String input;
        while((input = br.readLine()) != null)
            main.set(input);
        main.run();

        bw.write(main.getAnswer()+"\n");
        bw.flush();
    }

    public Main(int n) {
        this.n = n;
        this.answer = 0;
        edges = new HashMap[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new HashMap<>();
        }
    }

    void set(String input) {
        StringTokenizer st = new StringTokenizer(input, " ");
        int v = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int value = Integer.parseInt(st.nextToken());
        edges[v].put(u, value);
        edges[u].put(v, value);
    }

    void run() {
        int[] dist1 = getDist(1);
        int max = Integer.MIN_VALUE;
        int max_index = 0;
        for (int i = 1; i <= n; i++) {
            if (max <= dist1[i]) {
                max = dist1[i];
                max_index = i;
            }
        }

        int[] dist2 = getDist(max_index);
        max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dist2[i]);
        }

        this.answer = max;
    }

    int[] getDist(int start) {
        int[] dest = new int[n + 1];

        PriorityQueue<Index> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        queue.add(new Index(start, 0));

        Arrays.fill(dest, Integer.MAX_VALUE);
        dest[start] = 0;
        for (Integer mDest : edges[start].keySet()) {
            dest[mDest] = edges[start].get(mDest);
        }

        while (!queue.isEmpty()) {
            Index poll = queue.poll();
            int mDest = poll.dest;
            int mCost = poll.cost;

            if(dest[mDest] >= mCost){
                for (Integer tDest : edges[mDest].keySet()) {
                    int tCost = edges[mDest].get(tDest);
                    if(dest[tDest] >= mCost + tCost){
                        dest[tDest] = mCost + tCost;
                        queue.add(new Index(tDest,dest[tDest]));
                    }
                }
            }
        }

        return dest;
    }

    int getAnswer() {
        return this.answer;
    }

    class Index {
        int dest;
        int cost;

        public Index(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
}
