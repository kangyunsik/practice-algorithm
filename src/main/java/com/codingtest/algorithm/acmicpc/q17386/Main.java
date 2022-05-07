package com.codingtest.algorithm.acmicpc.q17386;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static class Point {

        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Point[] points = new Point[4];
        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i * 2] = new Point(Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()));
            points[i * 2 + 1] = new Point(Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()));
        }

        System.out.println(checkDup(points) ? "1" : "0");
    }

    private static boolean checkDup(Point[] points) {
        return ccw(points[0], points[1], points[2]) *
            ccw(points[0], points[1], points[3]) < 0 &&
            ccw(points[2], points[3], points[0]) *
                ccw(points[2], points[3], points[1]) < 0;
    }

    private static int ccw(Point p1, Point p2, Point p3) {
        long t1 = (p2.x - p1.x) * (p3.y - p1.y);
        long t2 = (p3.x - p1.x) * (p2.y - p1.y);
        if (t1 - t2 < 0) {
            return -1;
        } else {
            return 1;
        }
    }

}