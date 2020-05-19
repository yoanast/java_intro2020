package fmi.arrayOperations2HW;

import java.util.Scanner;

public class StringArrayFunctions {

    public static int chooseWArrayLength(Scanner scanner) {
        System.out.println("Въведете броя на думите, които ще въвеждате: ");
        int arrayWLength = scanner.nextInt();
        return arrayWLength;
    }

    public static String[] operationsWithWords(String[] wordArray, Scanner scanner) {
        for (int i = 0; i < wordArray.length; i++) {
            System.out.println("Въведете думата на позиция " + (i + 1) + ", която да бъде добавена към масива: ");
            String wordInput = scanner.next();

            if (wordInput.length() <= 20) {
                wordArray[i] = wordInput;
            } else {
                i--;
                System.out.println("Думата не може да съдържа повече от 20 символа. Опитайте отново.");
            }
        }
        return wordArray;
    }

    public static void wordOptionsMenu(String[] wordArray, Scanner scanner) {
        operationsWithWords(wordArray, scanner);
        Utilities.displayWordOptionsMenu();
        System.out.println("Въведете номера на процеса, който искате да бъде изпълнен: ");
        byte wDecision = scanner.nextByte();
        switch (wDecision) {
            case 1:
                reverseWords(wordArray, scanner);
                break;
            case 2:
                countRepeatedSymbols(wordArray);
                break;
            case 3:
                countSymbols(wordArray);
                break;
            case 4:
                countRepeatedWords(wordArray);
                break;
            case 5:
                break;
            default:
                System.out.println("Невалидна опция! Опитайте отново!");
                wordOptionsMenu(wordArray, scanner);
        }
    }

    public static void reverseWords(String[] wordArray, Scanner scanner) {

        String reversedString = "";

        for (int i = 0; i < wordArray.length; i++) {
            String word = wordArray[i];
            String reverseWord = "";

            for (int j = word.length() - 1; j >= 0; j--) {

                reverseWord = reverseWord + word.charAt(j);
            }
            reversedString = reversedString + reverseWord + " ";
        }

        System.out.print("Буквите на думите от масива наобратно изглеждат така: " + reversedString);
        System.out.println();
    }

    public static void countRepeatedSymbols(String[] wordArray) {


    }

    public static void countSymbols(String[] wordArray) {

        for (int i = 0; i < wordArray.length; i++) {
            System.out.printf("В думата " + wordArray[i] + " се съдържат " + wordArray[i].length() + " символа.\n");
        }
    }

    public static void countRepeatedWords(String[] wordArray) {


        for (int i = 0; i < wordArray.length; i++) {
            int rcounter = 1;

            for (int j = i + 1; j < wordArray.length; j++) {
                if (wordArray[i].equals(wordArray[j])) {
                    rcounter++;
                }
            }
            if(rcounter > 1) {
                System.out.println("Думата " + wordArray[i] + " се повтаря " + rcounter + " пъти.\n");
            }

            if (rcounter < 1) {
                System.out.println("Няма повтарящи се думи в масива\n");
            }
        }



    }


}
