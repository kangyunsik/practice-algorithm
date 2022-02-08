package com.codingtest.algorithm.acmicpc.q1327;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] sorted = Arrays.copyOf(input, input.length);
        Arrays.sort(sorted);
        Set<String> already = new HashSet<>();
        Queue<Index> queue = new LinkedList<>();
        queue.offer(new Index(input, n * n));
        int ans = -1;
        while (!queue.isEmpty()) {
            Index poll = queue.poll();
            if (poll.remain == 0) continue;
            if (Arrays.equals(poll.arr, sorted)) {
                ans = n * n - poll.remain;
                break;
            }
            for (int i = 0; i + k - 1 < n; i++) {
                int[] rev = reverse(poll.arr, i, i + k - 1);
                if(already.add(Arrays.toString(rev)))
                    queue.offer(new Index(rev, poll.remain - 1));
            }
        }
        bw.write(ans + "\n");
        bw.flush();
    }

    private static int[] reverse(int[] origin, int i, int j) {
        int[] trr = Arrays.copyOf(origin, origin.length);
        for (int k = 0; k <= (j - i) / 2; k++) {
            int temp = trr[i + k];
            trr[i + k] = trr[j - k];
            trr[j - k] = temp;
        }
        return trr;
    }

    static class Index {
        int[] arr;
        int remain;

        public Index(int[] arr, int remain) {
            this.arr = arr;
            this.remain = remain;
        }
    }
}
