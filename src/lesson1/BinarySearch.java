package lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Бинарный поиск. На входе упорядоченный массив.
 * Если искомый элемент в списке существует, то  этот элемент выводится в консоль.
 * В противном случае, выводится null. Выполняется за время O(logN).
 */
public class BinarySearch {
    int[] arr;
    int lowerBound = 0;
    int upperBound;
    int curIn;

    public BinarySearch(int[] arr) {
        this.arr = arr;
        this.upperBound = arr.length - 1;
    }

    public void binarySearch(int num) {
        int count = 0;
        while (true) {
            count++;
            curIn = (lowerBound + upperBound) / 2;
            if (arr[curIn] == num) {
                System.out.printf("Найдено число: a[%d] = %d", curIn, num);
                System.out.println(" Count: " + count);
                return;
            }
            if (lowerBound > upperBound) {
                System.out.println("Элемент не найден");
                return;
            }
            if (arr[curIn] > num) {
                upperBound = curIn - 1;
            } else {
                lowerBound = curIn + 1;
            }
        }
    }
}

class BinarySearchApp{
    private static final int sizeArr = 100000;

    public static void main(String[] args) throws IOException {
//        BinarySearch arr = new BinarySearch(new long[]{7,17,27,37,47,57,67,77,87});

        int[] array = new int[sizeArr];
        for (int i = 0; i < sizeArr; i++) {
            array[i] = random(1, 100);
        }
        BinarySearch arr = new BinarySearch(array);


        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите число для поиска: ");
        int num = Integer.parseInt(buff.readLine());
        arr.binarySearch(num);
    }

    private static int random(int min, int max) {
        max -= min;
        return (int)(Math.random() * ++max) + min;
    }
}
