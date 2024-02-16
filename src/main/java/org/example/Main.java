package org.example;


import hashtable.HashTable;
import linkedlist.LinkedList;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {


        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        System.out.println(myLinkedList.set(0, -2));
        myLinkedList.printList();
//        System.out.println(myLinkedList.get(0).value);
        System.out.println(myLinkedList.get(1).value);
//        System.out.println(myLinkedList.popLeft());
//        System.out.println(myLinkedList.popLeft());
//        System.out.println(myLinkedList.popLeft());
//        System.out.println(myLinkedList.popLeft());
//        System.out.println(myLinkedList.popLeft());
        myLinkedList.printList();

//        LinkedList myNewList = new LinkedList();
//        myNewList.prepend(1);
//        myNewList.printList();
//        Integer item = myNewList.popLeft();
//        System.out.println(item);

    }
}