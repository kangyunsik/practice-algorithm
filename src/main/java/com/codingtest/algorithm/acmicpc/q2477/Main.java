package com.codingtest.algorithm.acmicpc.q2477;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int k = Integer.parseInt(br.readLine());
        List<int[]> queue = new LinkedList<>();
        int[] cnt = new int[5];
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            queue.add(new int[]{x, y});
            cnt[x]++;
        }

        if (cnt[2] == 2 && cnt[4] == 2) {
            reshape(queue, 1);
        } else if (cnt[1] == 2 && cnt[3] == 2) {
            reshape(queue, 2);
        } else if (cnt[1] == 2 && cnt[4] == 2) {
            reshape(queue, 3);
        } else {
            reshape(queue, 4);
        }
        int ans = k * (queue.get(0)[1] * queue.get(5)[1] - queue.get(2)[1] * queue.get(3)[1]);
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static void reshape(List<int[]> list, int target) {
        while (list.get(0)[0] != target) {
            list.add(list.remove(0));
        }
    }
}
