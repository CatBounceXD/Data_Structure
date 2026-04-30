package com.datastruct;

class Node<T>
{
    private T data;
    private Node<T> next;
    //Constructor
    Node(T value)
    {
        data = value;
        next = null;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}

public class MyLinearList<T>
{
    Node<T> head;
    Node<T> tail;

    //Constructor
    public MyLinearList()
    {
        head = null;
        tail = null;
    }

    //Node Baru di list Akhir
    public void pushQ(T value)
    {
        // node baru
        Node<T> newNode = new Node<T>(value);
        // List Kosong
        if (head == null)
        {
            head = newNode;
            tail = newNode;
        }

        // List tidak ksg
        else
        {
            tail.setNext(newNode);
            tail = newNode;
        }
    }
    
    // node baru di awal List (stack)
    public void pushS(T value)
    {
        Node<T> newNode = new Node<T>(value);
        
        if (head == null)
        {
            head = newNode;
            tail = newNode;
        }
    
        // List tidak ksg
        else
        {
            newNode.setNext(head);
            head = newNode;
        }
    }

    public void cetakList()
    {
        Node<T> curr = head;

        if(curr == null)
            System.out.println("List kosong!");
        else
        {
            System.out.print("[ ");
            while (curr != null)
            {
                System.out.print(curr.getData().toString() + " ");
                curr = curr.getNext();
            }
        }
        System.out.println(" ]");
    }

    private Node<T> pop()
    {
        Node<T> n;
        if(head == null) 
            n = null;
            else
        {
            n = head;
            head = head.getNext();
            if(head == null)
            {
                tail = null;
            }
        }
        return n;
    }

    public T remove()
    {
        Node<T> n = pop();
        if(n == null)
            return null;
        else
            return n.getData();
    }

    public boolean remove(T data)
    {
        Node<T> curr = head;
        Node<T> prev = head;
        boolean deleted = false;

        while (curr != null && !deleted)
        {
            //Node ditemukan
            if(curr.getData().equals(data))
            {
                deleted = true;
                //update node sblm ke sesudah node dihapus
                prev.setNext(curr.getNext());
                //jika node pertama di remove, update head ke node ke2
                if(curr == head) head = head.getNext();
                //jika list hanya punya 1 node
                if(head == null) tail = null;
            }
            /*
                jika belum ditemukan node yg akan diremove, simpan pointer
                ke node saat ini, & update pointer ke node berikutnya
             */
            else
            {
                prev = curr;
                curr = curr.getNext();
            }
        }
        return deleted;
    }
      
    public boolean isEmpty()
    {
        if(head == null) return true;
        else return false;
    }
}