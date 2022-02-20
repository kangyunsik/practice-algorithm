package com.codingtest.algorithm.acmicpc.q15787;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] trains = new int[n];

        int order, trainNum, location;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            order = Integer.parseInt(st.nextToken());
            trainNum = Integer.parseInt(st.nextToken()) - 1;
            switch (order) {
                case 1:
                    location = Integer.parseInt(st.nextToken()) - 1;
                    trains[trainNum] |= (1 << location);
                    break;
                case 2:
                    location = Integer.parseInt(st.nextToken()) - 1;
                    trains[trainNum] -= (trains[trainNum] & (1 << location));
                    break;
                case 3:
                    trains[trainNum] <<= 1;
                    trains[trainNum] %= (1 << 20);
                    break;
                case 4:
                    trains[trainNum] >>= 1;
                    break;
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int train : trains) {
            set.add(train);
        }
        bw.write(String.valueOf(set.size()));
        bw.flush();
    }
}
