package com.codingtest.algorithm.acmicpc.q13549;

import java.io.*;
import java.util.*;

public class Main {
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n, answer = -1;
        boolean[] visit;
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if(n > k){
            System.out.println(n-k);
            return;
        }
        visit = new boolean[2*k];

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.depth));
        queue.offer(new Node(n,0));
        while(!queue.isEmpty()){
            Node poll = queue.poll();
            if(poll.loc == k){
                answer = poll.depth;
                break;
            }
            if(poll.loc < 0 || poll.loc >= 2*k || visit[poll.loc]) continue;
            visit[poll.loc] = true;

            if(poll.loc > 0) {
                int temp = poll.loc;
                while (temp < 2*k) {
                    queue.offer(new Node(temp, poll.depth));
                    temp *= 2;
                }
            }
            queue.offer(new Node(poll.loc + 1,poll.depth+1));
            queue.offer(new Node(poll.loc - 1,poll.depth+1));
        }

        System.out.println(answer);
    }
}

class Node{
    int loc;
    int depth;

    public Node(int loc, int depth) {
        this.loc = loc;
        this.depth = depth;
    }
}
