package com.codingtest.algorithm.acmicpc.q15663;

import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> nums;
    static int n, m;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        nums = new ArrayList<>();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Set<Integer> prev = new HashSet<>();
        st = new StringTokenizer(br.readLine(), " ");
        int[] count = new int[10001];
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            count[temp]++;
            nums.add(temp);
        }
        Collections.sort(nums);

        dfs(count, new Stack<>());
        bw.flush();

    }

    private static void dfs(int[] check, Stack<Integer> stack) throws IOException {
        if (stack.size() == m) {
            print(stack);
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            if(i > 0 && nums.get(i).equals(nums.get(i - 1))) continue;

            if (check[nums.get(i)] > 0) {
                check[nums.get(i)]--;
                stack.push(i);
                dfs(check, stack);
                stack.pop();
                check[nums.get(i)]++;
            }
        }

    }

    private static void print(Stack<Integer> list) throws IOException {
        for (Integer index : list) {
            bw.write(nums.get(index) + " ");
        }
        bw.write("\n");
    }
}
