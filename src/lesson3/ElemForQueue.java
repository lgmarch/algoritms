package lesson3;

/**
 * Реализовать класс с приоритетной очередью.
 */
public class ElemForQueue implements Comparable<ElemForQueue>{
    private final int MAX_PRIORITY = 5;
    private final int MIN_PRIORITY = 0;
    private int priority;
    private final int data;

    public ElemForQueue(int priority, int data) {
        if (checkPriority(priority))
            this.priority = priority;
        this.data = data;
    }

    public int getPriority() {
        return priority;
    }

    private boolean checkPriority(int priority) {
        return (priority >= MIN_PRIORITY && priority <= MAX_PRIORITY);
    }

    @Override
    public int compareTo(ElemForQueue o) {
        return Integer.compare(this.getPriority(), o.getPriority());
    }

    @Override
    public String toString() {
        return "Priority: " + this.priority + ", data: " + this.data;
    }
}

class MainPriorityQueue{
    public static void main(String[] args) {
        ElemForQueue[] prior = new ElemForQueue[10];
        PriorityQueue<ElemForQueue> priorityQueue = new PriorityQueue<>(10, prior);

        priorityQueue.push(new ElemForQueue(5,10));
        priorityQueue.printArr();
        priorityQueue.push(new ElemForQueue(1,20));
        priorityQueue.printArr();
        priorityQueue.push(new ElemForQueue(0,30));
        priorityQueue.printArr();
        priorityQueue.push(new ElemForQueue(2,40));
        priorityQueue.printArr();
        priorityQueue.push(new ElemForQueue(0,50));
        priorityQueue.printArr();

        priorityQueue.pop();
        priorityQueue.printArr();
        priorityQueue.pop();
        priorityQueue.printArr();
    }
}
