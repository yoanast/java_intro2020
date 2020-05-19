package fmi.arrayOperations2HW;


import java.util.Scanner;


public class ArrayOperations2 {

    public static boolean isProgramRunning = true;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] array = new int[IntArrayFunctions.chooseArrayLength(scanner)];
        String[] wordArray = new String[StringArrayFunctions.chooseWArrayLength(scanner)];


        while (isProgramRunning) {
            mainMenu(array, wordArray, scanner);
        }
    }

    public static void mainMenu(int[] array, String[] wordArray, Scanner scanner) {
        Utilities.displayMainMenu();
        System.out.println("Въведете номера на процеса, който искате да бъде изпълнен: ");
        byte mDecision = scanner.nextByte();
        switch (mDecision) {
            case 1:
                IntArrayFunctions.numberOptionsMenu(scanner, array);
                break;
            case 2: StringArrayFunctions.wordOptionsMenu(wordArray, scanner);
                break;
            case 3:
                isProgramRunning = false;
                break;
            default:
                System.out.println("Невалидна опция! Опитайте отново!");
                mainMenu(array, wordArray, scanner);
        }

    }

}