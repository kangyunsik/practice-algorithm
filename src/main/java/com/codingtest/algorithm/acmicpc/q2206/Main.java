package com.codingtest.algorithm.acmicpc.q2206;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {

    static boolean[][] map;
    static boolean[][][] already;
    static int answer = Integer.MAX_VALUE;
    static final int[] dx = {0,1,0,-1};
    static final int[] dy = {1,0,-1,0};
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        char[] input;
        st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new boolean[n][m];
        already = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            input = br.readLine().toCharArray();
            for (int j = 0; j < input.length; j++) {
                map[i][j] = input[j] != '0';
            }
        }
        br.close();

        bfs(0,0);
        if(answer == Integer.MAX_VALUE)
            bw.write("-1");
        else
            bw.write(answer+"");
        bw.flush();
        bw.close();
    }

    private static void bfs(int x, int y){

        Queue<Index> queue = new LinkedList<>();
        queue.offer(new Index(x, y, true, 1));

        while(!queue.isEmpty()){
            Index poll = queue.poll();
            if(poll.x == n - 1 && poll.y == m - 1){
                answer = poll.depth;
                break;
            }
            if(already[poll.x][poll.y][poll.chance ? 1 : 0]) continue;
            already[poll.x][poll.y][poll.chance ? 1 : 0] = true;
            for (int i = 0; i < 4; i++) {
                int px = poll.x+dx[i];
                int py = poll.y+dy[i];
                if(inRange(px,py) && !already[px][py][poll.chance ? 1 : 0]){
                    if(map[px][py]){
                        if(poll.chance){
                            queue.offer(new Index(px,py,false,poll.depth+1));
                        }
                    }else{
                        queue.offer(new Index(px,py,poll.chance,poll.depth+1));
                    }

                }
            }
        }
    }

    private static boolean inRange(int x, int y){
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}

class Index{
    int x;
    int y;
    boolean chance;
    int depth;

    public Index(int x, int y, boolean chance, int depth) {
        this.x = x;
        this.y = y;
        this.chance = chance;
        this.depth = depth;
    }
}
