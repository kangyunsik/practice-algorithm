package com.codingtest.algorithm.acmicpc.q17406;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static int n, m, k, ans = Integer.MAX_VALUE;
    static int[][] map;
    static int[][] origin;
    static String[] commands;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        origin = new int[n][];
        map = new int[n][m];
        commands = new String[k];
        for (int i = 0; i < n; i++) {
            origin[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 0; i < k; i++) {
            commands[i] = br.readLine();
        }
        findCases(new Stack<>());

        bw.write(ans + "\n");
        bw.flush();
    }

    private static void initMap(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = origin[i][j];
            }
        }
    }

    private static void findCases(Stack<Integer> stack) {
        if (stack.size() == k) {
            initMap();
            for (Integer index : stack) {
                command(Stream.of(commands[index].split(" ")).mapToInt(Integer::parseInt).toArray());
            }
            for (int i = 0; i < n; i++) {
                ans = Math.min(ans, Arrays.stream(map[i]).sum());
            }
            return;
        }

        for (int i = 0; i < k; i++) {
            if (!stack.contains(i)) {
                stack.push(i);
                findCases(stack);
                stack.pop();
            }
        }
    }

    private static void command(int[] com) {
        int z = com[2];
        while (z > 0) {
            int x = com[0] - 1;
            int y = com[1] - 1;
            int lt, rt, rb;
            lt = map[x - z][y - z];
            rt = map[x - z][y + z];
            rb = map[x + z][y + z];
            for (int j = 0; j < z * 2; j++) {
                map[x - z + j][y - z] = map[x - z + j + 1][y - z];
            }
            for (int j = 0; j < z * 2; j++) {
                map[x - z][y + z - j] = map[x - z][y + z - 1 - j];
            }
            for (int j = 0; j < z * 2; j++) {
                map[x + z - j][y + z] = map[x + z - 1 - j][y + z];
            }
            for (int j = 0; j < z * 2; j++) {
                map[x + z][y - z + j] = map[x + z][y - z + j + 1];
            }
            map[x - z][y - z + 1] = lt;
            map[x - z + 1][y + z] = rt;
            map[x + z][y + z - 1] = rb;

            z--;
        }

    }
}
