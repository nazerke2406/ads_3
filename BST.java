import java.util.Iterator;
import java.util.Stack;

// Binary Search Tree without recursion
public class BST<K extends Comparable<K>, V> implements Iterable<K> {

    private class Node {
        private K key;
        private V val;
        private Node left;
        private Node right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node root;
    private int size;

    // Insert key-value pair (iterative)
    public void put(K key, V val) {
        Node newNode = new Node(key, val);
        if (root == null) {
            root = newNode;
            size++;
            return;
        }

        Node current = root;
        while (true) {
            int cmp = key.compareTo(current.key);

            if (cmp < 0) {
                if (current.left == null) {
                    current.left = newNode;
                    size++;
                    return;
                }
                current = current.left;
            } else if (cmp > 0) {
                if (current.right == null) {
                    current.right = newNode;
                    size++;
                    return;
                }
                current = current.right;
            } else {
                current.val = val; // Update if key already exists
                return;
            }
        }
    }

    // Get value by key (already iterative)
    public V get(K key) {
        Node current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);

            if (cmp < 0) {
                current = current.left;
            } else if (cmp > 0) {
                current = current.right;
            } else {
                return current.val;
            }
        }
        return null;
    }

    // Delete key (iterative version)
    public void delete(K key) {
        Node parent = null;
        Node current = root;

        while (current != null && !current.key.equals(key)) {
            parent = current;
            int cmp = key.compareTo(current.key);
            if (cmp < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (current == null) return; // Key not found

        // Case 1: Node with only one child or no child
        if (current.left == null || current.right == null) {
            Node child = (current.left != null) ? current.left : current.right;

            if (parent == null) {
                root = child;
            } else if (parent.left == current) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            size--;
        }
        // Case 2: Node with two children
        else {
            Node successorParent = current;
            Node successor = current.right;

            // Find successor (smallest in right subtree)
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            // Copy successor's data to current node
            current.key = successor.key;
            current.val = successor.val;

            // Delete successor
            if (successorParent.left == successor) {
                successorParent.left = successor.right;
            } else {
                successorParent.right = successor.right;
            }
            size--;
        }
    }

    // Size of the tree
    public int size() {
        return size;
    }

    // In-order iterator without recursion
    @Override
    public Iterator<K> iterator() {
        return new BSTKeyIterator();
    }

    private class BSTKeyIterator implements Iterator<K> {
        private Stack<Node> stack;

        public BSTKeyIterator() {
            stack = new Stack<>();
            pushLeft(root);
        }

        private void pushLeft(Node node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public K next() {
            Node node = stack.pop();
            if (node.right != null) {
                pushLeft(node.right);
            }
            return node.key;
        }
    }
}
