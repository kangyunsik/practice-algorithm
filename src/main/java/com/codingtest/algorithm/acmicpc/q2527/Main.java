package com.codingtest.algorithm.acmicpc.q2527;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            Square square1 = new Square(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Square square2 = new Square(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            if (square1.meetOnlyOnePoint(square2)) {
                bw.write("c\n");
            } else if (square1.outOfRange(square2)) {
                bw.write("d\n");
            } else if (square1.meetWithEdge(square2)) {
                bw.write("b\n");
            } else {
                bw.write("a\n");
            }
        }
        bw.flush();
    }

    static class Square {
        int x1, y1, x2, y2;

        public Square(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        public boolean meetOnlyOnePoint(Square t) {
            return (x2 == t.x1 && y2 == t.y1) || (x1 == t.x2 && y2 == t.y1) ||
                    (x2 == t.x1 && y1 == t.y2) || (x1 == t.x2 && y1 == t.y2);
        }

        public boolean meetWithEdge(Square t) {
            return (x1 == t.x2 && y2 != t.y1) || (x2 == t.x1 && y2 != t.y1) ||
                    (y1 == t.y2 && x1 != t.x2) || (y2 == t.y1 && x2 != t.x1);
        }

        public boolean outOfRange(Square t) {
            return x2 < t.x1 || x1 > t.x2 || y2 < t.y1 || y1 > t.y2;
        }
    }
}
