package com.codingtest.algorithm.acmicpc.q17387;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Line implements Comparable<Line>{
        Point a, b;

        public Line(Point a, Point b) {
            if(a.compareTo(b) <= 0){
                this.a = a;
                this.b = b;
            }else{
                this.b = a;
                this.a = b;
            }
        }

        @Override
        public int compareTo(Line o) {
            return a.compareTo(o.a);
        }
    }

    static class Point implements Comparable<Point>{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if(x == o.x) return y - o.y;
            return x - o.x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Line[] lines = new Line[2];
        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Point p1 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Point p2 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            lines[i] = new Line(p1 , p2);
        }
        Arrays.sort(lines);

        if (isDupLine(lines[0], lines[1])) {
            System.out.println("1");
        }else{
            System.out.println("0");
        }
    }

    private static boolean isDupLine(Line l1, Line l2) {
        int a1 = ccw(l1, l2.a) * ccw(l1, l2.b);
        int a2 = ccw(l2, l1.a) * ccw(l2, l1.b);
        if(a1 == 0 && a2 == 0){
            return l1.b.compareTo(l2.a) >= 0;
        }else{
            return a1 <= 0 && a2 <= 0;
        }
    }

    private static int ccw(Line l, Point p) {
        long t1 = (long)(l.b.x - l.a.x) * (p.y - l.a.y);
        long t2 = (long)(l.b.y - l.a.y) * (p.x - l.a.x);
        if(t1 - t2 < 0) return -1;
        else if(t1 == t2) return 0;
        else return 1;
    }
}