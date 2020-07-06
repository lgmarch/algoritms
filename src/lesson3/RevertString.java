package lesson3;

import java.util.Scanner;

/**
 * Создать программу, которая переворачивает вводимые строки (читает справа налево).
 * Использовала класс, который создали на уроке, только немного его изменила.
 */
public class RevertString {
    enum CommandKey {
        QUIT("\\q", "Выход");

        private final String command;
        private final String action;

        CommandKey(String s, String s1) {
            command = s;
            action = s1;
        }
        public String getCommand() {
            return command;
        }
        public String getAction() {
            return action;
        }
    }

    private boolean revertString = true;
    private final Stack stack;
    private String strIn;

    public RevertString(String str) {
        this.strIn = str;
        this.stack = new Stack(10);
        addStrToStack(str);
    }

    public void run() {
        while (revertString) {
            showWindow();
            commandsProcessing(getInput()); //Обработка ввода
        }
    }

    private void showWindow() {
        showHeader();
        showBody();
        showFood();
    }

    private void showHeader() {
        System.out.print("\t \n *** *** Введите строку, по окончании нажмите Enter. *** *** \n\n");
    }

    private void showBody(){
        showString();
    }

    private void showFood() {
        System.out.println("\t\n");
        System.out.println(" ***  " + CommandKey.QUIT.getCommand() + ": " + CommandKey.QUIT.getAction() + "    *** \n");
    }

    private void showString(){
        System.out.println("\t Исходная строка: " + strIn);
        printSrtFromStack();
    }

    private void printSrtFromStack(){
        System.out.print("\t Перевернутая: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private void commandsProcessing(String com){
        if ("\\q".equals(com)) {
            System.out.println("Выход из программы.");
            revertString = false;
            return;
        }
        if (!com.isEmpty()) {
            strIn = com;
            addStrToStack(com);
            return;
        }
        System.out.println("Данная команда отсутствует!");
    }

    private void addStrToStack(String str) {
        String[] worlds = str.split(" ");
        for (String s : worlds) {
            stack.push(s);
        }
    }

    /**
     * Чтение с консоли
     */
    private String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}

class MainRevertString {
    public static void main(String[] args) {
        RevertString revertString = new RevertString("Hello, World!");
        revertString.run();
    }
}


