public class DoublyLinkedList<T extends Comparable<T>> {
    private NodeType<T> head;

    // constructor
    public DoublyLinkedList() {
        this.head = null;
    }

    // insert an item
    public void insertItem(T item) {
        NodeType<T> newNode = new NodeType<T> (item);
        if (this.head == null) {
            this.head = newNode;
        } else {
            NodeType<T> current = head;
            while (current.next != null
            && current.info.compareTo(item) == -1) {
                current = current.next;
            }
            if (current.info.compareTo(item) == -1) {
                current.next = newNode;
                newNode.back = current;
            } else if (current.info.compareTo(item) == 0) {
                System.out.println("Item already exists");
            } else {
                if (current.back != null) {
                    current.back.next = newNode;
                } else {
                    head = newNode;
                }
                newNode.back = current.back;
                current.back = newNode;
                newNode.next = current;
            }
        }
    }

    // delete an item
    public void deleteItem(T item) {
        if (this.head == null) {
            System.out.println("You cannot delete from an empty list");
        } else {
            NodeType<T> current = head;
            while (current != null
            && current.info.compareTo(item) == -1) {
                current = current.next;
            }
            if (current == null || current.info.compareTo(item) != 0) {
                System.out.println("The item is not present in the list");
            } else {
                if (current.back != null) {
                    current.back.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.back = current.back;
                }
            }
            this.print();
            this.printReverse();
        }
    }

    // length
    public int length() {
        int length = 0;
        NodeType<T> current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    // print
    public void print() {
        NodeType<T> current = this.head;
        System.out.print("The list is: ");
        while (current != null) {
            System.out.print(current.info);
            System.out.print(' ');
            current = current.next;
        }
        System.out.println();
    }

    public void printList(String prefix) {
        System.out.print(prefix);
        NodeType<T> current = this.head;
        while (current != null) {
            System.out.print(current.info);
            System.out.print(' ');
            current = current.next;
        }
        System.out.println();
    }

    // printReverse
    public void printReverse() {
        NodeType<T> current = this.head;
        while (current != null && current.next != null) {
            current = current.next;
        }
        System.out.print("The reverse list: ");
        while (current != null) {
            System.out.print(current.info);
            System.out.print(' ');
            current = current.back;
        }
        System.out.println();
    }

    public void reverseList() {
        NodeType<T> current = this.head;
        NodeType<T> temp = null;
        while (current != null) {
            temp = current.back;
            current.back = current.next;
            current.next = temp;
            current = current.back;
        }
        if (temp != null) {
            this.head = temp.back;
        }
    }

    public void deleteSubsection(T lower, T upper) {
        NodeType<T> current = this.head;
        while (current != null && current.info.compareTo(lower) < 0) {
            current = current.next;
        }
        while (current != null && current.info.compareTo(upper) <= 0) {
            NodeType<T> toDelete = current;
            current = current.next;
            if (toDelete.back != null) {
                toDelete.back.next = toDelete.next;
            } else {
                this.head = toDelete.next;
            }
            if (toDelete.next != null) {
                toDelete.next.back = toDelete.back;
            }
        }
    }

    public void swapAlternate() {
        NodeType<T> current = this.head;
        while (current != null && current.next != null) {
            T temp = current.info;
            current.info = current.next.info;
            current.next.info = temp;
            current = current.next.next;
        }
    }
}
