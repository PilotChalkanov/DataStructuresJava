package linkedlist;
public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;

    }

    public void printList() {
        StringBuilder result = new StringBuilder();
        Node temp = head;
        result.append(head.value);
        while (temp.next != null) {
            result.append(" -> " + temp.next.value);
            temp = temp.next;
        }
        System.out.println(result);
    }

    public void append(int value){
        Node newNode = new Node(value);
        if (length != 0) {
            tail.next = newNode;
            tail = newNode;
        }
        else {
            head = newNode;
            tail = newNode;
        }
        length += 1;
    }

    public void getHead(){
        System.out.println(head);
    }
    public void getTail(){
        System.out.println(tail);
    }

    class Node {
        int value;
        Node next;

        Node(int v) {
            this.value = v;
            this.next = null;
        }
    }
}
