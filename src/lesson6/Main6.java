
package lesson6;

import lesson4.Cat;

import java.util.Random;

public class Main6 {
    public static void main(String[] args) {
        Tree tree = new Tree();
        int levelNumber = 0;
        Random rand = new Random ();
        while (true) {
            int age = rand.nextInt(200) - 100;
            Cat cat = new Cat(age, "name");
            int temp = tree.insert(cat);
            levelNumber++;
            if (levelNumber == 16) break;
        }
        tree.displayTree();
    }
}

