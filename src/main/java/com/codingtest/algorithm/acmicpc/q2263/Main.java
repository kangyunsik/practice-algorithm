package com.codingtest.algorithm.acmicpc.q2263;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] inOrderLocation, postOrder;
    static boolean[] visit;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        inOrderLocation = new int[n + 1];
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            inOrderLocation[Integer.parseInt(st.nextToken())] = i;
        }
        postOrder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        findRecursive(0, n, 0, n);
        bw.flush();
    }

    static void findRecursive(int s, int e, int ps, int pe) throws IOException {
        if (s > e - 1 || ps > pe - 1) return;

        int root = postOrder[pe - 1];
        int index = inOrderLocation[root];
        bw.write(root + " ");
        int l = index - s;
        findRecursive(s, index, ps, ps + l);
        findRecursive(index + 1, e, ps + l, pe - 1);

    }
}