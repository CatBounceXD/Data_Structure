package com.datastruct.Bst;

//Main Method
public class MainProgram {
    public static void main(String[] args) {
        LinearProbing<Object, String> T = new LinearProbing<Object, String>(7);
        T.put("2", "B");
        T.put("10", "J");
        T.put("14", "N");
        T.put("19", "S");
        T.put("23", "W");
        T.displayHashTable();

        if (T.get("23") != null)
            System.out.println("Data found: " + T.get("23"));
        else 
            System.out.println("Data does not exist!");
    }
}