package com.company.algo.sort;

import java.util.Arrays;
import java.util.Scanner;

public class BubleSort {

    public static int[] sort(int[] input){
        boolean isSorted=false;
        int lastUnsorted = input.length - 1;
        while (!isSorted){
            isSorted=true;
            for(int i = 0; i< lastUnsorted; i++){
                if(input[i]>input[i+1]) {
                    swap(input, i, i + 1);
                    isSorted=false;
                }
            }
            lastUnsorted--;
        }
        return input;
    }

    private static void swap(int[] input, int i, int i1) {
        int temp=input[i];
        input[i]=input[i1];
        input[i1]=temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] unsorted = new int[n];
        for(int i = 0; i < n; i++) {
            unsorted[i] = scanner.nextInt();
        }
        scanner.close();

        int[] sort = sort(unsorted);
        Arrays.stream(sort).forEach(System.out::println);
    }
}
