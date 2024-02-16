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

    public LinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    public void printList() {
        StringBuilder result = new StringBuilder();
        if (length > 0) {
            Node temp = head;
            result.append(head.value);
            while (temp.next != null) {
                result.append(" -> " + temp.next.value);
                temp = temp.next;
            }
        }
        System.out.println(result);

    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length != 0) {
            tail.next = newNode;
            tail = newNode;
        } else {
            head = newNode;
            tail = newNode;
        }
        length += 1;
    }

    public void prepend(Integer value) {
        Node temp = head;
        head = new Node(value);
        head.next = temp;
        length++;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) return null;
        int i = 0;
        Node currentNode = head;
        while (i++ < index) {
            currentNode = currentNode.next;
        }
        return currentNode;

    }

    public boolean set(int index, int value) {
       Node temp = get(index);
       if (temp != null){
           temp.value = value;
           return true;
       }
       return false;
    }

    public Integer popLeft() {
        if (head != null) {
            Node left = head;
            head = head.next;
            length--;
            if (length == 0) tail = null;
            return left.value;
        }
        return null;
    }

    public Integer pop() {
        Node temp = head;
        Node pre = head;
        if (length == 0) return null;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp.value;
    }

    public Integer getHead() {
        return (head != null) ? head.value : null;
    }

    public Integer getTail() {
        return (tail != null) ? tail.value : null;
    }


}
