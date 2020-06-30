package lesson1.selection_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Сортировка выбором.
 */
public class SelSort {

    private static List<Integer> selectionSort(List<Integer> list) {
        List<Integer> newArr = new ArrayList<>(list.size());

        while (list.size() > 0){
            int num = findSmallElem(list);
            newArr.add(list.get(num));
            list.remove(num);
        }

        return newArr;
    }

    private static int findSmallElem(List<Integer> list) {
        int smallest = list.get(0);
        int smallestIndex = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < smallest) {
                smallest = list.get(i);
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 3, 6, 2, 10));
        System.out.println(list);
        System.out.println(selectionSort(list)); //[2, 3, 5, 6, 10]
    }
}
