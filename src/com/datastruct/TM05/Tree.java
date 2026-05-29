package com.datastruct.TM05;

public interface Tree <K,V>
{
    public void insert(K key, V data);
    public void delete(K key);    
}
