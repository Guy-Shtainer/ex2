/**
 * FibonacciHeap
 * <p>
 * An implementation of a Fibonacci Heap over integers.
 */
public class FibonacciHeap {

    private HeapNode min;
    private HeapNode first;
    private int size;
    private static int Links;
    private static int Cuts;



    /**
     * public boolean isEmpty()
     * <p>
     * Returns true if and only if the heap is empty.
     * זה אומר שגודל הערימה הוא אפס והשדות ראשון, אחרון, מינימום מצביעים לנאל
     */
    public boolean isEmpty() {
        return this.first == null;
    }

    /**
     * public HeapNode insert(int key)
     * <p>
     * Creates a node (of type HeapNode) which contains the given key, and inserts it into the heap.
     * The added key is assumed not to already belong to the heap.
     * <p>
     * Returns the newly created node.
     */
    public HeapNode insert(int key) {
        HeapNode node = new HeapNode(key);
        FibonacciHeap singleNodeHeap = new FibonacciHeap();
        singleNodeHeap.first = node;
        singleNodeHeap.min = node;
        node.setNext(node);
        node.setPrev(node);
        singleNodeHeap.meld(this);
        this.first = singleNodeHeap.first;
        this.min = singleNodeHeap.min;
        return this.first;
    }

    /**
     * public void deleteMin()
     * <p>
     * Deletes the node containing the minimum key.
     */
    public void deleteMin() {
        return; // should be replaced by student code

    }

    /**
     * public HeapNode findMin()
     * <p>
     * Returns the node of the heap whose key is minimal, or null if the heap is empty.
     */
    public HeapNode findMin() {
        return this.min;
    }

    public void setFirst(HeapNode first) {
        this.first = first;
    }

    /**
     * public void meld (FibonacciHeap heap2)
     * <p>
     * Melds heap2 with the current heap.
     */
    public void meld(FibonacciHeap heap2) {
        HeapNode firstOfThis = this.first;
        HeapNode lastOfThis = this.first.prev;
        HeapNode firstOfHeap2 = heap2.first;
        HeapNode lastOfHeap2 = heap2.first.prev;
        if (this.isEmpty()) {
            this.min = heap2.min;
            this.setFirst(firstOfHeap2);
        }
        else if (!heap2.isEmpty()) {
            lastOfThis.setNext(firstOfHeap2);
            firstOfHeap2.setPrev(lastOfThis);
            lastOfHeap2.setNext(firstOfThis);
            firstOfThis.setPrev(lastOfHeap2);
            if (heap2.min.getKey() < this.min.getKey()) // עדכון מינימום אם צריך
                this.min = heap2.min;
        }
        this.size += heap2.size;
    }

    private void insertAfter(FibonacciHeap heap) {

    }

    /**
     * public int size()
     * <p>
     * Returns the number of elements in the heap.
     */
    public int size() {
        return this.size;
    }

    /**
     * public int[] countersRep()
     * <p>
     * Return an array of counters. The i-th entry contains the number of trees of order i in the heap.
     * Note: The size of of the array depends on the maximum order of a tree, and an empty heap returns an empty array.
     */
    public int[] countersRep() {
        int[] arr = new int[100];
        return arr; //	 to be replaced by student code
    }

    /**
     * public void delete(HeapNode x)
     * <p>
     * Deletes the node x from the heap.
     * It is assumed that x indeed belongs to the heap.
     */
    public void delete(HeapNode x) {
        return; // should be replaced by student code
    }

    /**
     * public void decreaseKey(HeapNode x, int delta)
     * <p>
     * Decreases the key of the node x by a non-negative value delta. The structure of the heap should be updated
     * to reflect this change (for example, the cascading cuts procedure should be applied if needed).
     */
    public void decreaseKey(HeapNode x, int delta) {
        return; // should be replaced by student code
    }

    /**
     * public int potential()
     * <p>
     * This function returns the current potential of the heap, which is:
     * Potential = #trees + 2*#marked
     * <p>
     * In words: The potential equals to the number of trees in the heap
     * plus twice the number of marked nodes in the heap.
     */
    public int potential() {
        return -234; // should be replaced by student code
    }

    /**
     * public static int totalLinks()
     * <p>
     * This static function returns the total number of link operations made during the
     * run-time of the program. A link operation is the operation which gets as input two
     * trees of the same rank, and generates a tree of rank bigger by one, by hanging the
     * tree which has larger value in its root under the other tree.
     */
    public static int totalLinks() {
        return Links;
    }

    /**
     * public static int totalCuts()
     * <p>
     * This static function returns the total number of cut operations made during the
     * run-time of the program. A cut operation is the operation which disconnects a subtree
     * from its parent (during decreaseKey/delete methods).
     */
    public static int totalCuts() {
        return Cuts;
    }

    /**
     * public static int[] kMin(FibonacciHeap H, int k)
     * <p>
     * This static function returns the k smallest elements in a Fibonacci heap that contains a single tree.
     * The function should run in O(k*deg(H)). (deg(H) is the degree of the only tree in H.)
     * <p>
     * ###CRITICAL### : you are NOT allowed to change H.
     */
    public static int[] kMin(FibonacciHeap H, int k) {
        int[] arr = new int[100];
        return arr; // should be replaced by student code
    }


    /**
     * public class HeapNode
     * <p>
     * If you wish to implement classes other than FibonacciHeap
     * (for example HeapNode), do it in this file, not in another file.
     */
    public static class HeapNode {

        public int key;
        private int rank;
        private boolean mark;
        private HeapNode child;
        private HeapNode prev;
        private HeapNode next;
        private HeapNode parent;

        public HeapNode(int key) {
            this.key = key;
            this.prev = this;
            this.next = this;
        }

        public int getKey() {
            return this.key;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public void setMark(boolean mark) {
            this.mark = mark;
        }

        public void setChild(HeapNode child) {
            this.child = child;
        }

        public void setPrev(HeapNode prev) {
            this.prev = prev;
        }

        public void setNext(HeapNode next) {
            this.next = next;
        }

        public void setParent(HeapNode parent) {
            this.parent = parent;
        }
    }
}
