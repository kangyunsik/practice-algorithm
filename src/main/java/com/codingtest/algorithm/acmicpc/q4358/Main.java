package com.codingtest.algorithm.acmicpc.q4358;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        Map<String, Integer> map = new HashMap<>();
        int cnt = 0;
        while((input = br.readLine()) != null){
            cnt++;
            map.put(input, map.getOrDefault(input, 0) + 1);
        }
        List<Index> list = new ArrayList<>();
        for (String string : map.keySet()) {
            list.add(new Index(string, map.get(string)));
        }
        list.sort(Comparator.comparing(o -> o.string));
        for (Index index : list) {
            bw.write(index.string+" ");
            double count = (double)index.count*100/cnt;
            bw.write(String.format("%.4f",count)+"\n");
        }
        bw.flush();
    }
}

class Index{
    String string;
    int count;

    public Index(String string, int count) {
        this.string = string;
        this.count = count;
    }
}
