/**
 * Class to hold the node for the doubly linked list.
 */
public class NodeType<T extends Comparable<T>> {
    public T info;
    public NodeType<T> next;
    public NodeType<T> back;

    /**
     * Constructs a new NodeType object with no next or back.
     * @param info the information for the node to hold
     */
    public NodeType(T info) {
        this.info = info;
        this.next = null;
        this.back = null;
    }

    /**
     * Constructs a new NodeType object with a defined next and back.
     * @param info the information for the node to hold
     * @param next the next node
     * @param back the previous node
     */
    public NodeType(T info, NodeType<T> next, NodeType<T> back) {
        this.info = info;
        this.next = next;
        this.back = back;
    }
}
