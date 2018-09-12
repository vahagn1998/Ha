package hoffman;

import java.util.Objects;

public class Tree<T extends Comparable<T>, U> {
    private Node<T, U> root;

    public static class Node<T, U> {
        Node<T, U> left;
        Node<T, U> right;
        private U value;
        private T key;

        public Node(T key, U value) {
            this.value = value;
            this.key = key;
        }

        public U getValue() {
            return value;
        }

        public void setValue(U value) {
            this.value = value;
        }

        public T getKey() {
            return key;
        }

        public void setKey(T key) {
            this.key = key;
        }
    }

    public U fing(T key) {
        Node<T, U> current = root;
        while (current != null) {
            int compare = current.key.compareTo(key);
            if (compare == 0) {
                return current.value;
            } else if (compare < 0) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return null;
    }

    public boolean put(T key, U value) {
        if (root != null) {
            Node<T, U> current = root;
            Node<T, U> parent = root;
            boolean isLeft = false;
            while (current != null) {
                parent = current;
                int compare = current.key.compareTo(key);
                if (compare == 0) {
                    return false;
                } else if (compare < 0) {
                    current = current.right;
                    isLeft = false;
                } else {
                    current = current.left;
                    isLeft = true;
                }
            }
            if(isLeft) {
                parent.left = new Node<>(key, value);
            } else {
                parent.right = new Node<>(key, value);
            }
        } else {
            root = new Node<>(key, value);
        }
        return true;
    }
}
