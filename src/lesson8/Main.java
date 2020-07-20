package lesson8;

import lesson8.HashCat.Item;

public class Main {

    public static void main(String[] args) {
        HashCat hashTable = new HashCat(10);
        hashTable.insert(new Item(11));
        hashTable.insert(new Item(21));
        hashTable.insert(new Item(33));
        hashTable.insert(new Item(75));
        hashTable.insert(new Item(44));
        hashTable.insert(new Item(55));
        hashTable.insert(new Item(36));
        hashTable.insert(new Item(27));
        System.out.println(hashTable.toString());
    }
}


