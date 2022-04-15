package com.codingtest.algorithm.acmicpc.q14395;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        long value;
        List<Character> oper;

        public Node(long value, List<Character> oper) {
            this.value = value;
            this.oper = oper;
        }

        public Node operate(boolean isPlus) {
            List<Character> temp = new ArrayList<>(oper);
            Node node = new Node(value, temp);
            if(isPlus){
                node.value = this.value + this.value;
                temp.add('+');
            }else{
                node.value = this.value * this.value;
                temp.add('*');
            }
            return node;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long s = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if (s == k) {
            System.out.println("0");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(s, new ArrayList<>());
        queue.offer(node.operate(false));
        queue.offer(node.operate(true));
        queue.offer(new Node(0, Arrays.asList('-')));
        if (s != 0)
            queue.offer(new Node(1, Arrays.asList('/')));
        Set<Long> already = new HashSet<>();
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            long val = poll.value;
            if (val > k || !already.add(val)) continue;
            if (val == k) {
                for (char c : poll.oper) {
                    System.out.print(c);
                }
                return;
            }
            queue.offer(poll.operate(false));
            queue.offer(poll.operate(true));
        }
        System.out.println("-1");
    }
}
