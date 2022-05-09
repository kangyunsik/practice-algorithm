package com.codingtest.algorithm.acmicpc.q7869;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double x1 = Double.parseDouble(st.nextToken());
        double y1 = Double.parseDouble(st.nextToken());
        double r1 = Double.parseDouble(st.nextToken());
        double x2 = Double.parseDouble(st.nextToken());
        double y2 = Double.parseDouble(st.nextToken());
        double r2 = Double.parseDouble(st.nextToken());

        double dist = getDist(x1, y1, x2, y2);
        double sr1 = Math.max(r1, r2);
        double sr2 = Math.min(r1, r2);
        if(dist >= r1 + r2){
            System.out.println("0.000");
        }else if(dist + sr2 <= sr1){
            System.out.printf("%.3f", sr2 * sr2 * Math.PI);
        }else{
            double theta1 = getThata(r1, dist, r2);
            double theta2 = getThata(r2, dist, r1);
            double ans = getArea(theta1, r1) + getArea(theta2, r2);
            System.out.printf("%.3f", ans);
        }
    }

    private static double getArea(double theta, double r) {
        return r * r * (theta - Math.cos(theta) * Math.sin(theta));
    }

    private static double getThata(double a, double b, double c){
        return Math.acos((a * a + b * b - c * c) / 2 / a / b);
    }

    private static double getDist(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }
}