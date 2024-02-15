package org.example;


import hashtable.HashTable;
import linkedlist.LinkedList;

public class Main {
    public static void main(String[] args) {

        HashTable myHashTable = new HashTable();
        myHashTable.set("nails", 10);
        myHashTable.set("nails", 120);
        myHashTable.set("fax", 100);
        myHashTable.set("brother", 5);
        myHashTable.set("gutter", 7);
        myHashTable.set("albano", 1);
        System.out.println(myHashTable.get("nails"));
        System.out.println(myHashTable.get("gutter"));
        System.out.println(myHashTable.get("brother"));

        LinkedList myLinkedList = new LinkedList(3);
        myLinkedList.append(4);
        myLinkedList.append(4);
        myLinkedList.append(4);
        myLinkedList.printList();

    }
}