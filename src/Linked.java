public class Linked<T> {
    private Node<T> first;
    private int width;
    private int height;

    public Linked(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void add(T object) {
        Node<T> node = new Node<>(object);
        if (isEmpty()) {
            first = node;
            return;
        }
        int i = 1;
        int j = 1;
        Node<T> current = first;
        while (current.bottom != null && j < height) {
            current = current.bottom;
            j++;
        }
        Node<T> currentFirstElementInRow = current;
        while (current.next != null && i < width) {
            current = current.next;
            i++;
        }
        if(i < width) {
            current.next = node;
            if (current.top != null) {
                current.top.next.bottom = node;
                node.top = current.top.next;
            }
            node.prev = current;
        } else if (j < height) {
            currentFirstElementInRow.bottom = node;
            node.top = currentFirstElementInRow;
        }
    }

    public T find(int x, int y) {
        if (isEmpty() || x > width || y > height) {
            return null;
        }
        int i;
        int j;
        Node<T> current = first;
        for (j = 1; j < y; j++) {
            current = current.bottom;
            if (current == null) {
                return null;
            }
        }
        for (i = 1; i < x; i++) {
            current = current.next;
            if (current == null) {
                return null;
            }
        }
        return current.object;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public class Node<T> {
        T object;
        Node<T> next;
        Node<T> prev;
        Node<T> top;
        Node<T> bottom;

        public Node(T object) {
            this.object = object;
        }

        public T getObject() {
            return object;
        }

        public void setObject(T object) {
            this.object = object;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }
    }
}
