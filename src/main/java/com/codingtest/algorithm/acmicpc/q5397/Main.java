package com.codingtest.algorithm.acmicpc.q5397;

import java.io.*;

public class Main {
    static Node root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            bw.write(getAnswer(br.readLine())+"\n");
            bw.flush();
        }
    }

    private static String getAnswer(String query){
        root = new Node();
        Node cur = root;
        char[] temp = query.toCharArray();
        for (char c : temp) {
            if(c == '<'){
                if(cur.prev != null){
                    cur = cur.prev;
                }
            }else if(c == '>'){
                if(cur.next != null){
                    cur = cur.next;
                }
            }else if(c == '-'){
                if(cur.prev != null){
                    cur.prev.next = cur.next;
                    if(cur.next != null){
                        cur.next.prev = cur.prev;
                    }
                    cur = cur.prev;
                }
            }else{
                Node t =  new Node();
                t.value = c;
                t.next = cur.next;
                t.prev = cur;
                if(cur.next != null)
                    cur.next.prev = t;
                cur.next = t;
                cur = cur.next;
            }
        }
        StringBuilder sb = new StringBuilder();
        root = root.next;
        while(root != null){
            sb.append(root.value);
            root = root.next;
        }
        return sb.toString();
    }

    static class Node{
        char value;
        Node next;
        Node prev;
    }
}
