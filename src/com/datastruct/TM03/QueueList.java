package com.datastruct.TM03;

import java.util.ArrayList;
import java.util.List;

public class QueueList 
{

    static class Mobil 
    {
        String id;
        int Arrive;;
        int Dequeue;

        public Mobil(String id, int Arrive) 
        {
            this.id = id;
            this.Arrive = Arrive;
        }
    }

    static class Queues 
    {
        private int maxSize;
        private List<Mobil> list;

        public Queues(int size) 
        {
            maxSize = size;
            list = new ArrayList<>();
        }

        public void enqueue(Mobil m) { list.add(m); }
        public Mobil dequeue() { return list.remove(0); }
        public Mobil peek() { return list.get(0); }
        public boolean isEmpty() { return list.isEmpty(); }
        public boolean isFull() { return list.size() == maxSize; }
        
        // Fungsi untuk cetak daftar nama mobil di Queue
        public String getIsiQueue() 
        {
            if (list.isEmpty()) return "-";
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) 
            {
                sb.append(list.get(i).id);
                if (i < list.size() - 1) sb.append(", ");
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) 
    {
        System.out.println("========== QUEUE SIMULASI ==========\n");
        
        int[] urutan = {2, 5, 8, 9, 11, 12, 23, 24, 28, 35, 45, 48, 50, 55, 60, 999};
        int Cap = 7;
        int Cuci = 12;

        Queues parkir = new Queues(Cap);
        int MesinFree = 0;
        int totalWait = 0;
        int Finished = 0;
        int idCounter = 1;

        System.out.println(String.format("%-6s | %-12s | %-32s | %-13s | %-11s", 
                "Mobil", "Waktu Datang", "Isi Queue (Maks 7)", "Waktu Dequeue", "Lama Tunggu"));
        System.out.println("-------------------------------------------------------------------------------------");

        for (int datang : urutan) 
        {
            if (datang == 999) break; //Sentinelnya
            
            String idMobil = "M" + idCounter++;

            while (!parkir.isEmpty() && parkir.peek().Dequeue <= datang) 
            {
                parkir.dequeue();
            }

            if (!parkir.isFull()) 
            {
                int DequeueTime = Math.max(MesinFree, datang);
                int Tunggu = DequeueTime - datang;

                Mobil m = new Mobil(idMobil, datang);
                m.Dequeue = DequeueTime;

                if (DequeueTime > datang) 
                {
                    parkir.enqueue(m);
                }

                MesinFree = DequeueTime + Cuci;
                totalWait += Tunggu;
                Finished++;

                System.out.println(String.format("%-6s | %-12d | %-32s | %-13d | %-11d",
                        idMobil, datang, parkir.getIsiQueue(), DequeueTime, Tunggu));
            } 
            else 
            {
                System.out.println(String.format("%-6s | %-12d | %-32s | %-13s | %-11s",
                        idMobil, datang, parkir.getIsiQueue(), "-", "Overflow"));
            }
        }
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Total Mobil Selesai  : " + Finished + " Mobil");
        System.out.println("Total Waktu Tunggu   : " + totalWait + " Menit");
        System.out.println("Rata-rata Tunggu     : " + ((double)totalWait / Finished) + " Menit");
    }
}