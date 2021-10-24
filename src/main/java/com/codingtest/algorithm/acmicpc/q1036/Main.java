package com.codingtest.algorithm.acmicpc.q1036;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public String myAdd(String a, String b, boolean up) {
        if (a.length() == 0) {
            return up ? myAdd("1",b, false) : b;
        } else if (b.length() == 0) {
            return up ? myAdd("1",a, false) : a;
        } else {
            int va = getValue(a.charAt(a.length()-1));
            int vb = getValue(b.charAt(b.length()-1));
            int sum;

            sum = va+vb + (up ? 1 : 0);
            if(sum < 10){
                return myAdd(a.substring(0, a.length() - 1), b.substring(0, b.length() - 1), false) + (char) (sum + '0');
            }else if(sum < 36){
                return myAdd(a.substring(0, a.length() - 1), b.substring(0, b.length() - 1), false) + (char) (sum - 10 + 'A');
            }else if(sum < 46){
                return myAdd(a.substring(0, a.length() - 1), b.substring(0, b.length() - 1), true) + (char) (sum - 36 + '0');
            }else{
                return myAdd(a.substring(0, a.length() - 1), b.substring(0, b.length() - 1), true) + (char) (sum - 46 + 'A');
            }
        }
    }

    public String solution(int n, String[] strings, int k) {
        String answer = "";
        Map<Character, String> vMap = new HashMap<>();
        for (int i = 0; i < 36; i++) {
            if (i < 10)
                vMap.put((char) (i + '0'), "");
            else
                vMap.put((char) ('A' + i - 10), "");
        }

        for (int i = 0; i < n; i++) {
            String unit = strings[i];
            answer = myAdd(answer, unit, false);
            for (int j = 0; j < unit.length(); j++) {
                char c = unit.charAt(j);
                if (c != 'Z') {
                    StringBuilder append = new StringBuilder(getReverseValue(c) + "");
                    for (int l = 0; l < unit.length() - j - 1; l++) {
                        append.append("0");
                    }
                    vMap.put(c, myAdd(append.toString(), vMap.get(c) , false));
                }
            }
        }

        PriorityQueue<MyString> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (Character key : vMap.keySet()) {
            pq.offer(new MyString(vMap.get(key)));
        }
        for (int i = 0; i < k; i++) {
            MyString poll = pq.poll();
            String poll_s = poll.value;
            answer = myAdd(answer, poll_s, false);
        }

        return answer;
    }

    private class MyString implements Comparable<MyString>{
        public String value;

        public MyString(String value) {
            this.value = value;
        }

        @Override
        public int compareTo(MyString o) {
            return this.value.length() == o.value.length() ? compare(this.value, o.value): this.value.length() - o.value.length();
        }

        private int compare(String a,String b){
            for (int i = 0; i < a.length(); i++) {
                if(a.charAt(i) != b.charAt(i)){
                    return a.charAt(i) - b.charAt(i);
                }
            }
            return 0;
        }
    }

    public char getReverseValue(char c) {
        int v;
        if ('A' <= c && c <= 'Z')
            v = c - 'A' + 10;
        else
            v = c - '0';

        if(35 - v < 10){
            return (char) ((35 - v) + '0');
        }else{
            return (char) ((25 - v) + 'A');
        }
    }

    private int getValue(char c){
        if ('A' <= c && c <= 'Z')
            return (c - 'A' + 10);
        else
            return (c - '0');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = br.readLine();
        }
        int k = Integer.parseInt(br.readLine());

        Main main = new Main();
        bw.write(main.solution(n, strings, k));
        bw.flush();
    }
}
