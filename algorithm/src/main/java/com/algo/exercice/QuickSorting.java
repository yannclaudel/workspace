package com.algo.exercice;
import java.util.Random;
import java.util.Scanner;

public class QuickSorting {
    private static Random random = new Random();
    /**
     * TODO
     * @param a
     * @param l
     * @param r
     * @return
     */
    private static int partition(int[] a, int l, int r) {
        
        return -1;
    }
    /**
     * this is better version of QuickSort, the pivot is not the first element 
     * but the index of the pivot is random
     * @param a
     * @param l
     * @param r
     */
    public static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;

        int m = partition(a, l, r);
        randomizedQuickSort(a, l, m - 1);
        randomizedQuickSort(a, m + 1, r);
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        scanner.close();
    }   
}

