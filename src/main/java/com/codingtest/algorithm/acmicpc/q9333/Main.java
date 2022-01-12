package com.codingtest.algorithm.acmicpc.q9333;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());
        int day;
        double r,b,m;
        for (int TEST_CASE = 0; TEST_CASE < test_case; TEST_CASE++) {
            st = new StringTokenizer(br.readLine(), " ");
            r = Double.parseDouble(st.nextToken());
            b = Double.parseDouble(st.nextToken());
            m = Double.parseDouble(st.nextToken());
            day = 1;
            while (day <= 1200) {
                b = multiple(b,r);
                b -= m;
                if(b <= 0) break;
                day++;
            }
            if (day == 1201) {
                bw.write("impossible\n");
            } else {
                bw.write(day + "\n");
            }
            bw.flush();
        }
    }

    private static double multiple(double b, double r) {
        return Math.round(b*(100+r))/100.0;
    }
}
