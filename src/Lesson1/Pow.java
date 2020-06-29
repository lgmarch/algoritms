package Lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *  Возведение в степень (*используя чётность степени).
 */
public class Pow {
    /**
     * Простое умножение. Время выполнения: O(pow) или О(N).
     */
    public static int pow(int number, int pow){
        int result = 1;
        for (int i = 0; i < pow; i++) {
            result *= number;
        }
        return result;
    }

    /**
     * O(logN)
     */
    public static int powBin(int number, int pow){
        int result = 1;
        while(pow > 0) {
            if (pow % 2 == 0) {
                pow /= 2;
                number *= number;
            }
            else {
                pow--;
                result *= number;
            }
        }
        return result;
    }

    /**
     * Использование рекурсии.
     * На каждом шаге число умножений, которое осталось сделать уменьшается в два раза и
     * будет равняться O(log2pow), что эффективнее O(pow).
     */
    public static int recursionPow(int number, int pow) {
        if (pow == 0) return 1;
        if (pow % 2 == 1)
            return recursionPow(number, pow-1) * number; //нечетная степень
        else {
            int b = recursionPow(number, pow/2); //Четная степень
            return b * b;
        }
    }
}

class ExponentiationApp {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Введите число, степень числа через пробел: ");
//        String[] str = buff.readLine().split(" ");
//        System.out.println("Число: " + str[0] + ", степень: " + str[1]);
//        System.out.println("Результат: " + Lesson1.Pow.pow(Integer.parseInt(str[0]), Integer.parseInt(str[1])));

        int num = 5; int pow = 2;
        System.out.println("Число: " + num + ", степень: " + pow);
        System.out.println("Результат: " + Pow.pow(num, pow));
        System.out.println("Результат: " + Pow.recursionPow(num, pow));
        System.out.println("Результат: " + Pow.powBin(num, pow));

        ArrayList<Integer> li = new ArrayList<Integer>();
        ArrayList<Float> lf = new ArrayList<Float>();
        if (li.getClass() == lf.getClass()) // evaluates to true
            System.out.println("Equal");
    }
}
