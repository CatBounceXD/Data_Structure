package com.datastruct;

public class SingularList 
{
    Node head  = null;
    Node tail = null;

    public void pushQ(int data)
    {
        Node newNode = new Node(data);

        if (head == null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void printList() 
    {
        Node curr = head;
        if (curr == null) System.out.println("List kosong!");

        else
        {
            System.out.print("[ ");
            while(curr != null)
            {
                System.out.print(curr.info + " ");

                curr = curr.next;
            }
        }
        System.out.println(" ]");
    }

    Node pop()
    {
        Node n;
        if(head == null) return head;
        else
        {
            n = head;
            head = head.next;
            if(head == null)
            {
                tail = null;
            }
        }
        return n;
    }

    public static void main(String[] args) 
    {
            
    }
}
