package com.codingtest.algorithm.acmicpc.q2568;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<Index> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            list.add(new Index(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        list.sort(Comparator.comparingInt(o -> o.s));
        for (int i = 0; i < n; i++) {
            int pos = Collections.binarySearch(temp, list.get(i).e);
            pos = -pos - 1;
            if (pos == temp.size()) {
                temp.add(list.get(i).e);
            } else {
                temp.set(pos, list.get(i).e);
            }
            list.get(i).index = pos;
        }

        int ans, t;
        t = ans = temp.size();
        t--;
        for (int i = n - 1; i >= 0 && t >= 0; i--) {
            if (list.get(i).index == t) {
                list.get(i).check = false;
                t--;
            }
        }

        bw.write((n - ans) + "\n");
        for (Index index : list) {
            if (index.check) {
                bw.write(index.s + "\n");
            }
        }
        bw.flush();
    }
}

class Index {
    int s;
    int e;
    int index;
    boolean check;

    public Index(int s, int e) {
        this.s = s;
        this.e = e;
        this.check = true;
        this.index = 0;
    }
}
