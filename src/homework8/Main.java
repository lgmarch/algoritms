package homework8;

import java.util.Random;

public class Main {
    private static final int numCats = 30;
    private static final int numLinkedList = 10;

    public static void main(String[] args) {
        Random random = new Random();

        Cat[] cats = new Cat[numCats];
        for (int i = 0; i < numCats; i++) {
            cats[i] = new Cat(random.nextInt(100), i);
        }

        LinkedListChainMethod listChainMethod = new LinkedListChainMethod(numLinkedList);
        for (int i = 0; i < cats.length; i++) {
            listChainMethod.put(cats[i].key, cats[i].value);
        }
        System.out.println(listChainMethod.toString());
    }
}
