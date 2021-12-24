package com.codingtest.algorithm.acmicpc.q9205;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 999999999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());
        int x,y;
        for (int test = 0; test < test_case; test++) {
            int n = Integer.parseInt(br.readLine());
            Node[] nodes = new Node[n + 2];
            int[][] dist = new int[n+2][n+2];
            for (int i = 0; i < n + 2; i++) {
                Arrays.fill(dist[i],INF);
            }

            for (int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine()," ");
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                nodes[i] = new Node(x,y);
                for (int j = 0; j < i; j++) {
                    int temp = getDist(nodes[i], nodes[j]);
                    if(temp <= 1000){
                        dist[i][j] = temp;
                        dist[j][i] = temp;
                    }
                }
            }

            for (int mid = 0; mid < n + 2; mid++) {
                for (int i = 0; i < n + 2; i++) {
                    for (int j = 0; j < n + 2; j++) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][mid] + dist[mid][j]);
                    }
                }
            }

            if(dist[0][n+1] != INF)
                bw.write("happy\n");
            else
                bw.write("sad"+"\n");
            bw.flush();
        }
    }

    private static int getDist(Node a, Node b){
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }
}

class Node{
    int x,y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}