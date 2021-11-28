package com.codingtest.algorithm.acmicpc.q3008;

import java.io.*;
import java.util.*;

public class Main {

    static Line dummy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        Line[] lines = new Line[n*(n-1)/2];
        int[] x = new int[n];
        int[] y = new int[n];
        dummy = new Line(1,1);
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int cnt = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i + 1; j < n; j++) {
                lines[cnt++] = new Line(x[i] - x[j], y[i] - y[j]);
            }
        }

        Arrays.sort(lines,Comparator.comparingDouble(o -> o.w));
        for (Line line : lines) {
            dummy.w = -1 / line.w;
            int nIndex = findMinIndexDup(lines);
            do{
                if(lines[nIndex].isVertWith(line)){
                    answer++;
                    nIndex++;
                }else{
                    break;
                }
            }while(nIndex < lines.length);
        }
        bw.write(answer/2+"");
        bw.flush();
        bw.close();
    }

    private static int findMinIndexDup(Line[] lines){
        int index = Arrays.binarySearch(lines, dummy);
        if(index < 0) index = -index-2;
        double tw = lines[index].w;
        while(index > 0 && lines[index-1].w == tw){
            index--;
        }
        return index;
    }
}

class Line implements Comparable<Line>{
    int dx;
    int dy;
    double w;

    @Override
    public int compareTo(Line o) {
        return Double.compare(this.w, o.w);
    }

    public Line(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
        this.w = (double) dy/dx;
    }

    public boolean isVertWith(Line target){
        long tempX = (long)this.dx * target.dx;
        long tempY = (long)this.dy * target.dy;
        return tempX + tempY == 0;
    }
}