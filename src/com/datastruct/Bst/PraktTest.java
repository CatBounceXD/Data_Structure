package com.datastruct.Bst;

import java.util.Arrays;

class HashTable 
{
    private Integer[] has;
    private int size;

    public HashTable(int size) 
    {
        this.size = size;
        has = new Integer[size];
    }

    private int hash1(int key) 
    {
        return key % size;
    }

    private int hash2(int key) 
    {
        return 1 + (key % 7);
    }

    public void insertLinear(int key) 
    {
        int index = hash1(key);

        while (has[index] != null) 
        {
            index = (index - 1 + size) % size;
        }

        has[index] = key;
    }

    public void insertQuadratic(int key) 
    {
        int index = hash1(key);
        int i = 1;

        while (has[index] != null) 
        {
            index = (hash1(key) - (i * i % size) + size) % size;
            i++;
        }

        has[index] = key;
    }

    public void insertDoubleHash(int key) 
    {
        int index = hash1(key);
        int step = hash2(key);
        int i = 1;

        while (has[index] != null) 
        {
            index = (hash1(key) - (i * step % size) + size) % size;
            i++;
        }

        has[index] = key;
    }

    public void display() 
    {
        System.out.println(Arrays.toString(has));
    }

    public void reset() 
    {
        Arrays.fill(has, null);
    }
}

public class PraktTest 
{
    public static void main(String[] args) 
    {

        int[] data = {4371, 1323, 6173, 4199, 4344, 9679, 1989};
        int size = 10;

        HashTable ht = new HashTable(size);

        System.out.println("Linear Probing :");
        for (int x : data) 
        {
            ht.insertLinear(x);
        }
        ht.display();

        ht.reset();
        System.out.println("\nQuadratic Probing :");
        for (int x : data) 
        {
            ht.insertQuadratic(x);
        }
        ht.display();

        ht.reset();
        System.out.println("\nDouble Hashing :");
        for (int x : data) 
        {
            ht.insertDoubleHash(x);
        }
        ht.display();
    }
}