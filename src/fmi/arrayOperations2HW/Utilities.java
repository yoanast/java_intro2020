package fmi.arrayOperations2HW;

public class Utilities {

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

    public static void displayMainMenu() {
        System.out.println("   =Главно меню=\n" +
                "[1] Работа с числа\n" +
                "[2] Работа с букви\n" +
                "[3] Изход от програмата\n");
    }

    public static void displayNumberOptionsMenu() {
        System.out.println("Меню с опции:\n" +
                "[1] Извеждане само на простите числа от масива\n" +
                "[2] Извеждане на най-често срещан елемент в масива\n" +
                "[3] Извеждане на максимална редица от нарастващи елементи в масива\n" +
                "[4] Извеждане на максимална редица от намаляващи елементи в масива\n" +
                "[5] Извеждане на максимална редица от еднакви елементи в масива\n" +
                "[6] Извеждане на последователност от числа от масива, които имат сума " +
                "равна на число, генерирано на случаен принцип\n" +
                "[7] Връщане назад към основното меню\n");
    }

    public static int findingSumOfAnArray(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static void displayWordOptionsMenu() {
        System.out.println("Меню с опции:\n" +
                "[1] Обърнете буквите на думите от масива наобратно и ги визуализирайте в конзолата\n" +
                "[2] Изведете броя на повтарящите се символи за всяка една от думите в масива\n" +
                "[3] Изведете броя на символите за всяка една от думите в масива\n" +
                "[4] Изведете броя на повтарящите се думи от масива\n" +
                "[5] Връщане назад към основното меню\n");
    }
}
