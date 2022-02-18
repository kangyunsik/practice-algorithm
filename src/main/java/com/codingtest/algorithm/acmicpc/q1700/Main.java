package com.codingtest.algorithm.acmicpc.q1700;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> locationMapper = new HashMap<>();
        Map<Integer, TreeSet<Integer>> indexMapper = new HashMap<>();
        int[] input = new int[k];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < k; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            indexMapper.computeIfAbsent(input[i], k1 -> new TreeSet<>());
            indexMapper.get(input[i]).add(i);
        }

        if (n >= k) {
            bw.write("0");
            bw.flush();
            return;
        }

        int idx = 0, cur = 0;
        while (cur < k && idx < n) {
            if (!locationMapper.containsKey(input[cur])) {
                locationMapper.put(input[cur], idx);
                idx++;
            }
            cur++;
        }

        int cnt = 0;
        for (int i = idx; i < k; i++) {
            if (!locationMapper.containsKey(input[i])) {
                int lastIndex = 0;
                int lastValue = 0;
                for (Integer current : locationMapper.keySet()) {
                    if (indexMapper.get(current).ceiling(i) == null) {
                        lastValue = current;
                        break;
                    } else {
                        int temp = indexMapper.get(current).ceiling(i);
                        if (temp > lastIndex) {
                            lastIndex = temp;
                            lastValue = current;
                        }
                    }
                }
                locationMapper.put(input[i], locationMapper.get(lastValue));
                locationMapper.remove(lastValue);
                cnt++;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}
