package com.datastruct.TM05;
import com.datastruct.Utils.BTNode;
import com.datastruct.Utils.MyLinearList;

public class BinaryTree<K,V>
{
    // In-Order: Kiri -> Cetak -> Kanan
    public void printInOrder(BTNode<K,V> node) {
        if(node == null) return;
        printInOrder(node.getLlink());
        System.out.print(node.getKey() + ":" + node.getData() + " ");
        printInOrder(node.getRlink());
    }

    // Post-Order: Kiri -> Kanan -> Cetak
    public void printPostOrder(BTNode<K,V> node) {
        if(node == null) return;
        printPostOrder(node.getLlink());
        printPostOrder(node.getRlink());
        System.out.print(node.getKey() + ":" + node.getData() + " ");
    }

    // Pre-Order: Cetak -> Kiri -> Kanan
    public void printPreOrder(BTNode<K,V> node) {
        if(node == null) return;
        System.out.print(node.getKey() + ":" + node.getData() + " ");
        printPreOrder(node.getLlink());
        printPreOrder(node.getRlink());
    }

    private void printLevelOrderRec(MyLinearList<BTNode<K,V>> q) {
        if(q.isEmpty()) {
            return; // Berhenti jika antrean kosong
        }
        
        BTNode<K,V> node = q.remove(); // Keluarkan node paling depan dari antrean
        
        // Cetak key dan data dari node tersebut
        System.out.print(node.getKey() + ":" + node.getData() + " ");
        
        // Jika ada anak kiri, masukkan ke antrean
        if(node.getLlink() != null) {
            q.pushQ(node.getLlink());
        }
        // Jika ada anak kanan, masukkan ke antrean
        if(node.getRlink() != null) {
            q.pushQ(node.getRlink());
        }
        
        // Panggil dirinya sendiri untuk memproses node selanjutnya di antrean
        printLevelOrderRec(q);
    }

    public void printLevelOrder(BTNode<K,V> node) {
        if (node == null) return; // Mencegah error jika tree masih kosong
        
        MyLinearList<BTNode<K,V>> q = new MyLinearList<BTNode<K,V>>();
        q.pushQ(node); // Masukkan root ke dalam antrean pertama kali
        printLevelOrderRec(q); // Jalankan perulangan rekursif
    }
}