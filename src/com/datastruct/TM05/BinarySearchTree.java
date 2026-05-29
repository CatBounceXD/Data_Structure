package com.datastruct.TM05;
import com.datastruct.Utils.BTNode;

public class BinarySearchTree <K extends Comparable<? super K>,V> extends BinaryTree<K,V> implements Tree<K,V>
{
    private BTNode<K,V> root;

    public BinarySearchTree()  { this.root = null; }
    public void insert(K key, V data)  { root = insertNode(root, key, data); }
    public void delete(K key) { root = deleteNode(root, key); }

    public BTNode<K,V> deleteNode(BTNode<K,V> node, K key) {
        if (node == null) return null; // Jika tree kosong atau node tidak ditemukan

        // Telusuri ke kiri atau ke kanan mencari node yang mau dihapus
        if (key.compareTo(node.getKey()) < 0) {
            node.setLlink(deleteNode(node.getLlink(), key));
        } else if (key.compareTo(node.getKey()) > 0) {
            node.setRlink(deleteNode(node.getRlink(), key));
        } else {
            // NODE DITEMUKAN!
            // Skenario 1 & 2: Node tidak punya anak atau hanya punya 1 anak
            if (node.getLlink() == null) return node.getRlink();
            else if (node.getRlink() == null) return node.getLlink();

            // Skenario 3: Node punya 2 anak. 
            // Kita cari node dengan nilai TERBESAR dari cabang KIRI
            BTNode<K,V> maxLeftNode = findMax(node.getLlink());
            
            // Ganti data node saat ini dengan data dari maxLeftNode
            node.setKey(maxLeftNode.getKey());
            node.setData(maxLeftNode.getData());
            
            // Hapus maxLeftNode yang asli dari cabang kiri
            node.setLlink(deleteNode(node.getLlink(), maxLeftNode.getKey()));
        }
        return node;
    }

    public V search(K key) {
        BTNode<K,V> result = find(root, key);
        if (result != null) {
            return result.getData();
        }
        return null;
    }

    public K max() {
        K kunci = null;
        BTNode<K,V> maxNode = findMax(root);
        if(maxNode != null) kunci = maxNode.getKey();
        return kunci;
    }

    public K min() {
        K kunci = null;
        BTNode<K,V> minNode = findMin(root);
        if(minNode != null) kunci = minNode.getKey();
        return kunci;
    }

    private BTNode<K,V> insertNode (BTNode<K,V> node, K k,V data) {
        if (node == null){
            BTNode<K,V> newNode = new BTNode<K,V>(k, data);
            return newNode;
        } else if (k.compareTo(node.getKey())<0) {
            node.setLlink(insertNode(node.getLlink(),k,data));
            return node;
        } else {
            node.setRlink(insertNode(node.getRlink(),k,data));
            return node;
        }
    }

    private BTNode<K,V> find(BTNode<K,V> node, K k) {
        // PERBAIKAN: Gunakan compareTo(k) == 0, BUKAN == k. (Karena == hanya untuk tipe data primitif seperti int biasa, bukan Object)
        if (node == null || node.getKey().compareTo(k) == 0)
            return node;
        else if (node.getKey().compareTo(k) < 0)
            return find(node.getRlink(), k);
        else
            return find(node.getLlink(), k);
    }

    private BTNode<K,V> findMin(BTNode<K,V> node) {
        if (node == null) return null;
        while (node.getLlink() != null) { 
            node = node.getLlink();
        }
        return node;
    } 

    private BTNode<K,V> findMax(BTNode<K,V> node) {
        if (node == null) return null;
        while (node.getRlink() != null) { 
            node = node.getRlink();
        }
        return node;
    }
    
    // Pemanggilan Traversal dari class Induk (BinaryTree)
    public void inOrder() { printInOrder(root); }
    public void levelOrder() { printLevelOrder(root); }
    public void preOrder() { printPreOrder(root); }
    public void postOrder() { printPostOrder(root); }

    public K getKey(BTNode<K,V> node) { return node.getKey(); }
    public V getData(BTNode<K,V> node,K keyt) { return node.getData(); }
}