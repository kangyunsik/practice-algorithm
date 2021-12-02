package com.codingtest.algorithm.acmicpc.q2589;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static char[][] map;
    static boolean[][] visit;
    static int l,w;
    static final int[] dx = {0,1,0,-1};
    static final int[] dy = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int answer = 0;
        st = new StringTokenizer(br.readLine()," ");
        l = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        map = new char[l][w];
        visit = new boolean[l][w];

        for (int i = 0; i < l; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < w; j++) {
                if(map[i][j] == 'L') {
                    initVisit();
                    answer = Integer.max(answer, bfs(i, j));
                }
            }
        }
        bw.write(answer+"");
        bw.flush();
    }
    private static void initVisit(){
        for (int i = 0; i < l; i++) {
            Arrays.fill(visit[i],false);
        }
    }

    private static int bfs(int x, int y){
        Queue<Index> queue = new LinkedList<>();
        queue.offer(new Index(x,y,0));

        int max = 0;
        while(!queue.isEmpty()){
            Index poll = queue.poll();
            if(visit[poll.x][poll.y]) continue;
            visit[poll.x][poll.y] = true;
            max = Integer.max(max,poll.depth);
            for (int i = 0; i < 4; i++) {
                int px = poll.x+dx[i];
                int py = poll.y+dy[i];
                if(inRange(px,py) && map[px][py] == 'L' && !visit[px][py]){
                    queue.offer(new Index(px,py, poll.depth+1));
                }
            }
        }
        return max;
    }

    private static boolean inRange(int x,int y){
        return x>=0&&y>=0&&x<l&&y<w;
    }

}

class Index{
    int x;
    int y;
    int depth;

    public Index(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}
