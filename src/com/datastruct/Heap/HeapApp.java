package com.datastruct;

public class HeapApp
{
    public static void main(String[] args) 
    {
        Integer[] kunci = {11,2,30,4,15};
        String data[] = {"Andree","Leana","Faviola","Loyce","Quincy"};
    
        Heap<Integer, String> heap = new Heap<Integer,String>(kunci.length, false);
        
        for (int i = 0; i < kunci.length; i++)
        {
            heap.insert(kunci[i], data[i]);
        }
        
    }   
}
