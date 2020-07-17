public class Hanoi {
    public static void main(String[] args) {
        buildHanoi(5, 'A', 'Б', 'В');
    }

    private static void buildHanoi(int num, char one, char two, char three){
        if (num == 1) System.out.println(num + " перемещен с " + one + " на " + three +
                " Hanoi build!");
        else {
            buildHanoi(num - 1, one, two, three);
            System.out.println(num + " перемещен с " + one + " на " + three);
            buildHanoi(num - 1, one, two, three);
        }
    }
}
