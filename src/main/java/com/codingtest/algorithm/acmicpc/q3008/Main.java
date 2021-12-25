package com.codingtest.algorithm.acmicpc.q3008;

import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Point[] points = new Point[n];
        Line tempL;
        Map<Double, Set<Line>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            points[i] = new Point(br.readLine());
        }

        HashSet<Line> temp;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                tempL = new Line(points[i], points[j]);
                if (map.containsKey(tempL.a)) {
                    map.get(tempL.a).add(tempL);
                } else {
                    temp = new HashSet<>();
                    temp.add(tempL);
                    map.put(tempL.a, temp);
                }

                if (tempL.a == 0) {
                    if (map.containsKey(Double.POSITIVE_INFINITY)) {
                        accept(tempL, map.get(Double.POSITIVE_INFINITY));
                    }
                    if (map.containsKey(Double.NEGATIVE_INFINITY)) {
                        accept(tempL, map.get(Double.NEGATIVE_INFINITY));
                    }
                } else if (Double.isInfinite(tempL.a) && map.containsKey(0.0)) {
                    accept(tempL, map.get(0.0));
                } else if (map.containsKey(-1 / tempL.a)) {
                    accept(tempL, map.get(-1 / tempL.a));
                }
            }
        }

        bw.write(answer + "\n");
        bw.flush();
    }

    private static void accept(Line first, Set<Line> find) {
        for (Line line : find) {
            if (isCoordinateOne(first, line)) {
                answer++;
            }
        }
    }

    private static boolean isCoordinateOne(Line a, Line b) {
        return a.p1 == b.p1 || a.p1 == b.p2 || a.p2 == b.p1 || a.p2 == b.p2;
    }
}

class Point {
    int x, y;

    public Point(String input) {
        this.x = Integer.parseInt(input.split(" ")[0]);
        this.y = Integer.parseInt(input.split(" ")[1]);
    }
}

class Line {
    Point p1, p2;
    double a;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.a = (double) (p2.y - p1.y) / (p2.x - p1.x);
    }
}