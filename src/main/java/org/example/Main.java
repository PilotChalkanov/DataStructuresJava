package org.example;


import hashtable.HashTable;

public class Main {
    public static void main(String[] args) {

        HashTable myHashTable = new HashTable();
        myHashTable.set("nails", 10);
        myHashTable.set("nails", 120);
        myHashTable.set("fax", 100);
        myHashTable.set("brother", 5);
        myHashTable.set("gutter", 7);
        myHashTable.set("albano", 1);
        myHashTable.set("germano", 1);
        myHashTable.set("mexicano", 1);
        myHashTable.set("test1", 1);
        myHashTable.set("test2", 1);
        myHashTable.set("test3", 1);
        myHashTable.set("test4", 1);
        myHashTable.set("test5", 1);
        System.out.println(myHashTable.get("nails"));
        System.out.println(myHashTable.get("mexicano"));


    }
}