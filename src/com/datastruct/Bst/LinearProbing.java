package com.datastruct.Bst;

public class LinearProbing <K,V> extends Hashing<K,V>
{
    public LinearProbing(int capacity) 
    {
        super(capacity);
    }

    @Override
    public void put(K key, V value) 
    {
        HashNode<K,V> N = new HashNode<K,V>(key, value);
        int theKey = convertToNumber(key) % table.maxSize();
        int curKey = theKey;
        boolean firstScan = true;
        while(isCollision(curKey) && curKey >= 0)
        {
            curKey = (curKey + 1) % table.maxSize();
            if(curKey == theKey && !firstScan) 
                curKey = -1;
            firstScan = false;
        }

        if (curKey >= 0)
        {
            table.set(curKey, N);
            incSize();
        }

        else
            System.out.println("table is full");
    }
    public HashNode<K,V> get(K key)
    {
        int theKey = convertToNumber(key) % table.maxSize();
        int curKey = theKey;
        boolean firstScan = true;
        while(isCollision(curKey) && convertToNumber(table.get(curKey).key) != convertToNumber(key) && curKey >= 0)
        {
            curKey = (curKey + 1) % table.maxSize();
            if(curKey == theKey && !firstScan) 
                curKey = -1;
            firstScan = false;
        }
        if (curKey >= 0) {
            return table.get(curKey);
        }
        else
        {
            System.out.println("Not found");
            return null;
        }
    }

    public HashNode<K,V> remove(K key)
    {
        HashNode<K,V> N;
        int theKey = convertToNumber(key) % table.maxSize();
        int curKey = theKey;
        boolean firstScan = true;
        while(isCollision(curKey) && convertToNumber(table.get(curKey).key) != convertToNumber(key) && curKey >= 0)
        {
            curKey = (curKey + 1) % table.maxSize();
            if(curKey == theKey && !firstScan) 
                curKey = -1;
            firstScan = false;
        }
        if (curKey >= 0) {
            N = table.get(curKey);
            table.set(curKey, null);
            decSize();
            return N;
        }
        else
        {
            System.out.println("Not found");
            return null;
        }
    }
}
