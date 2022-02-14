package com.codingtest.algorithm.acmicpc.q20299;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //        System.setIn(new FileInputStream("input2.txt"));
        // 입출력 객체 + 스트링빌더 선언 및 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        /***
         *      n   : 전체 팀의 수
         *      s   : 팀의 능력이 s 이상이어야 하는 조건
         *      m   : 팀 구성원 개인의 능력이 m 이상이어야 하는 조건
         *      cnt : 해당 조건을 만족하는 팀의 개수
         */
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cnt = 0;

        // 팀 내의 멤버 3명의 능력 점수를 저장할 변수 생성
        int member1, member2, member3;
        for (int i = 0; i < n; i++) {
            // StringTokenizer를 이용하여 입력 파싱 및 멤버1,2,3 변수에 정수형으로 할당
            st = new StringTokenizer(br.readLine(), " ");
            member1 = Integer.parseInt(st.nextToken());
            member2 = Integer.parseInt(st.nextToken());
            member3 = Integer.parseInt(st.nextToken());
            // 멤버 1,2,3 점수의 합이 s 보다 크거나 같으며, 멤버1, 2, 3 개개인의 점수가 m보다 크거나 같은 경우,
            // cnt 값을 증가시키고 이후 멤버들을 순차적으로 출력하기 위해 StringBuilder 에 append.
            if (member1 + member2 + member3 >= s && member1 >= m && member2 >= m && member3 >= m) {
                cnt++;
                sb.append(member1).append(" ").append(member2).append(" ").append(member3).append(" ");
            }
        }

        // 표준 출력에 출력.
        bw.write(String.valueOf(cnt));
        bw.write("\n");
        bw.write(sb.toString());
        bw.flush();
    }
}
