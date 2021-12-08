package com.codingtest.algorithm.acmicpc.q1707;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        HashSet<Integer>[] edges;
        boolean[] visit;
        boolean answer;
        int test_case = Integer.parseInt(br.readLine());
        int v,e,a,b;

        for (int t = 0; t < test_case; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            answer = true;
            edges = new HashSet[v];
            visit = new boolean[v];
            for (int i = 0; i < v; i++) {
                edges[i] = new HashSet<>();
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine()," ");
                a = Integer.parseInt(st.nextToken())-1;
                b = Integer.parseInt(st.nextToken())-1;
                edges[a].add(b);
                edges[b].add(a);
            }

            for (int i = 0; i < v; i++) {
                if(!visit[i] && !findOdd(edges, i, visit)){
                    answer = false;
                    break;
                }
            }

            bw.write(answer ? "YES\n" : "NO\n");
            bw.flush();
        }
    }

    static boolean findOdd(HashSet<Integer>[] edges, int start, boolean[] visit){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start, 1));
        int[] status = new int[visit.length];

        while(!queue.isEmpty()){
            Node poll = queue.poll();
            if(status[poll.number] * poll.status == -1)
                return false;
            status[poll.number] = poll.status;
            if(visit[poll.number]) continue;
            visit[poll.number] = true;
            for (Integer next : edges[poll.number]) {
                queue.offer(new Node(next,poll.status * -1));
            }
        }

        return true;
    }
}

class Node{
    int number;
    int status;

    public Node(int number,int status) {
        this.number = number;
        this.status = status;
    }
}