import com.datastruct.Bst.*;

public class HuffmanCoding {
    public static void main(String[] args) {
        char[] charArray = {'E', 'T', 'N', 'I', 'S'};
        int[] charfreq = {29,10,9,5,4};

        Heap<Integer, HuffmanNode> pq = new Heap<>(charArray.length, true);
        for (int i = 0; i < charArray.length; i++) {
            pq.add(charfreq[i], new HuffmanNode(charfreq[i], charArray[i], null, null));
        }
        pq.buildHeap();
        pq.display();
        //
    }
}
