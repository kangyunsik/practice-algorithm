package com.codingtest.algorithm.acmicpc.q7662;

import java.io.*;
import java.util.*;

public class Main {
    StringTokenizer st;
    PriorityQueue<Long> minHeap;
    PriorityQueue<Long> maxHeap;
    Map<Long, Integer> map;
    int cnt;

    public void init() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        map = new HashMap<>();
        cnt = 0;
    }

    public void run(String s) {
        st = new StringTokenizer(s, " ");
        long value;

        char order = st.nextToken().charAt(0);
        value = Long.parseLong(st.nextToken());

        switch (order) {
            case 'I':
                cnt++;
                minHeap.offer(value);
                maxHeap.offer(value);
                map.merge(value, 1, Integer::sum);

                break;
            case 'D':
                long k;
                if(cnt == 0)
                    break;

                if (value == 1L && !maxHeap.isEmpty()) {
                    do {
                        k = maxHeap.poll();
                    } while ( map.get(k) == 0);
                    map.put(k, map.get(k) - 1);
                } else if (value == -1L && !minHeap.isEmpty()) {
                    do {
                        k = minHeap.poll();
                    } while (map.get(k) == 0);
                    map.put(k, map.get(k) - 1);
                }
                cnt--;
                break;
        }
    }

    public String getAnswer() {

        long min, max;
        do {
            if (!maxHeap.isEmpty()) {
                max = maxHeap.poll();
            } else
                return "EMPTY";
        } while (map.get(max) == 0);

        do {
            if (!minHeap.isEmpty()) {
                min = minHeap.poll();
            } else
                return "EMPTY";
        } while (map.get(min) == 0);

        return max + " " + min;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Main main;
        int t = Integer.parseInt(br.readLine());
        int n;

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            main = new Main();
            main.init();
            for (int j = 0; j < n; j++) {
                main.run(br.readLine());
            }
            bw.write(main.getAnswer() + "\n");
            bw.flush();
        }
    }
}
