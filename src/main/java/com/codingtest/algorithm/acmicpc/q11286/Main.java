package com.codingtest.algorithm.acmicpc.q11286;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    public ArrayList<Integer> answer;
    PriorityQueue<Node> queue;
    public int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Main main = new Main();

        int n = Integer.parseInt(br.readLine());
        main.init(n);

        for (int i = 0; i < n; i++) {
            main.run(Integer.parseInt(br.readLine()));
        }
        for (Integer integer : main.getAnswer()) {
            bw.write(integer+"\n");
        }
        bw.flush();
    }

    public void init(int n) {
        this.n = n;
        answer = new ArrayList<>();
        queue = new PriorityQueue<>();
    }

    public void run(int input) {
        if (input == 0) {
            if(queue.isEmpty()){
                answer.add(0);
            }else{
                Node node = queue.poll();
                answer.add(node.value);
            }
        } else {
            queue.add(new Node(input));
        }
    }

    public ArrayList<Integer> getAnswer() {
        return this.answer;
    }

    class Node implements Comparable<Node> {
        int value;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            int t_abs = Math.abs(this.value);
            int o_abs = Math.abs(o.value);

            if (t_abs != o_abs) {
                return t_abs - o_abs;
            }else{
                if (t_abs > this.value) // 현재 값만 양수
                    return -1;
                else if (o_abs > o.value) // 타겟 값만 양수
                    return 1;
                else
                    return 0;
            }
        }
    }
}
