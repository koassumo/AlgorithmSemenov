package lesson3;

public class Main3 {

    public static void main(String[] args) {
        System.out.println("Задание 1");
        String stroka = "Алгоритмы и структуры данных";
        System.out.println(stroka);
        Stack stackStroka = new Stack(200);

        for (int i = 0; i < stroka.length(); i++) {
            char sign = stroka.charAt(i);
            stackStroka.push(sign);
        }

        for (int i = 0; i < stroka.length(); i++) {
            System.out.print(stackStroka.pop());
        }

        System.out.println();
        System.out.println("Задание 2");
        Deque deque = new Deque(5);
        deque.insertTail(0);
        deque.insertTail(1);
        deque.insertTail(2);
        deque.removeHead();
        deque.insertTail(3);
        deque.removeHead();
        deque.insertTail(4);
        deque.removeHead();
        deque.insertTail(5);
        deque.insertTail(6);
        deque.removeTail();
        deque.removeTail();
        deque.removeTail();

        deque.printDeque();
    }

}
