package com.datastruct;

import java.util.Random;

public class HeapSort {
    public static void sort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    public static int[] generateRand(int size) {
        Random rand = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) 
            arr[i] = rand.nextInt(1000000); 

        return arr;
    }

    public static void printSystemSpecs() {
        System.out.println("=== Spesifikasi Komputer ===");
        System.out.println("Sistem Operasi : " + System.getProperty("os.name") + " " + System.getProperty("os.version"));
        System.out.println("Arsitektur OS  : " + System.getProperty("os.arch"));
        System.out.println("Versi Java     : " + System.getProperty("java.version"));
        System.out.println("Prosesor (Core): " + Runtime.getRuntime().availableProcessors());
        System.out.println("============================\n");
    }

    public static void main(String[] args) {
        printSystemSpecs();

        int[] sizes = {10000, 20000, 40000, 80000};

        for (int size : sizes) {
            int[] arr = generateRand(size);
            long startTime = System.nanoTime();
            sort(arr);
            long endTime = System.nanoTime();
            long durationInNano = endTime - startTime;
            double durationInMillis = durationInNano / 1_000_000.0;

            System.out.println("Jumlah Data : " + size + " integers");
            System.out.printf("Waktu Sort  : %.3f milidetik%n", durationInMillis);
            System.out.println();
        }
    }
}