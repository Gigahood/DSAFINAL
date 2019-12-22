/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure;

/**
 *
 * @author Kuek Yong Boon
 */
public class BinaryBucket<K extends Comparable<K>, V> implements Bucket<K, V> {

    private Node root;
    private int size;

    public BinaryBucket() {
        this.root = null;
        this.size = 0;
    }

    public BinaryBucket(K key, V value) {
        this.root = new Node(key, value);
    }

    @Override
    public V add(K key, V value) {
        V result = null;

        if (isEmpty()) {
            root = new Node(key, value);
            size++;
        } else {
            result = (V) addEntry(root, key, value);
        }

        return result;
    }

    private V addEntry(Node<K, V> rootNode, K key, V value) {
        V result = null;
        int comparison = key.compareTo(((K) rootNode.getKey()));

        if (key.hashCode() == rootNode.getKey().hashCode()) {						// newEntry matches entry in root
            result = rootNode.getValue();
            rootNode.setKey(key);
        } else if (key.hashCode() < rootNode.getKey().hashCode()) {				// newEntry < entry in root
            if (rootNode.getPrevious() != null) {
                result = (V) addEntry(rootNode.getPrevious(), key, value);
            } else {
                rootNode.setPrevious(new Node(key, value));
                size++;
            }
        } else {														// newEntry > entry in root
            if (rootNode.getNext() != null) {
                result = (V) addEntry(rootNode.getNext(), key, value);
            } else {
                rootNode.setNext(new Node(key, value));
                size++;
            }
        }
        return result;
    }

    @Override
    public V remove(K key) {
        ReturnObject oldEntry = new ReturnObject(null);

        Node newRoot = removeEntry(root, key, oldEntry);

        root = newRoot;

        return oldEntry.get();
    }

    private Node<K, V> removeEntry(Node<K, V> rootNode, K key, ReturnObject oldEntry) {
        if (rootNode != null) {
            K rootData = rootNode.getKey();
            int comparison = key.compareTo(rootData);

            if (comparison == 0) {      // entry == root entry
                oldEntry.set(rootNode.getValue());
                rootNode = removeFromRoot(rootNode);
            } else if (comparison < 0) {  // entry < root entry
                Node leftChild = rootNode.getPrevious();
                Node subtreeRoot = removeEntry(leftChild, key, oldEntry);
                rootNode.setPrevious(subtreeRoot);
            } else {                      // entry > root entry
                Node rightChild = rootNode.getNext();
                rootNode.setNext(removeEntry(rightChild, key, oldEntry));
            }
        }

        return rootNode;
    }

    /**
     * Task: Removes the entry in a given root node of a subtree.
     *
     * @param rootNode the root node of the subtree
     * @return the root node of the revised subtree
     */
    private Node<K, V> removeFromRoot(Node<K, V> rootNode) {
        // Case 1: rootNode has two children
        if (rootNode.getPrevious() != null && rootNode.getNext() != null) {
            // find node with largest entry in left subtree
            Node leftSubtreeRoot = rootNode.getPrevious();
            Node largestNode = findLargest(leftSubtreeRoot);

            // replace entry in root
            rootNode.setKey((K) largestNode.getKey());
            rootNode.setValue((V) largestNode.getValue());

            // remove node with largest entry in left subtree
            rootNode.setPrevious(removeLargest(leftSubtreeRoot));
        } // end if
        // Case 2: rootNode has at most one child
        else if (rootNode.getNext() != null) {
            rootNode = rootNode.getNext();
        } else {
            rootNode = rootNode.getPrevious();
        }

        // Assertion: if rootNode was a leaf, it is now null
        return rootNode;
    }

    /**
     * Task: Finds the node containing the largest entry in a given tree.
     *
     * @param rootNode the root node of the tree
     * @return the node containing the largest entry in the tree
     */
    private Node<K, V> findLargest(Node<K, V> rootNode) {
        if (rootNode.getNext() != null) {
            rootNode = findLargest(rootNode.getNext());
        }

        return rootNode;
    }

    /**
     * Task: Removes the node containing the largest entry in a given tree.
     *
     * @param rootNode the root node of the tree
     * @return the root node of the revised tree
     */
    private Node<K, V> removeLargest(Node<K, V> rootNode) {
        if (rootNode.getNext() != null) {
            Node<K, V> rightChild = rootNode.getNext();
            Node<K, V> root = removeLargest(rightChild);
            rootNode.setNext(root);
        } else {
            rootNode = rootNode.getPrevious();
        }

        return rootNode;
    }

    @Override
    public boolean containKey(K key) {
        return getValue(key) != null;
    }

    @Override
    public V getValue(K key) {
        return findEntry(root, key);
    }

    private V findEntry(Node rootNode, K key) {
        V result = null;

        if (rootNode != null) {
            K rootEntry = (K) rootNode.getKey();

            if (key.equals(rootEntry)) {
                result = (V) rootNode.getValue();
            } else if (key.compareTo(rootEntry) < 0) {
                result = findEntry(rootNode.getPrevious(), key);
            } else {
                result = findEntry(rootNode.getNext(), key);
            }
        }
        return result;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Node<K, V> get(int index) {
        return findNode(root, index, 0);
    }
    private Node<K,V> findNode(Node rootNode, int index, int counter) {
        Node result = rootNode;
        counter++;
        
        if (counter <= index) {
            if (rootNode.getPrevious() != null) {
                result = findNode(rootNode.getPrevious(), index, counter);
            } else if (rootNode.getNext() != null) {
                result = findNode(rootNode.getNext(), index, counter);
            } else {
                return null;
            }
        }

//        if (rootNode != null) {
//            //K rootEntry = (K) rootNode.getKey();
//            if (counter == index) {
//                result = rootNode;
//            } else if (key.compareTo(rootEntry) < 0) {
//                result = findEntry(rootNode.getPrevious(), key);
//            } else {
//                result = findEntry(rootNode.getNext(), key);
//            }
//        }
        return result;
    }
    

    @Override
    public String toString() {
        String str = "";

        str = printData(root, str);

        return str;
    }

    private String printData(Node<K, V> node, String str) {
        if (node != null) {
            str = printData(node.getPrevious(), str);
            str += (node.getValue() + ", ");
            str = printData(node.getNext(), str);
        }

        return str;
    }

    private class ReturnObject {

        private V item;

        private ReturnObject(V entry) {
            item = entry;
        }

        public V get() {
            return item;
        }

        public void set(V entry) {
            item = entry;
        }
    }

}
