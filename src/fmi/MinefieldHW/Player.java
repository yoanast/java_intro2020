package fmi.MinefieldHW;

import java.util.Scanner;

public class Player {

    public static final String PLAYER_SYMBOL = " * ";

    /**                         Метод, с който задаваме текущи и нови координати.
     *
     */
    public static void getNewPosition() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Моля въведете текушия ред, на който се намирате: ");
        Application.userRowInput = scanner.nextInt();

        System.out.println(" Моля въведете текушата колона, на която се намирате: ");
        Application.userColInput = scanner.nextInt();

        System.out.println(" Моля въведете новия ред, на който искате да се преместите: ");
        Application.userNewRowInput = scanner.nextInt();

        System.out.println(" Моля въведете новата колона, на която искате да се преместите: ");
        Application.userNewColInput = scanner.nextInt();

    }

    /**                         Метод, с който проверяваме дали желаното преместване е възможно.
     *
     * @param userRowInput      Старият ред, на който се намира играчът преди преместването.
     * @param userColInput      Старата колона, на която се намира играчът преди преместването.
     * @param userNewRowInput   Новия ред, на който ще бъде преместен играчът.
     * @param userNewColInput   Новата колона, на който ще бъде преместен играчът.
     * @return
     */
    public static boolean isMoveValid(int userRowInput,int userColInput,
                                      int userNewRowInput, int userNewColInput) {

        int colMoves = Math.abs(userColInput - userNewColInput);
        int rowMoves = Math.abs(userRowInput - userNewRowInput);

        return (colMoves == 1 && rowMoves == 0) || (colMoves == 0 && rowMoves == 1);
    }

}