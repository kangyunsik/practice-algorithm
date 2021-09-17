package com.codingtest.algorithm.q16953;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    int a, b;
    int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        Main main = new Main(a, b);
        main.run();

        bw.write(main.getAnswer()+"\n");
        bw.flush();
    }

    public Main(int a, int b) {
        this.a = a;
        this.b = b;
        answer = Integer.MAX_VALUE;
    }

    void run() {
        Queue<Index> queue = new LinkedList<>();
        queue.add(new Index(a, 0));
        while (!queue.isEmpty()) {
            Index index = queue.poll();
            if (index.value == b) {
                answer = Math.min(answer, index.count) + 1;
            }

            if ((long)index.value * 2 <= b) {
                queue.add(new Index(index.value * 2, index.count + 1));
            }
            if ((long)index.value * 10 + 1 <= b) {
                queue.add(new Index(index.value * 10 + 1, index.count + 1));
            }
        }
    }

    int getAnswer() {
        return this.answer == Integer.MAX_VALUE ? -1 : this.answer;
    }

    class Index {
        int value;
        int count;

        public Index(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }
}
