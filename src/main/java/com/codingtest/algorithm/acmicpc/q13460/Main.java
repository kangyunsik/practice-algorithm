package com.codingtest.algorithm.acmicpc.q13460;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static final int[] dx = {0,0,1,-1};
    static final int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Map.board = new char[n][m];
        Point red = null, blue = null;
        int ans = -1;
        String input;
        for (int i = 0; i < n; i++) {
            input = br.readLine();
            for (int j = 0; j < m; j++) {
                Map.board[i][j] = input.charAt(j);
                if(Map.board[i][j] == 'R'){
                    red = new Point(i,j);
                    Map.board[i][j] = '.';
                }else if(Map.board[i][j] == 'B'){
                    blue = new Point(i,j);
                    Map.board[i][j] = '.';
                }else if(Map.board[i][j] == 'O'){
                    Map.hole = new Point(i,j);
                }
            }
        }
        Point.board = Map.board;

        Queue<Map> queue = new LinkedList<>();
        queue.offer(new Map(red, blue, 0));
        while(!queue.isEmpty()){
            Map poll = queue.poll();
            if(poll.cnt > 10) {
                break;
            }
            if(poll.blue.isAbsent()) {
                continue;
            }
            if(poll.red.isAbsent()){
                ans = poll.cnt;
                break;
            }
            for (int i = 0; i < 4; i++) {
                queue.offer(poll.move(dx[i], dy[i]));
            }
        }

        bw.write(ans+"\n");
        bw.flush();
    }
}

class Point{
    static char[][] board;
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point temp){
        this.x = temp.x;
        this.y = temp.y;
    }

    public boolean isAbsent(){
        return x == -100 && y == -100;
    }

    public void setAbsent(){
        this.x = -100;
        this.y = -100;
    }

    public void move(Point warn, int dx, int dy){
        while(board[x + dx][y + dy] == '.' && !(warn.x == x + dx && warn.y == y + dy)){
            this.x += dx;
            this.y += dy;
        }
        if(board[x + dx][y + dy] == 'O'){
            setAbsent();
        }
    }
}

class Map{
    static char[][] board;
    static final Point dummy = new Point(-1,-1);
    static Point hole;
    Point red;
    Point blue;
    int cnt;

    public Map(Point red, Point blue, int cnt) {
        this.red = new Point(red.x, red.y);
        this.blue = new Point(blue.x, blue.y);
        this.cnt = cnt;
    }

    public Map move(int dx, int dy){
        Point nextRed = new Point(red);
        Point nextBlue = new Point(blue);
        boolean flag;
        if(dx == 0 && dy == -1){
            flag = red.y < blue.y;
        }else if(dx == 0 && dy == 1){
            flag = red.y > blue.y;
        }else if(dx == -1 && dy == 0){
            flag = red.x < blue.x;
        }else{
            flag = red.x > blue.x;
        }

        if(flag){
            nextRed.move(dummy, dx, dy);
            nextBlue.move(nextRed, dx, dy);
        }else{
            nextBlue.move(dummy, dx, dy);
            nextRed.move(nextBlue, dx, dy);
        }
        return new Map(nextRed, nextBlue, cnt+1);
    }
}