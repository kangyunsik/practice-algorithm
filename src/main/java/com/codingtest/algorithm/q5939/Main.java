package com.codingtest.algorithm.q5939;

import java.io.*;

public class Main {
    Node root;
    BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Main main = new Main();
        String input;
        while((input = br.readLine()) != null){
            main.set(Integer.parseInt(input));
        }
        main.run();
        main.bw.flush();
    }

    public Main() {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    void set(int n){
        root = add(root,n);
    }

    Node add(Node current, int value){
        if(current == null)
            return new Node(value);

        if(current.value < value){
            current.right = add(current.right,value);
        }else{
            current.left = add(current.left,value);
        }

        return current;
    }

    void run() throws IOException {
        recursive(root);
    }

    void recursive(Node current) throws IOException {
        if(current!= null) {
            recursive(current.left);
            recursive(current.right);
            bw.write(current.value+"\n");
        }
    }

    class Node{
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }
}
