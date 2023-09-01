package LinkedList;

public class partitionList {

    public static Node partition(Node head, int x) {
        Node current = head;
        Node large = new Node(0);
        Node small = new Node(0);

        Node largePtr = large;
        Node smallPtr = small;

        while (current != null) {
            if (current.data < x) {
                smallPtr.next = current;
                smallPtr = smallPtr.next;
            } else {
                largePtr.next = current;
                largePtr = largePtr.next;
            }
            current = current.next;
        }
        smallPtr.next = large.next;
        largePtr.next = null;
        return small.next;
    }
}

class Node {
    Node next;
    int data;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
