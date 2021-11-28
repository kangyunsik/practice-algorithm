package com.codingtest.algorithm.acmicpc.q12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n, k, sum = 0;
        List<Item> items = new ArrayList<>();
        Map<Integer, Integer> bag = new HashMap<>();
        Map<Integer, Integer> rem = new HashMap<>();
        st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            items.add(new Item(w,value));
        }

        bag.put(0,0);
        for (Item item : items) {
            rem.clear();
            for (Integer bag_weight : bag.keySet()) {
                int sum_weight = item.weight + bag_weight;
                int value = item.value + bag.get(bag_weight);
                rem.put(sum_weight, Integer.max(bag.getOrDefault(sum_weight, 0), value));
            }

            for (Integer r : rem.keySet()) {
                Integer value = rem.get(r);
                if(bag.getOrDefault(r, 0) < value && r <= k){
                    bag.put(r, value);
                    sum = Integer.max(sum, value);
                }
            }
        }

        System.out.println(sum);
    }
}

class Item{
    int weight;
    int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}