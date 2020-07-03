package lesson2;

import java.lang.reflect.Array;

public class Main2 {

    public static void main(String[] args) {
        int[] arr; // int arr[]
        arr = new int[5];
        int[] arr2 = {1, 2, 3, 4};

        Array a0 = new Array(1, -2, -3, -4, 5);
        System.out.println("Задание 1");
        System.out.println("Первоначальный массив: " + a0);
        a0.deleteItem(2);
        System.out.println("Удален элемент №2: " + a0);

        System.out.println("");
        System.out.println("Задания 2, 3, 4");

        System.out.println("Первоначальный массив: " + a0);
        System.out.print("Сортировка Bubble - O(N) : ");
        a0.sortBubble();
        System.out.print("Сортировка Bubble - O(N/2) : ");
        a0.sortBubbleAdvanced();
        System.out.println("Сортированный массив: " + a0);

    }

    public static class Array {
        private int arr[];
        private int size;
        private boolean isSorted;

        private Array() {
            this.isSorted = false;
        }

        public Array(int capacity) {
            this();
            arr = new int[capacity];
            this.size = 0;
        }

        public Array(int... args) {
            this();
            this.size = args.length;
            this.arr = args;
        }

        public int deleteItem(int index) {
            if (index >= size || index < 0)
                throw new ArrayIndexOutOfBoundsException(index);
            else if (size -1  == 0)
                throw new ArrayIndexOutOfBoundsException(-1);
            else {
                for (int i = index; i < size - 1; i++) {
                    arr[i] = arr[i + 1];
                }
                return arr[--size];
            }
        }

        public int get(int index) {
            if (index >= size || index < 0)
                throw new ArrayIndexOutOfBoundsException(index);
            return arr[index];
        }

        public void set (int index, int value) {
            if (index >= size || index < 0)
                throw new ArrayIndexOutOfBoundsException(index);
            arr[index] = value;
        }

        public int length() {
            return size;
        }

        private void increaseCapacity() {
            int[] temp = arr;
            arr = new int[size * 2];
            System.arraycopy(temp, 0, arr, 0, size);
        }

        public void append(int value) {
            if (size >= arr.length) {
                increaseCapacity();
            }
            arr[size++] = value;
            isSorted = false;
        }

        public int deleteLast() {
            if (size == 0)
                throw new ArrayIndexOutOfBoundsException(-1);

            return arr[--size];
        }

        // homework
        // insert(index, value);
        // delete(val);
        // delete(index);
        // deleteAll();

        @Override
        public String toString() {
            if (arr == null) return "null";
            int iMax = size - 1;
            if (iMax == -1) return "[]";

            StringBuilder b = new StringBuilder();
            b.append('[');
            int i = 0;
            while (true) {
                b.append(arr[i]);
                if (i == iMax)
                    return b.append(']').toString();
                b.append(", ");
                i++;
            }
        }

        public int find(int value) {
            for (int i = 0; i < size; i++) {
                if (arr[i] == value)
                    return i;
            }
            return -1;
        }

        public boolean hasValue(int value) {
            if (!isSorted)
                throw new RuntimeException("try the 'find' method");

            int l = 0;
            int r = size;
            int m;
            while (l < r) {
                m = (l + r) >> 1; // (l + r) / 2
                if (value == arr[m])
                    return true;
                else if (value < arr[m])
                    r = m;
                else
                    l = m + 1;
            }
            return false;
        }

        private void swap(int a, int b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }

        public void sortBubble() {
            int step = 0;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size - 1; j++) {
                    step++;
                    if (arr[j] > arr[j + 1])
                        swap(j, j + 1);
                }
            }
            isSorted = true;
            System.out.println("количество итераций = " + step);
        }


        public void sortBubbleAdvanced() {
            int step = 0;
            for (int i = size; i >= 0; i--) {
                for (int j = 0; j < i - 1; j++) {
                    step++;
                    if (arr[j] > arr[j + 1])
                        swap(j, j + 1);
                }
            }
            isSorted = true;
            System.out.println("количество итераций = " + step);
        }


        public void sortSelect() {
            for (int flag = 0; flag < size; flag++) {
                int cMin = flag;
                for (int rem = flag + 1; rem < size; rem++)
                    if (arr[rem] < arr[cMin])
                        cMin = rem;
                swap(flag, cMin);
            }
            isSorted = true;
        }

        public void sortInsert() {
            for (int out = 0; out < size; out++) {
                int temp = arr[out];
                int in = out;
                while (in > 0 && arr[in - 1] >= temp) {
                    arr[in] = arr[in - 1];
                    in--;
                }
                arr[in] = temp;
            }
            isSorted = true;
        }
    }

}
