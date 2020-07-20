package lesson8;

import java.util.Objects;

public class HashCat {
    public static class Item {
        int data;

        public Item(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Item item = (Item) o;
            return data == item.data;
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }
    }

    private StackChane[] hashArray;
    private int arrSize;
    private Item nullItem;

    public HashCat(int capacity) {
        this.hashArray = new StackChane[capacity];
        this.arrSize = capacity;
        this.nullItem = new Item(-1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrSize; i++) {
            sb.append("hash index " + i + ": ");
            if (hashArray[i] == null)
                sb.append("simple null yet" + "\n");
            else
                sb.append(hashArray[i].toString() + "\n");
        }
        return sb.toString();
    }

    private int hashFunc(int key) {
        return key % arrSize;
    }

    public void insert(Item item) {
        int key = item.getData();
        int hashVal = hashFunc(key);

        if (hashArray[hashVal] == null) {
            StackChane chane = new StackChane(5);
            hashArray[hashVal] = chane;
        }
        hashArray[hashVal].push(key);
    }
}
