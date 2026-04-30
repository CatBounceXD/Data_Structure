package com.datastruct.Bst;

public class HashTableLengkap {
    private int[] table;
    private int size;

    // Constructor
    public HashTableLengkap(int size) {
        this.size = size;
        table = new int[size];
    }

    // Method untuk mengosongkan tabel (diisi -1) sebelum mencoba metode lain
    public void resetTable() {
        for (int i = 0; i < size; i++) {
            table[i] = -1;
        }
    }

    // 1. Method Linear Probing (Menggunakan aturan mundur / Key - 1 sesuai PPT)
    public void insertLinear(int key) {
        int index = key % size;
        
        // Selama slot penuh, geser ke kiri (index - 1)
        while (table[index] != -1) {
            index = (index - 1 + size) % size; // + size agar tidak negatif saat di-modulo
        }
        table[index] = key;
    }

    // 2. Method Quadratic Probing (Lompat kuadrat: +1^2, +2^2, +3^2, dst)
    public void insertQuadratic(int key) {
        int baseIndex = key % size; // Simpan indeks awal
        int index = baseIndex;
        int i = 1; // Counter untuk kuadrat

        // Selama slot penuh, lakukan lompatan kuadrat dari indeks awal
        while (table[index] != -1) {
            index = (baseIndex + (i * i)) % size;
            i++;
        }
        table[index] = key;
    }

    // 3. Method Double Hashing (H2(key) = 1 + (key mod 7))
    public void insertDoubleHashing(int key) {
        int baseIndex = key % size;
        
        // Rumus fungsi hash kedua sesuai soal
        int stepSize = 1 + (key % 7); 
        
        int index = baseIndex;
        int i = 1; // Counter untuk pengali stepSize

        // Selama slot penuh, lompat sejauh (i * stepSize)
        while (table[index] != -1) {
            index = (baseIndex + (i * stepSize)) % size;
            i++;
        }
        table[index] = key;
    }

    // Method untuk mencetak isi tabel
    public void displayTable(String metode) {
        System.out.println("=== Hasil " + metode + " ===");
        for (int i = 0; i < size; i++) {
            if (table[i] == -1) {
                System.out.println("Slot [" + i + "]: Kosong");
            } else {
                System.out.println("Slot [" + i + "]: " + table[i]);
            }
        }
        System.out.println();
    }

    // Main method untuk menjalankan program
    public static void main(String[] args) {
        int[] data = {4371, 1323, 6173, 4199, 4344, 9679, 1989};
        int tableSize = 10;

        HashTableLengkap ht = new HashTableLengkap(tableSize);

        // --- Eksekusi 1: Linear Probing ---
        ht.resetTable();
        for (int key : data) {
            ht.insertLinear(key);
        }
        ht.displayTable("Linear Probing (Key - 1)");

        // --- Eksekusi 2: Quadratic Probing ---
        ht.resetTable();
        for (int key : data) {
            ht.insertQuadratic(key);
        }
        ht.displayTable("Quadratic Probing");

        // --- Eksekusi 3: Double Hashing ---
        ht.resetTable();
        for (int key : data) {
            ht.insertDoubleHashing(key);
        }
        ht.displayTable("Double Hashing (H2 = 1 + key mod 7)");
    }
}
