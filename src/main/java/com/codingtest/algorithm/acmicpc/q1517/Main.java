package com.codingtest.algorithm.acmicpc.q1517;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(0, n - 1);
        System.out.println(ans);
    }

    private static void mergeSort(int begin, int end) {
        if (begin == end) return;

        int mid = (begin + end) / 2;
        mergeSort(begin, mid);
        mergeSort(mid + 1, end);
        conquer(begin, mid, end);
    }

    private static void conquer(int begin, int mid, int end) {
        int left = begin;
        int right = mid + 1;
        int idx = 0, cnt = 0;
        int h = end - begin + 1;
        int[] temp = new int[h];
        while(idx < h) {
            if(left == mid + 1){
                temp[idx++] = arr[right++];
                cnt++;
            }else if(right == end + 1){
                temp[idx++] = arr[left++];
                ans += cnt;
            }else if(arr[left] <= arr[right]){
                temp[idx++] = arr[left++];
                ans += cnt;
            }else{
                temp[idx++] = arr[right++];
                cnt++;
            }
        }
        for (int i = 0; i < h; i++) {
            arr[begin + i] = temp[i];
        }
    }
}