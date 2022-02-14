package com.codingtest.algorithm.acmicpc.q20361;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /***
         *      T   = 테스트 케이스 수
         *      n   = 종이컵의 수
         *      x   = 간식이 들어있는 초기 종이컵의 위치
         *      k   = 컵의 위치를 맞바꾸는 횟수
         *      a   = 위치를 바꿀 컵1 의 위치
         *      b   = 위치를 바꿀 컵2 의 위치
         */
        int n, x, k, a, b;
        // StringTokenizer 로 입력 파싱 및 n, x, k 정수형으로 할당
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 간식의 위치를 관리하도록 boolean 배열을 이용
        boolean[] location = new boolean[n];
        // 초기 간식의 위치만 true 로 설정
        location[x - 1] = true;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken()) - 1;
            // 입력 값에 대해 boolean[] location 배열 swap 하도록 구현
            swap(location, a, b);
        }

        // 반복문으로 계산된 간식의 위치 탐색 및 출력하도록 구현.
        for (int i = 0; i < n; i++) {
            if (location[i]) {
                bw.write(String.valueOf(i + 1));
                bw.flush();
                return;
            }
        }
    }

    /***
     * @param loc   : swap 을 진행 할 배열
     * @param a     : 위치1
     * @param b     : 위치2
     */
    private static void swap(boolean[] loc, int a, int b) {
        boolean temp = loc[a];
        loc[a] = loc[b];
        loc[b] = temp;
    }
}

