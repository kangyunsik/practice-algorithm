package com.codingtest.algorithm.acmicpc.q1713;

import java.io.*;
import java.util.*;

public class Main {
    static class Candidate {
        int id;
        int rec;
        int date;

        public Candidate(int id, int rec, int date) {
            this.id = id;
            this.rec = rec;
            this.date = date;
        }

        public void increaseRec() {
            this.rec++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int frameNum = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        List<Candidate> frames = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Candidate temp;
        for (int i = 0, input; i < n; i++) {
            input = Integer.parseInt(st.nextToken());
            if ((temp = getCandidate(frames, input)) != null) {
                temp.increaseRec();
            } else {
                if ((frames.size() == frameNum)) removeCandidate(frames);
                frames.add(new Candidate(input, 1, i));
            }
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(frames, Comparator.comparingInt(c -> c.id));
        for (Candidate frame : frames) {
            sb.append(frame.id).append(" ");
        }
        System.out.println(sb);
    }

    private static void removeCandidate(List<Candidate> frames) {
        int minRec = Integer.MAX_VALUE;
        int date = Integer.MAX_VALUE;
        Candidate temp = null;
        for (Candidate frame : frames) {
            if (minRec > frame.rec || (minRec == frame.rec && frame.date < date)) {
                minRec = frame.rec;
                date = frame.date;
                temp = frame;
            }
        }
        frames.remove(temp);
    }

    private static Candidate getCandidate(List<Candidate> frames, int input) {
        for (Candidate frame : frames) {
            if (frame.id == input) return frame;
        }
        return null;
    }
}