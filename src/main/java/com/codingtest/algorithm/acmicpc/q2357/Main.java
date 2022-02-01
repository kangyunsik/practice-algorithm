package com.codingtest.algorithm.acmicpc.q2357;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static Node root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        root = new Node(1, n);
        for (int i = 0; i < n; i++) {
            root.push(i + 1, Integer.parseInt(br.readLine()));
        }
        int[] ans;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            ans = root.find(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            bw.write(ans[0] + " " + ans[1] + "\n");
        }
        bw.flush();
    }

    static class Node {
        int s, e, m, max, min;
        Node left, right;

        public Node(int s, int e) {
            this.s = s;
            this.e = e;
            this.m = (s + e) / 2;
            this.max = Integer.MIN_VALUE;
            this.min = Integer.MAX_VALUE;
        }

        public void push(int index, int value) {
            min = Math.min(min, value);
            max = Math.max(max, value);

            if (index == s && index == e) return;
            if (index <= m) {
                if (left == null) left = new Node(s, m);
                left.push(index, value);
            } else {
                if (right == null) right = new Node(m + 1, e);
                right.push(index, value);
            }
        }

        public int[] find(int begin, int end) {
            if (begin == s && end == e) return new int[]{min, max};
            if(begin > m){
                return right.find(begin, end);
            }else if(end <= m){
                return left.find(begin, end);
            }else{
                int[] temp1 = left.find(begin, m);
                int[] temp2 = right.find(m + 1, end);
                return new int[]{Math.min(temp1[0], temp2[0]), Math.max(temp1[1], temp2[1])};
            }
        }
    }
}
