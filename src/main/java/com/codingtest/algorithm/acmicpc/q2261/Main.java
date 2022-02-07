package com.codingtest.algorithm.acmicpc.q2261;

import java.io.*;
import java.util.*;

public class Main {
    static Point[] points;
    static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        points = new Point[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(points, Comparator.comparingInt(p -> p.x));
        bw.write(getMinDist(0, n) + "\n");
        bw.flush();
    }

    private static int getMinDist(int begin, int end) {
        if(begin == end - 1){
            return INF;
        }else if (begin == end - 2) {
            return calc(points[begin], points[begin+1]);
        }

        int mid = (begin + end) / 2;
        int temp = Math.min(getMinDist(begin, mid), getMinDist(mid, end));

        List<Point> possible = new ArrayList<>();
        for (int i = begin; i < end; i++) {
            if (pow(points[i].x - points[mid].x) < temp)
                possible.add(points[i]);
        }

        Collections.sort(possible, Comparator.comparingInt(p -> p.y));
        for (int i = 0; i < possible.size(); i++) {
            for (int j = i + 1; j < possible.size() && pow(possible.get(i).y - possible.get(j).y) < temp; j++) {
                temp = Math.min(temp, calc(possible.get(i), possible.get(j)));
            }
        }

        return temp;
    }

    private static int pow(int x) {
        return x * x;
    }

    private static int calc(Point p1, Point p2) {
        return pow(p1.x - p2.x) + pow(p1.y - p2.y);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
