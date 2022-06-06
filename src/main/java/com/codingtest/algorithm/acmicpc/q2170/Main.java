package com.codingtest.algorithm.acmicpc.q2170;

import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int begin, end;

        public Node(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            return begin - o.begin;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(nodes);
        int cur, prev, score = 0;
        cur = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            prev = Math.max(cur, nodes[i].begin);
            cur = Math.max(cur, nodes[i].end);
            score += cur - prev;
        }
        System.out.println(score);
    }
}