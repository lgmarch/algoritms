public class EightQueen {
    private static boolean isPossible (int[][] desk, int x, int y) {
        return x >= 0 && x < desk.length &&
                y >= 0 && y < desk[0].length &&
                checkingVert(desk, x, y) && //Проверка вертикалей
                checkingGor(desk, x, y) &&  //Проверка горизонталей
                checkingDiag(desk, x, y);   //Диагоналей
    }

    private static boolean checkingVert(int[][] desk, int x, int y) {
        for (int i = 0; i < desk.length; i++) {
            if (desk[x][i] != 0) return false;
        }
        return true;
    }

    private static boolean checkingGor(int[][] desk, int x, int y) {
        for (int i = 0; i < desk.length; i++) {
            if (desk[i][y] != 0) return false;
        }
        return true;
    }

    //TODO
    // Индексы элементов из диагоналей имеют одно правило - их сумма постоянна по одной диагонали
    private static boolean checkingDiag(int[][] desk, int x, int y) {
        int index = desk.length;

        int c = 0;
        int count = desk.length + desk[0].length -1;
        int i = 0, j = 0;
        while (c < count) {
            printDiagonal(i, j, desk);
            if (i < desk.length -1) {
                i++;
            } else if (j < desk[0].length - 1) {
                j++;
            }
            c++;
        }
        return true;
    }

    //Test проверки диагоналей
    private static void printDiagonal(int i, int j, int[][] desk) {
        while (i >=0 && j< desk[0].length ) {
            System.out.print(desk[i][j] + " ");
            i--;
            j++;
        }
        System.out.println("");
    }

    //TODO
    private static int getNextX(int x, int y) {
        int nextX = 0;
        return nextX;
    }

    //TODO
    private static int getNextY(int x, int y) {
        int nextY = 0;

        return nextY;
    }

    private static boolean queenMove(int[][] desk,  int currX, int currY, int queen) {
        desk[currX][currY] = queen;
        if (queen > desk[0].length - 1) return true;

        int nextX, nextY;
        for (int i = 0; i < desk[0].length - 1; i++) {
            nextX = getNextX(currX, currY);
            nextY = getNextY(currX, currY);
            if (isPossible(desk, nextX, nextY)) {
                queen++;
                queenMove(desk, nextX, nextY, queen);
                return true;
            }
        }
        desk[currX][currY] = 0;
        return false;
    }

    private static void printDesk(int[][] desk) {
        for (int[] ints : desk) {
            for (int j = 0; j < desk[0].length; j++) {
                System.out.printf("%3d", ints[j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] desk = new int[6][6];
        printDesk(desk);
        checkingDiag(desk, 2, 1);
//        queenMove(desk, 0, 0, 1);
//        printDesk(desk);
    }
}
