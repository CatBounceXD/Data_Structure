package com.datastruct.Bst;

public class BinarySearchTree <K extends Comparable<? super K>,V>extends BinaryTree<K,V> implements Tree<K,V>
{
    private BTNode<K,V> root;

    public BinarySearchTree() 
    {
        this.root = null;
    }

    public void insert(K key, V data) 
    {
        root = insertNode(root, key, data);
    }

    public void delete(K key) 
    {
        root = deleteNode(root, key);
    }

    public BTNode<K,V> deleteNode(BTNode<K,V> node, K key)
    {
        // Lengkapi
        return node;
    }

    public V search(K key)
    {
        V info = null;
        info = getData(root, key);
        return info;
    }

    public K max()
    {
        K kunci = null;
        kunci = getKey(findMax(root));
        return kunci;
    }

    public K min()
    {
        K kunci = null;
        kunci = getKey(findMin(root));
        return kunci;
    }

    private BTNode<K,V> insertNode (BTNode<K,V> node, K k,V data)
    {
        if (node == null)
        {
            BTNode<K,V> newNode = new BTNode<K,V>(k, data);
            return newNode;
        }
        else if (k.compareTo(node.getKey())<0)
        {
            node.setLlink(insertNode(node.getLlink(),k,data));
            return node;
        }
        else
        {
            node.setRlink(insertNode(node.getRlink(),k,data));
            return node;
        }
    }

    private BTNode<K,V> find(BTNode<K,V> node, K k)
    {
        if (node == null || node.getKey() == k)
            return node;
        else if (node.getKey().compareTo(k) < 0)
            return find(node.getRlink(), k);
        else
            return find(node.getLlink(), k);
    }

    private BTNode<K,V> findMin(BTNode<K,V> node)
    {

    } 
    private BTNode<K,V> findMax(BTNode<K,V> node)
    {

    }
    
    public void inOrder()
    {
        // printInOrder(root);
    }

    public void levelOrder()
    {
        printLevelOrder(root);
    }

    public void preOrder()
    {
        // Lengkapi
    }

    public void postOrder()
    {
        // Lengkapi (panggil method printPostOrder)
    }

    public K getKey(BTNode<K,V> node)
    {
        return node.getKey();
    }

    public V getData(BTNode<K,V> node,K keyt)
    {
        return node.getData();
    }


}