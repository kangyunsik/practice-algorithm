package com.codingtest.algorithm.q1043;

import java.io.*;
import java.util.*;

public class Main {
    int n, m;
    Set<Integer> know;
    List[] party;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Main main = new Main(n, m);
        main.setKnow(br.readLine());
        for (int i = 0; i < m; i++) {
            main.set(i, br.readLine());
        }
        main.run();

        bw.write(main.getAnswer() + "\n");
        bw.flush();
    }

    Main(int n, int m) {
        this.n = n;
        this.m = m;
        know = new HashSet<>();
        party = new ArrayList[m];
    }

    void setKnow(String input) {
        StringTokenizer st = new StringTokenizer(input, " ");
        int c = Integer.parseInt(st.nextToken());
        for (int i = 0; i < c; i++) {
            know.add(Integer.parseInt(st.nextToken()));
        }
    }

    void set(int index, String input) {
        StringTokenizer st = new StringTokenizer(input, " ");
        int c = Integer.parseInt(st.nextToken());
        party[index] = new ArrayList<>();
        for (int i = 0; i < c; i++) {
            int k = Integer.parseInt(st.nextToken());
            party[index].add(k);
        }
    }

    void run() {
        for (List<Integer> list : party) {
            for (int i = 0; i < list.size(); i++) {
                if (know.contains(list.get(i))) {
                    know.addAll(list);
                    deletePartyFromList(list);
                    break;
                }
            }
        }
    }

    private void deletePartyFromList(List<Integer> list) {
        for (List<Integer> integers : party) {
            for (Integer integer : list) {
                if (integers.contains(integer)) {
                    ArrayList<Integer> recursive = new ArrayList<>(integers);
                    integers.clear();
                    deletePartyFromList(recursive);
                    break;
                }
            }
        }
    }

    int getAnswer() {
        int answer = party.length;
        for (List<Integer> integers : party) {
            if (integers.size() == 0)
                answer--;
        }
        return answer;
    }
}
