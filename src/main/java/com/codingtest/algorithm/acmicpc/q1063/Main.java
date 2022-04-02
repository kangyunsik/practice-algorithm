package com.codingtest.algorithm.acmicpc.q1063;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static final int BOARD_SIZE = 8;
    static final int[] dr = {0, 0, 1, -1, -1, -1, 1, 1};
    static final int[] dc = {1, -1, 0, 0, 1, -1, 1, -1};
    static Map<String, Integer> dirMapper;
    static String[] seq = {"R", "L", "B", "T", "RT", "LT", "RB", "LB"};
    static int[] king = new int[2];
    static int[] stone = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        initMapper();
        setLocation(st.nextToken(), king);
        setLocation(st.nextToken(), stone);
        int orderCnt = Integer.parseInt(st.nextToken());
        for (int i = 0; i < orderCnt; i++) {
            String order = br.readLine();
            move(order, king, true);
        }
        System.out.println(getCode(king));
        System.out.println(getCode(stone));
    }

    private static void initMapper() {
        dirMapper = new HashMap<>();
        for (int i = 0; i < 8; i++) {
            dirMapper.put(seq[i], i);
        }
    }

    private static boolean move(String order, int[] loc, boolean isKing) {
        int dir = dirMapper.get(order);
        int nextR = loc[0] + dr[dir];
        int nextC = loc[1] + dc[dir];
        if (isInvalidRange(nextR, nextC)) return false;
        if (!isKing || !(stone[0] == nextR && stone[1] == nextC) || move(order, stone, false)) {
            loc[0] = nextR;
            loc[1] = nextC;
        }
        return true;
    }

    private static boolean isInvalidRange(int r, int c) {
        return r < 0 || c < 0 || r >= BOARD_SIZE || c >= BOARD_SIZE;
    }

    private static String getCode(int[] loc) {
        return (char) (loc[1] + 'A') + "" + (BOARD_SIZE - loc[0]);
    }

    private static void setLocation(String locString, int[] loc) {
        loc[0] = BOARD_SIZE - (locString.charAt(1) - '0');
        loc[1] = locString.charAt(0) - 'A';
    }
}
