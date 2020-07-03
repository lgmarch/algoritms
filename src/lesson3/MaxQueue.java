package lesson3;

public class MaxQueue {
    public static <T extends Comparable<T>> ElemForQueue max(T[] a, int head) {
        T temp;
        int i, j, min;

        for (i = 0; i < head; i++) {
            min = i;
            for (j = i+1; j <= head; j++) {
                if (a[j].compareTo(a[min]) < 0) {
                    min = j;
                }
            }
            temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
        return (ElemForQueue) a[head];
    }
}
