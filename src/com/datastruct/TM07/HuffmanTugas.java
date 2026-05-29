package com.datastruct.TM07;
import com.datastruct.TM06.Heap;
import com.datastruct.Utils.BTNode;

public class HuffmanTugas {
    public static void main(String[] args) {
        char[] charArray = {'A', 'I', 'M', 'O', 'T', 'F', 'K', 'N', 'R'};
        int[] charfreq = {45, 35, 29, 19, 4, 8, 15, 10, 5};

        Heap<Integer, HuffmanNode> pq = new Heap<>(charArray.length, true); 
        
        for (int i = 0; i < charArray.length; i++) {
            pq.add(charfreq[i], new HuffmanNode(charfreq[i], charArray[i], null, null));
        }
        pq.buildHeap();

        System.out.println("=== PROSES PEMBUATAN HUFFMAN TREE ===");
        System.out.println("Kondisi Heap Awal:");
        pq.display();
        System.out.println("\n");

        while (pq.size() > 1) {
            BTNode<Integer, HuffmanNode> node1 = pq.removeFirst();
            BTNode<Integer, HuffmanNode> node2 = pq.removeFirst();

            HuffmanNode left = node1.getData();
            HuffmanNode right = node2.getData();
            int sumFreq = node1.getKey() + node2.getKey();
            HuffmanNode parent = new HuffmanNode(sumFreq, '-', left, right);
            pq.insert(sumFreq, parent);
        }

        BTNode<Integer, HuffmanNode> rootNode = pq.removeFirst();
        HuffmanNode root = rootNode.getData();

        System.out.println("=== HASIL AKHIR KODE HUFFMAN ===");
        root.getHuffmanCodes(root, 20); 
    }
}

/*
    
 */