package com.codingtest.algorithm.acmicpc.q4866;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n, ans;
        Set<Integer> exist = new HashSet<>();
        Point[] points;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            exist.clear();
            ans = 0;
            points = new Point[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                Point point = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                points[i] = point;
                exist.add(getCode(point.x, point.y));

                for (int j = i - 1; j >= 0; j--) {
                    int midX = points[i].x + points[j].x;
                    int midY = points[i].y + points[j].y;
                    int dx = points[i].x - points[j].x;
                    int dy = points[i].y - points[j].y;
                    if ((midX + dy) % 2 == 0 && (midY + dx) % 2 == 0 &&
                            exist.contains(getCode((midX + dy) / 2, (midY - dx) / 2)) &&
                            exist.contains(getCode((midX - dy) / 2, (midY + dx) / 2))) {
                        ans++;
                    }
                }
            }

            bw.write(ans + "\n");
            bw.flush();

        }
    }

    static int getCode(int x, int y) {
        return x * 100000 + y;
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
