package com.codingtest.algorithm.acmicpc.q1202;

import java.io.*;
import java.util.*;

public class Main {
    int n, k;
    PriorityQueue<Jewel> jewels;
    TreeMap<Integer,Integer> map;
    long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Main main = new Main(n, k);
        for (int i = 0; i < n; i++) {
            main.setJewel(br.readLine());
        }
        for (int i = 0; i < k; i++) {
            main.setBag(br.readLine());
        }
        main.run();

        bw.write(main.getAnswer()+"\n");
        bw.flush();
    }

    public Main(int n, int k) {
        this.n = n;
        this.k = k;
        jewels = new PriorityQueue<>(Collections.reverseOrder());
        map = new TreeMap<>();
        answer = 0;
    }

    void setJewel(String input) {
        StringTokenizer st = new StringTokenizer(input, " ");
        int size = Integer.parseInt(st.nextToken());
        int value = Integer.parseInt(st.nextToken());
        jewels.add(new Jewel(size, value));
    }

    void setBag(String input) {
        int size = Integer.parseInt(input);
        map.merge(size, 1, Integer::sum);
    }

    void run() {
        while (!jewels.isEmpty()) {
            Jewel poll = jewels.poll();
            Integer best = map.ceilingKey(poll.size);
            if (best != null) {
                if(map.get(best) == 1){
                    map.remove(best);
                }else{
                    map.put(best,map.get(best)-1);
                }
                answer += poll.value;
            }
        }
    }

    long getAnswer() {
        return this.answer;
    }

    class Jewel implements Comparable<Jewel> {
        int size;
        int value;

        @Override
        public int compareTo(Jewel other) {
            return this.value == other.value ? other.size - this.size : this.value - other.value;
        }

        public Jewel(int size, int value) {
            this.size = size;
            this.value = value;
        }
    }
}
