package com.datastruct.TM04;
import com.datastruct.Utils.MyArrayList;

class HashNode<K,V> 
{
    K key;
    V data;

    HashNode(K key, V data) 
    {
        this.key = key;
        this.data = data;
    }

    @Override
    public String toString() 
    {
        return (key.toString() + " - " + data.toString() + " ");
    }
}

public class Hashing<K,V> 
{
    private int size;
    MyArrayList<HashNode<K,V>> table;

    //Constructor
    Hashing (int capacity)
    {
        table = new MyArrayList<HashNode<K,V>>(capacity);
        size = 0;
    }

    int convertToNumber(K key)
    {
        String theKey = (key.toString()).toLowerCase();
        int k = 0,bil;
        int i = 0;
        int j = theKey.length() - 1;
        do
        {
            bil = theKey.charAt(i);
            if (bil >= 48 && bil <= 57) bil = bil - 48;
            else bil = bil - 97 + 1;
            k = k + (bil * (int)Math.pow(10,j));
            i++;--j;
        } while (i < theKey.length());
        return k;
    }

    boolean isCollision(int hashkey)
    {
        if(table.get(hashkey) != null) 
        {
            return true;
        }
        return false;
    }
    int size()
    {
        return size;
    }

    void incSize()
    {
        ++size;
    }

    void decSize()
    {
        --size;
    }

    public void put (K key, V value)
    {
        HashNode<K,V> N = new HashNode<K,V>(key, value);
        int h = convertToNumber(key) % table.maxSize();
        if (!isCollision(h)) 
        {
            table.set(h,N);
            incSize();
        }
        else System.out.println("Item exsist or table is full");
    }

    public void displayHashTable()
    {
        System.out.println("Hash Table Contains " + size() + " items");
        for (int i = 0; i < table.maxSize(); i++) 
        {
            if (table.get(i) != null) 
                System.out.println(i + " : " + table.get(i).toString() + " ");  
            else
                System.out.println(i + " : ");
        }
    }
}


