public class NodeType<T extends Comparable<T>> {
    public T info;
    public NodeType<T> next;
    public NodeType<T> back;

    // Constructor
    public NodeType(T info) {
        this.info = info;
        this.next = null;
        this.back = null;
    }

    // Constructor with next and back
    public NodeType(T info, NodeType<T> next, NodeType<T> back) {
        this.info = info;
        this.next = next;
        this.back = back;
    }
}
