package com.codingtest.algorithm.acmicpc.q14428;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static Node root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder ans = new StringBuilder();

        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        root = new Node(0, n - 1);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            root.set(i, Integer.parseInt(st.nextToken()));
        }
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            if (st.nextToken().equals("1")) {
                root.set(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
            } else {
                int[] temp = root.findIndex(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
                ans.append(temp[0] + 1).append("\n");
            }
        }
        bw.write(ans.toString());
        bw.flush();
    }

    static class Node {
        int s, e, m, index, value;
        Node left, right;

        public Node(int s, int e) {
            this.s = s;
            this.e = e;
            this.m = (s + e) / 2;
            this.value = Integer.MAX_VALUE;
            this.index = -1;
        }

        public void set(int idx, int v) {
            boolean need = (index == idx);
            if ((left == null && right == null) || value > v || (value == v && index > idx)) {
                index = idx;
                value = v;
            }

            if (idx == s && idx == e) return;
            if (left == null) left = new Node(0, m);
            if (right == null) right = new Node(m + 1, e);

            if (idx <= m) left.set(idx, v);
            else right.set(idx, v);
            if (need) {
                int[] temp1 = left.findIndex(left.s, left.e);
                int[] temp2 = right.findIndex(right.s, right.e);
                int[] target;
                if (temp1[1] == temp2[1]) {
                    target = temp1[0] < temp2[0] ? temp1 : temp2;
                } else {
                    target = temp1[1] < temp2[1] ? temp1 : temp2;
                }
                index = target[0];
                value = target[1];
            }
        }

        public int[] findIndex(int begin, int end) {
            if (begin == s && end == e) {
                return new int[]{index, value};
            }
            if (end <= m) {
                return left.findIndex(begin, end);
            } else if (m < begin) {
                return right.findIndex(begin, end);
            } else {
                int[] temp1 = left.findIndex(begin, m);
                int[] temp2 = right.findIndex(m + 1, end);
                if (temp1[1] == temp2[1]) {
                    return temp1[0] < temp2[0] ? temp1 : temp2;
                } else {
                    return temp1[1] < temp2[1] ? temp1 : temp2;
                }
            }
        }
    }
}
