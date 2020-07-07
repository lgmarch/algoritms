package lesson4.home;

import lesson4.lesson.Cat;

public class DoubleListMain {
    public static void main(String[] args) {
        //1
        DoubleList dList = new DoubleList();
        DoubleListIter listIter = dList.getIterator();

        Cat cat1 = new Cat(1, "Barsik");
        Cat cat2 = new Cat(2, "Mara");
        Cat cat3 = new Cat(3, "Rizik");
        Cat cat4 = new Cat(4, "Vaska");
        Cat cat5 = new Cat(5, "Myrka");

        dList.insertHead(cat1);
        dList.insertHead(cat2);
        dList.insertTail(cat4);
        System.out.println(dList.toString());

        System.out.println(dList.insertAfter(cat1,cat3) != null ? dList.toString() : "Не удалось вставить элемент.");
        System.out.println(dList.toString());
        //Вставка итератором
        System.out.println(listIter.insertAfter(cat2, cat5) != null ? dList.toString() : "Не удалось вставить элемент.");
        System.out.println(listIter.getCurrent().toString());
        System.out.println(listIter.getPrev().toString());

        System.out.println(dList.deleteTail() == null ? "Ошибка удаления" : "OK");
        System.out.println(dList.deleteHead() == null ? "Ошибка удаления" : "OK");
        System.out.println(dList.deleteHead() == null ? "Ошибка удаления" : "OK");
        System.out.println(dList.deleteHead() == null ? "Ошибка удаления" : "OK");
        System.out.println(dList.deleteHead() == null ? "Ошибка удаления" : "OK");
        System.out.println(dList.toString());

        //2
        dList.insertHead(cat1);
        System.out.println(dList.toString());
        System.out.println(listIter.insertAfter(cat1, cat5) != null ? dList.toString() : "Не удалось вставить элемент.");
        System.out.println(listIter.insertBefore(cat1, cat4) != null ? dList.toString() : "Не удалось вставить элемент.");

        System.out.println(listIter.deleteCurrent() ? dList.toString() : "Ошибка удаления тек.элемента.");
        System.out.println(listIter.deleteCurrent() ? dList.toString() : "Ошибка удаления тек.элемента.");
        System.out.println(listIter.deleteCurrent() ? dList.toString() : "Ошибка удаления тек.элемента.");
    }
}
