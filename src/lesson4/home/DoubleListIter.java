package lesson4.home;

import lesson4.lesson.Cat;

public class DoubleListIter {
    private Link current;
    private Link prev;
    private final DoubleList dList;

    public DoubleListIter(DoubleList dList) {
        this.dList = dList;
        reset();
    }

    public Link getCurrent() {
        return current;
    }

    public Link getPrev() {
        return prev;
    }

    private void reset() {
        current = dList.getHead();
        prev = null;
    }

    //Указывает на последний элемент
    public boolean atEnd() {
        return current.next == null;
    }

    public Link nextLink() {
        prev = current;
        current = current.next;
        return current;
    }

    public Link insertAfter(Cat afterCat, Cat insCat) {
        current = dList.insertAfter(afterCat, insCat);
        prev = current.prev;
        return current;
    }

    public Link insertBefore(Cat beforeCat, Cat insCat) {
        current = dList.insertBefore(beforeCat, insCat);
        prev = current.prev;
        return current;
    }

    public boolean deleteCurrent(){
        boolean delete;
        delete = dList.deleteElem(current.cat);
        reset();
        return delete;
    }
}
