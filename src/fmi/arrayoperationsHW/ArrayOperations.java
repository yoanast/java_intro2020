package fmi.arrayoperationsHW;

/**  Програма, която осъществява операции с масив.
 *   @author Йоана Стойковска
 */

import java.util.Random;
import java.util.Scanner;

public class ArrayOperations {

    public static final int ELEMENT_NOT_FOUND = -1;
    public static boolean isProgramRunning = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            System.out.println("Въведете броя на числата, които ще въвеждате: ");
            int arrayLength = scanner.nextInt();

            System.out.println("Въведете числата, от които ще е съставен масива: ");
            int[] array = new int[arrayLength];
            for (int i = 0; i < arrayLength; i++) {
                array[i] = scanner.nextInt();

                if (array[i] >= 1 && array[i] <= 100) {
                    continue;
                } else
                    i--;
                System.out.println("Невалидно число! Числата трябва да бъдат в интервала от 1 до 100!");
            }

       while (isProgramRunning) {

           Action(array, scanner);
       }
    }

    /**               Метод, който подрежда масива по възходящ ред.
     *
     * @param array   Масив, на който се взимат елементите.
     * @return        Връща масива, подреден по възходящ ред.
     */
    public static int[] ascendingOrderSorting(int[] array) {

        int length = array.length;
        int element;

        for (int i = 1; i < length; i++) {

            for (int j = length - 1; j >= i; j--) {

                if (array[j - 1] > array[j]) {
                    element = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = element;
                }
            }
        }
        return array;

    }

    /**               Метод, който подрежда масива по низходящ ред.
     *
     * @param array   Масив, на който се взимат елементите.
     * @return        Връша масива, подреден по низходящ ред.
     */
    public static int[] descendingOrderSorting(int[] array) {

        ascendingOrderSorting(array);
        reverseArray(array);
        return array;

        /* Метода може да бъде реализиран и по същия начин като ascendingOrderSorting със смяна на знака в if statement.
        int length = array.length;
        int element;

        for (int i = 1; i < length; i++) {

            for (int j = length - 1; j >= i; j--) {

                if (array[j - 1] < array[j]) {
                    element = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = element;
                }
            }
        }

        return array; */
    }

    /**               Метод, който при получаване на входни данни(число), намира неговата позиция в масива.
     *
     * @param array   Масив, от който трябва да се избере число, което да бъде намерено.
     * @param scanner Скенер, чрез който прочитаме входните данни.
     * @return        Връща позицията на търсеното число.
     */
    public static int binarySearch(int[] array, Scanner scanner) {
        System.out.println("Въведете числото, чиято позиция искате да намерите: ");
        int element = scanner.nextInt();

        int leftIndex = 0;
        int rightIndex = array.length - 1;
        int middle = (leftIndex + rightIndex) / 2;

        while (leftIndex <= rightIndex) {
            if (element == array[middle]) {
                System.out.println("Търсеното число " + element + " е намерено на позиция " + middle);
                return middle;
            } else if (element < array[middle]) {
                rightIndex = middle - 1;
            } else {
                leftIndex = middle + 1;
            }

            middle = (leftIndex + rightIndex) / 2;
        }

        System.out.println("Числото не е намерено в масива.");
        return ELEMENT_NOT_FOUND;
    }

    /**               Метод, който разменя позициите на елементите в масива.
     *
     * @param array   Масив, на който се взимат елементите.
     * @return        Връща масивът с разменени позиции на елементите.
     */
    public static int[] shufflePositions(int[] array) {
        Random random = new Random();

        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temporary = array[index];
            array[index] = array[i];
            array[i] = temporary;
        }
        System.out.print("Разбъркания масив изглежда така: ");
        return array;
    }

    /**               Метод, който намира сумата от елементите на масива.
     *
     * @param array   Масив, на който се взимам елементите.
     * @return        Връща сумата на елементите на масива.
     */
    public static int findingSumOfAnArray(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        //System.out.println("Сумата на числата в масива е: ");
        return sum;
    }

    /**               Метод, който намира най-голямото число в масива.
     *
     * @param array   Масив, на който се взимат елементите.
     * @return        Връща стойността на най-голямото число в масива.
     */
    public static int findingGreatestNumber(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.print("Най-голямото число в масива е: ");
        return max;
    }

    /**               Метод, който намира най-малкото число в масива.
     *
     * @param array   Масив, на който се взимат елементите.
     * @return        Връша стойността на най-малкото число в масива.
     */
    public static int findingLowestNumber(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.print("Най-малкото число в масива е: ");
        return min;
    }

    /**               Метод, който намира средно-аритметичното на всички числа от масива.
     *
     * @param array   Масив, на който се взимат елементите.
     * @return        Връща средно-аритметичното на числата от масива.
     */
    public static int findAverage(int[] array) {
        System.out.print("Средно-аритметичното на числата е: ");
        return findingSumOfAnArray(array) / array.length;
    }

    /**               Метод, който ни казва дали масивът е симетричен или не е.
     *
     * @param array   Масив, на който се взимат елементите.
     */
    public static void isArraySymmetrical(int[] array) {
        boolean isSymmetrical = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i]!= array[array.length - 1 - i]) {
                isSymmetrical = false;
            }
        }

        if (isSymmetrical == true) {
            System.out.println("Масивът е симетричен!");
        }
        else {
            System.out.println("Масивът не е симетричен!");
        }
    }

    /**               Метод, който обръща масива от числа.
     *
     * @param array   Масив, на който се взимат елементите.
     * @return        Връша обърнатия масив.
     */
    public static int[] reverseArray(int[] array) {
        int leftIndex = 0;
        int rightIndex = array.length - 1;

        while (leftIndex < rightIndex) {

            int temporary = array[leftIndex];
            array[leftIndex] = array[rightIndex];
            array[rightIndex] = temporary;
            leftIndex++;
            rightIndex--;
        }
        return array;
    }

    /**               Метод, който визуализира текущото състояние на масива.
     *
     * @param array   Масив, на който се взимат елементите.
     */
    public static void visualizeArray(int[] array) {
        for (int element : array) {
            System.out.print("[" + element + "] ");
        }
        System.out.println();
    }

    /**               Метод, който принтира възможните команди на програмата, от които може да избира потребителя.
     *
     */
    public static void displayMenu() {
        System.out.print(  "[1] Сортиране на въведените числа във възходящ ред\n" +
                           "[2] Сортиране на въведените числа в низходящ ред\n" +
                           "[3] Търсене на позиция на конкретно число\n" +
                           "[4] Разбъркване на числата\n" +
                           "[5] Изчисляване на сбора на всички числа\n" +
                           "[6] Намиране на най-голямото число\n" +
                           "[7] Намиране на най-малкото число\n" +
                           "[8] Намиране средно-аритметично на числата\n" +
                           "[9] Проверка за симетричност на масива от числа\n" +
                           "[10] Обръщане на масива от числа\n" +
                           "[11] Визуализирай въведените числа\n" +
                           "[12] Изход\n");
    }

    /**               Метод, от който се избират различните команди на програмата.
     *
     * @param array   Масив, на който се взимат елементите.
     * @param scanner Скенер, чрез който прочитаме входните данни.
     */
    public static void Action(int[] array, Scanner scanner) {
        displayMenu();
        System.out.println("Въведете номера на процеса, който искате да бъде изпълнен: ");
        byte decision = scanner.nextByte();
        switch (decision) {
            case 1:
                System.out.print("Масивът във възходящ ред изглежда така: ");
                ascendingOrderSorting(array);
                visualizeArray(array);
                break;
            case 2:
                System.out.print("Масивът в низходящ ред изглежда така: ");
                descendingOrderSorting(array);
                visualizeArray(array);
                break;
            case 3:
                binarySearch(array, scanner);
                break;
            case 4:
                shufflePositions(array);
                visualizeArray(array);
                break;
            case 5:
                System.out.print("Сумата на числата в масива е: ");
                System.out.println(findingSumOfAnArray(array));
                break;
            case 6:
                System.out.println(findingGreatestNumber(array));
                break;
            case 7:
                System.out.println(findingLowestNumber(array));
                break;
            case 8:
                System.out.println(findAverage(array));
                break;
            case 9:
                isArraySymmetrical(array);
                visualizeArray(array);
                break;
            case 10:
                System.out.print("Обърнатият масив изглежда така: ");
                reverseArray(array);
                visualizeArray(array);
                break;
            case 11:
                visualizeArray(array);
                break;
            case 12:
                isProgramRunning = false;
                break;
            default:
                System.out.println("Невалидна опция! Опитайте отново!");
                Action(array, scanner);
        }
    }
}
