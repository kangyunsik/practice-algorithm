package com.codingtest.algorithm.acmicpc.q14572;

import java.io.*;
import java.util.*;

public class Main {

    static int lGet, rGet;

    static class SegmentTree {

        int begin, end, mid, all, dup;
        SegmentTree left, right;

        public SegmentTree(int begin, int end) {
            this.begin = begin;
            this.end = end;
            this.mid = (begin + end) / 2;
            this.dup = (1 << 31) - 1;
            if (begin == end) {
                return;
            }
            left = new SegmentTree(begin, mid);
            right = new SegmentTree(mid + 1, end);
        }

        public void push(int idx, int bit) {
            this.all |= bit;
            this.dup &= bit;
            if (begin == end) {
                return;
            }
            if (idx <= mid) {
                left.push(idx, bit);
            } else {
                right.push(idx, bit);
            }
        }

        public void get(int l, int r) {
            if (r < begin || end < l) {
                return;
            } else if (l <= begin && end <= r) {
                lGet |= all;
                rGet &= dup;
                return;
            }
            left.get(l, r);
            right.get(l, r);
        }
    }

    static class Student implements Comparable<Student> {

        int value, bit;

        public Student(int value, int bit) {
            this.value = value;
            this.bit = bit;
        }

        @Override
        public int compareTo(Student o) {
            return value - o.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        SegmentTree root = new SegmentTree(0, n - 1);
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int bit = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0, v; j < a; j++) {
                v = Integer.parseInt(st.nextToken());
                bit |= 1 << (v - 1);
            }
            students[i] = new Student(b, bit);
        }
        Arrays.sort(students);
        for (int i = 0; i < students.length; i++) {
            root.push(i, students[i].bit);
        }

        int left = 0, right = 0, ans = 0;
        while (right < n) {
            int diff = students[right].value - students[left].value;
            if (diff <= d) {
                lGet = 0;
                rGet = (1 << 31) - 1;
                root.get(left, right);
                ans = Math.max(ans,
                    (Integer.bitCount(lGet) - Integer.bitCount(rGet)) * (right - left + 1));
                right++;
            } else {
                left++;
            }
        }
        System.out.println(ans);
    }
}