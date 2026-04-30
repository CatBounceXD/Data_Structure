interface Tree<K, V> 
{
    void insert(K key, V data);
    void delete(K key);
}

class BTNode<K, V> 
{
    private K key;
    private V data;
    private BTNode<K, V> llink;
    private BTNode<K, V> rlink;

    public BTNode(K key, V data) 
    {
        this.key = key;
        this.data = data;
        this.llink = null;
        this.rlink = null;
    }

    public K getKey() 
    {
        return key;
    }

    public void setKey(K key) 
    {
        this.key = key;
    }

    public V getData() 
    {
        return data;
    }

    public void setData(V data) 
    {
        this.data = data;
    }

    public BTNode<K, V> getLlink() 
    {
        return llink;
    }

    public void setLlink(BTNode<K, V> llink)
    {
        this.llink = llink;
    }

    public BTNode<K, V> getRlink() 
    {
        return rlink;
    }

    public void setRlink(BTNode<K, V> rlink) 
    {
        this.rlink = rlink;
    }
}

class BinaryTree<K, V> 
{
    public void printInOrder(BTNode<K, V> node) 
    {
        if (node != null) 
        {
            printInOrder(node.getLlink());
            System.out.print(node.getKey() + " ");
            printInOrder(node.getRlink());
        }
    }

    public void printPreOrder(BTNode<K, V> node) 
    {
        if (node != null) 
        {
            System.out.print(node.getKey() + " ");
            printPreOrder(node.getLlink());
            printPreOrder(node.getRlink());
        }
    }

    public void printPostOrder(BTNode<K, V> node) 
    {
        if (node != null) 
        {
            printPostOrder(node.getLlink());
            printPostOrder(node.getRlink());
            System.out.print(node.getKey() + " ");
        }
    }
}

class BinarySearchTree<K extends Comparable<K>, V>
        extends BinaryTree<K, V>
        implements Tree<K, V> 
{

    private BTNode<K, V> root;

    public BinarySearchTree() 
    {
        root = null;
    }

    public BTNode<K, V> getRoot() 
    {
        return root;
    }

    @Override
    public void insert(K key, V data) 
    {
        root = insertNode(root, key, data);
    }

    private BTNode<K, V> insertNode(BTNode<K, V> node, K key, V data) 
    {
        if (node == null) 
        {
            return new BTNode<>(key, data);
        }

        if (key.compareTo(node.getKey()) < 0) 
        {
            node.setLlink(insertNode(node.getLlink(), key, data));
        } else if (key.compareTo(node.getKey()) > 0) 
        {
            node.setRlink(insertNode(node.getRlink(), key, data));
        }

        return node;
    }

    @Override
    public void delete(K key) 
    {
        root = deleteNode(root, key);
    }

    private BTNode<K, V> deleteNode(BTNode<K, V> node, K key) 
    {
        if (node == null) return null;

        if (key.compareTo(node.getKey()) < 0) 
        {
            node.setLlink(deleteNode(node.getLlink(), key));
        } 
        else if (key.compareTo(node.getKey()) > 0) 
        {
            node.setRlink(deleteNode(node.getRlink(), key));
        } 
        else 
        {
            if (node.getLlink() == null)
                return node.getRlink();
            else if (node.getRlink() == null)
                return node.getLlink();

            BTNode<K, V> minNode = findMin(node.getRlink());
            node.setKey(minNode.getKey());
            node.setData(minNode.getData());

            node.setRlink(deleteNode(node.getRlink(), minNode.getKey()));
        }

        return node;
    }

    private BTNode<K, V> findMin(BTNode<K, V> node) 
    {
        while (node.getLlink() != null) 
        {
            node = node.getLlink();
        }
        return node;
    }
}

public class BST 
{
    public static void main(String[] args) 
    {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();

        int[] keys = {27, 54, 13, 24, 40, 56, 77, 33, 12, 85, 73, 10, 3, 15, 22};

        for (int key : keys) 
        {
            bst.insert(key, "Data" + key);
        }

        System.out.println("BST InOrder Awal:");
        bst.printInOrder(bst.getRoot());

        bst.delete(33);
        System.out.println("\n\nSetelah delete 33:");
        bst.printInOrder(bst.getRoot());

        bst.delete(56);
        System.out.println("\n\nSetelah delete 56:");
        bst.printInOrder(bst.getRoot());

        bst.delete(27);
        System.out.println("\n\nSetelah delete 27:");
        bst.printInOrder(bst.getRoot());
    }
}