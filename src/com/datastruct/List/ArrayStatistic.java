package com.datastruct;

import java.util.Scanner;
import java.lang.Math;

public class ArrayStatistic 
{
    static final int MIN = 1;
    static final int MAX = 100;

    static double Mean(int n, int[] data)
    {
        double sum = 0;
        for(int i = 0; i < n; i++)
        {
            sum += data [i];
        }
        return (sum/n);
    }

    static double STD_DEV(int n, int data[], double rata)
    {
        double sum = 0;
        for(int i = 0; i < n; i++)
        {
            sum += Math.pow((data[i] - rata),2);
        }
        return (Math.sqrt(sum / (n-1)));
    }

    public static void main(String[] args) 
    {
         int n;
         int[] data;
         
         Scanner scan = new Scanner(System.in);
         do{
            System.out.print("Masukkan n (minimum n = 2) = ");
            n = scan.nextInt();
         } while (n < 2);
         scan.close();

         // menamai array
         data = new int[n];

         // generate ramndom num
         for ( int i = 0; i<n; i++)
         {
            data[i] = (int)(Math.random()*(MAX - MIN + 1));
            System.out.print(data[i]+" ");
         }
         System.out.println();

         //Call mean () and STD_DEV()
         double mean = Mean(n, data);
         System.out.println("Rata2 = " + mean);
         System.out.println("Simpangan Baku = " + STD_DEV(n,data,mean));
    }

}
