package com.datastruct;

import java.util.ArrayList;
import java.util.List;

public class StackList 
{
    static class StckList 
    {
        private List<Character> list = new ArrayList<>();
        public void push(char a) { list.add(a); } 
        public char pop() { return list.remove(list.size() - 1); }
        public char peek() { return list.get(list.size() - 1); }
        public boolean isEmpty() { return list.isEmpty(); }
    }

    public static int getPrior(char op) 
    {
        if (op == '+' || op == '-') return 1;
        else if (op == '*' || op == '/') return 2;
        else if (op == '^') return 3;
        else return -1;
    }

    public static String Conv(String infix) // di Konversi Infix to Postfix
    {
        infix = infix.replaceAll("\\s+", "");
        StckList stack = new StckList(); // Pakai Stack biar gampang
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) 
        {
            char c = infix.charAt(i);
            if (Character.isLetterOrDigit(c)) 
            {
                postfix.append(c).append(" ");
            } 
            else if (c == '(') 
            {
                stack.push(c);
            } 
            else if (c == ')') 
            {
                while (!stack.isEmpty() && stack.peek() != '(') 
                {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.pop(); 
            } 
            else 
            {
                while (!stack.isEmpty() && getPrior(c) <= getPrior(stack.peek())) 
                {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) 
        {
            postfix.append(stack.pop()).append(" ");
        }
        return postfix.toString().trim();
    }

    public static void main(String[] args) 
    {
        String infix = "( a + b * (c / ( d - e ))) + f / g";
        System.out.println("========== STACK ==========");
        System.out.println("Infix   : " + infix);
        System.out.println("Postfix : " + Conv(infix));
    }
}