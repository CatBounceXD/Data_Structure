package com.datastruct.TM07;

import com.datastruct.TM06.Heap;
import com.datastruct.Utils.BTNode;

public class HuffmanCoding {
    public static void main(String[] args) {
        char[] charArray = {'E', 'T', 'N', 'I', 'S'};
        int[] charfreq = {29,10,9,5,4};

        // true = Min-Heap (Yang terkecil selalu di atas)
        Heap<Integer, HuffmanNode> pq = new Heap<>(charArray.length, true); 
        
        for (int i = 0; i < charArray.length; i++) {
            pq.add(charfreq[i], new HuffmanNode(charfreq[i], charArray[i], null, null));
        }
        pq.buildHeap();
        
        System.out.println("Kondisi Heap Awal (Hanya frekuensi huruf):");
        pq.display();
        System.out.println("\n");

        // --- MELENGKAPI LOGIKA HUFFMAN ---
        // Selama masih ada lebih dari 1 node di dalam antrean
        while (pq.size() > 1) {
            // 1. Ambil 2 node dengan frekuensi paling kecil dari Heap
            BTNode<Integer, HuffmanNode> node1 = pq.removeFirst();
            BTNode<Integer, HuffmanNode> node2 = pq.removeFirst();

            HuffmanNode left = node1.getData();
            HuffmanNode right = node2.getData();

            // 2. Gabungkan frekuensinya
            int sumFreq = node1.getKey() + node2.getKey();
            
            // 3. Buat node induk baru (kita beri karakter '-' sebagai penanda induk kosong)
            HuffmanNode parent = new HuffmanNode(sumFreq, '-', left, right);
            
            // 4. Masukkan kembali node gabungan tersebut ke dalam Heap
            pq.insert(sumFreq, parent);
        }

        // Setelah loop selesai, hanya tersisa 1 node di Heap, yaitu Root / Puncak Pohon
        BTNode<Integer, HuffmanNode> rootNode = pq.removeFirst();
        HuffmanNode root = rootNode.getData();

        System.out.println("Kode Huffman yang dihasilkan:");
        root.getHuffmanCodes(root, 10);
    }
}