// Pertemuan 5

package com.datastruct.Bst;

class BTNode<K,V>
{
    private K key;
    private V data;
    private BTNode<K,V> llink;
    private BTNode<K,V> rlink;

    //Construcutor
    public  BTNode(K key, V data) {
        this.key = key;
        this.data = data;
        this.llink = null;
        this.rlink = null;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getData() {
        return data;
    }

    public void setData(V data) {
        this.data = data;
    }
    
    public BTNode<K, V> getLlink() {
        return llink;
    }

    public void setLlink(BTNode<K, V> llink) {
        this.llink = llink;
    }
    public BTNode<K, V> getRlink() {
        return rlink;
    }

    public void setRlink(BTNode<K, V> rlink) {
        this.rlink = rlink;
    }
}

public class BinaryTree<K,V>
{
    public void printlnOrder(BTNode<K,V> node)
    {

    }

    public void printPostOrder(BTNode<K,V> node)
    {

    }

    void printPreOrder(BTNode<K,V> node)
    {
        if(node == null) 
            return;
        else
        {
            //cetak key dari node
            System.out.print(node.getKey() + ":" + node.getData() + " ");

            printPreOrder(node.getLlink());
            printPreOrder(node.getRlink());
        }
    }

    private void printLevelOrderRec(MyLinearList<BTNode<K,V>> q)
    {
        if(q.isEmpty())
            return;
        
        BTNode<K,V> node = q.remove();
        //Cetak key dari node
        System.out.print(node.getKey() + ":" + node.getData() + " ");
        if(node.getLlink() != null)
            q.pushQ(node.getLlink());
        if(node.getRlink() != null)
            q.pushQ(node.getRlink());
        printLevelOrderRec(q);
    }

    public void printLevelOrder(BTNode<K,V> node)
    {
        MyLinearList<BTNode<K,V>> q = new MyLinearList<BTNode<K,V>>();
        q.pushQ(node);
        printLevelOrderRec(q);
    }
}
