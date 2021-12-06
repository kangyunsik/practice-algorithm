package com.codingtest.algorithm.acmicpc.q10825;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            students[i] = new Student(br.readLine());
        }
        Arrays.sort(students);
        for(Student s : students)
            bw.write(s.name+"\n");
        bw.flush();
    }
}

class Student implements Comparable<Student>{
    String name;
    int kor;
    int eng;
    int math;

    @Override
    public int compareTo(Student o) {
        if(this.kor == o.kor){
            if(this.eng == o.eng){
                if(this.math == o.math){
                    return this.name.compareTo(o.name);
                }
                return o.math - this.math;
            }
            return this.eng - o.eng;
        }else{
            return o.kor - this.kor;
        }
    }

    public Student(String info) {
        StringTokenizer st = new StringTokenizer(info," ");
        name = st.nextToken();
        kor = Integer.parseInt(st.nextToken());
        eng = Integer.parseInt(st.nextToken());
        math = Integer.parseInt(st.nextToken());
    }
}