package fmi.arrayOperations2HW;

import java.util.Random;
import java.util.Scanner;

public class IntArrayFunctions {

    public static int chooseArrayLength(Scanner scanner) {
        System.out.println("Въведете броя на числата, които ще въвеждате: ");
        int arrayLength = scanner.nextInt();
        return arrayLength;
    }

    public static void operationsWithNumbers(Scanner scanner, int[] array) {

        System.out.println("Въведете числата, от които ще е съставен масива: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();

            if (array[i] >= 1 && array[i] <= 10000) {
                continue;
            } else
                i--;
            System.out.println("Невалидно число! Числата трябва да бъдат в интервала от 1 до 10000!");
        }
    }

    public static void numberOptionsMenu(Scanner scanner, int[] array) {
        operationsWithNumbers(scanner, array);
        Utilities.displayNumberOptionsMenu();
        System.out.println("Въведете номера на процеса, който искате да бъде изпълнен: ");
        byte nDecision = scanner.nextByte();
        switch (nDecision) {

            case 1:
                printSimpleNumbers(array);
                break;
            case 2:
                findMostCommonElement(array);
                break;
            case 3:
                findIncreasingContiguousRange(array);
                break;
            case 4:
                findDecreasingContiguousRange(array);
                break;
            case 5:
                findIdenticalContiguousRange(array);
                break;
            case 6:
                findSumEqualToNumber(array);
                break;
            case 7:
                break;
            default:
                System.out.println("Невалидна опция! Опитайте отново!");
                numberOptionsMenu(scanner, array);

        }
    }

    public static void printSimpleNumbers(int[] array) {

        int num = 0;
        String simpleNumbers = "";
        for (int i = 0; i <= array.length; i++) {

            int counter = 0;
            for (num = i; num >= 1; num--) {
                if (i % num == 0) {
                    counter = counter + 1;
                }
            }
            if (counter == 2) {
                simpleNumbers = simpleNumbers + i + " ";
            }
        }
        System.out.println("Простите числа от дадения масив са: " + simpleNumbers);
    }

    public static void findMostCommonElement(int[] array) {

        Utilities.ascendingOrderSorting(array);
        int count = 1;
        int tempCount;
        int common = array[0];
        int temp;
        for (int i = 0; i < (array.length - 1); i++) {

            temp = array[i];
            tempCount = 0;
            for (int j = 1; j < array.length; j++) {

                if (temp == array[j])
                    tempCount++;
            }
            if (tempCount > count) {

                common = temp;
                count = tempCount;
            }
        }
        System.out.println("Най-често срещаният елемент е: " + common);
        //return common;
    }

    public static void findIncreasingContiguousRange(int[] array) {

        int first = 0;
        int second = 0;
        int maxLength = 0;
        int counter = 0;
        int last = 0;

        for (int i = 0; i < array.length - 1; i++) {
            first = array[i];
            second = array[i + 1];
            if (second - first == 1) {
                counter++;
            } else {
                if (counter > maxLength) {
                    maxLength = counter;
                    last = i;
                }
                counter = 0;
            }

            if (i == array.length - 1) {
                if (counter > maxLength) {
                    maxLength = counter;
                    last = i;
                }
            }
        }

        if (maxLength > 1) {
            System.out.print("Максималната редица от нарастващи елементи в масива изглежда така: ");
            for (int i = last - maxLength; i <= last; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("В масива няма редица от нарастващи елементи.");
        }


    }

    public static void findDecreasingContiguousRange(int[] array) {

        int first = 0;
        int second = 0;
        int maxLength = 0;
        int counter = 0;
        int last = 0;

        for (int i = 0; i < array.length - 1; i++) {
            first = array[i];
            second = array[i + 1];
            if (first - second == 1) {
                counter++;
            } else {
                if (counter > maxLength) {
                    maxLength = counter;
                    last = i;
                }
                counter = 0;
            }

            if (i == array.length - 1) {
                if (counter > maxLength) {
                    maxLength = counter;
                    last = i;
                }
            }
        }

        if (maxLength > 1) {

            System.out.print("Максималната редица от намаляващи елементи в масива изглежда така: ");
            for (int i = last - maxLength; i <= last; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("В масива няма редица от нарастващи елементи.");
        }
    }

    public static void findIdenticalContiguousRange(int[] array) {

        int first = 0;
        int second = 0;
        int maxLength = 0;
        int counter = 0;
        int last = 0;

        for (int i = 0; i < array.length - 1; i++) {
            first = array[i];
            second = array[i + 1];
            if (first == second) {
                counter++;
            } else {
                if (counter > maxLength) {
                    maxLength = counter;
                    last = i;
                }
                counter = 0;
            }

            if (i == array.length - 1) {
                if (counter > maxLength) {
                    maxLength = counter;
                    last = i;
                }
            }
        }

        if (maxLength > 1) {

            System.out.print("Максималната редица от еднакви елементи в масива изглежда така: ");
            for (int i = last - maxLength; i <= last; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("В масива няма редица от нарастващи елементи.");
        }
    }

    public static void findSumEqualToNumber(int[] array) {
        Random random = new Random();
        int number = random.nextInt(Utilities.findingSumOfAnArray(array));
        boolean isFound = false;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] + array[i + 1] == number) {
                System.out.print("{" + array[i] + ", " + array[i + 1] + "}");
                isFound = true;
            }
        }

        if (isFound) {
            System.out.print(" имат сума, равна на произволното число " + number);
        } else {
            System.out.println("В масива не са намерени последователни числа със сума, равна на произволното число " + number);
        }
    }

}
