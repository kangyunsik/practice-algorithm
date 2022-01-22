package com.codingtest.algorithm.acmicpc.q9466;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int[] arr;
    static boolean[] already;
    static boolean[] second;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test_case = Integer.parseInt(br.readLine());
        for (int TEST_CASE = 0; TEST_CASE < test_case; TEST_CASE++) {
            int n = Integer.parseInt(br.readLine());
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i) - 1).toArray();
            already = new boolean[n];
            second = new boolean[n];
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (!already[i]) {
                    ans += find(i);
                }
            }
            bw.write(ans + "\n");
            bw.flush();
        }
    }

    private static int find(int cur) {
        int result = 0;
        Set<Integer> first = new HashSet<>();
        while (!already[cur]) {
            if(!first.add(cur)){
                if(second[cur]){
                    break;
                }else{
                    second[cur] = true;
                }
            }
            cur = arr[cur];
        }
        for (Integer f : first) {
            if (!second[f] && !already[f]) {
                result++;
            }
            already[f] = true;
        }

        return result;
    }
}
