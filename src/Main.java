public class Main {


    public static void main(String[] args) {

        int number = 15;
        int stepen = 7;
        int result = number;
        for (int i = 1; i < stepen; i++) {
            result *= number;
        }
        System.out.println("Задача 1.1. Число " + number + " в степени " + stepen + " = " + result);

        int ostatok = stepen % 2;
        int middleLoop = (stepen - ostatok) / 2;
        result = number;
        for (int i = 1; i < middleLoop; i++) {
            result *= number;
        }
        result *= result;
        if (ostatok == 1) result *= number;
        System.out.println("Задача 1.2. Число " + number + " в степени " + stepen + " (используя четность) = " + result);

        int [] array = {15, 12, 3};
        int min = array [0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) min = array[i];
        }
        System.out.println("Задача 2. Минимум в массиве = " + min);

        long average = 0;
        for (int i = 0; i < array.length; i++) {
            average += array[i];
        }
        average /= array.length;
        System.out.println("Задача 3. Среднее арифмитическое = " + average);
    }
}
