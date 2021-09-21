package com.codingtest.algorithm.q1202;

import java.io.*;
import java.util.*;

public class Main {
    int n, k;
    PriorityQueue<Jewel> jewels;
    BagTree bagTree;
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
        bagTree = new BagTree();
        answer = 0;
    }

    void setJewel(String input) {
        StringTokenizer st = new StringTokenizer(input, " ");
        int size = Integer.parseInt(st.nextToken());
        int value = Integer.parseInt(st.nextToken());
        jewels.add(new Jewel(size, value));
    }

    void setBag(String input) {
        bagTree.insertValue(Integer.parseInt(input));
    }

    void run() {
        while (!jewels.isEmpty()) {
            Jewel poll = jewels.poll();
            int best = bagTree.getBestFitValue(poll.size);
            if (best != 0) {
                bagTree.deleteByValue(best);
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

    class BagTree {
        Node root;

        int getBestFitValue(int target) {
            Node current = root;
            int temp = Integer.MAX_VALUE;

            while (current != null) {
                if (current.value == target) {
                    return current.value;
                } else if (current.value > target) {
                    temp = Math.min(temp, current.value);
                    current = current.left;
                } else {
                    current = current.right;
                }
            }

            return temp == Integer.MAX_VALUE ? 0 : temp;
        }

        void insertValue(int value) {
            root = insertRecursive(root, value);
        }

        void deleteByValue(int value) {
            root = deleteRecursive(root, value);
        }

        private Node insertRecursive(Node current, int value) {
            if (current == null)
                return new Node(value);

            if (value < current.value)
                current.left = insertRecursive(current.left, value);
            else {
                current.right = insertRecursive(current.right, value);
            }
            return current;
        }

        private Node deleteRecursive(Node current, int value) {
            if (current == null)
                return null;

            if (current.value == value) {
                if (current.left == null && current.right == null) {
                    return null;
                } else if (current.right == null) {
                    return current.left;
                } else if (current.left == null) {
                    return current.right;
                }

                int smallestValue = findSmallestValue(current.right);
                current.value = smallestValue;
                current.right = deleteRecursive(current.right, smallestValue);
                return current;

            } else if (current.value < value) {
                current.right = deleteRecursive(current.right, value);
            } else {
                current.left = deleteRecursive(current.left, value);
            }
            return current;
        }

        private int findSmallestValue(Node root) {
            return root.left == null ? root.value : findSmallestValue(root.left);
        }
    }

    class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }
}
