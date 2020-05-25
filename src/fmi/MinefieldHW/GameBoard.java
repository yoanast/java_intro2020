package fmi.MinefieldHW;

import java.util.Random;

public class GameBoard {

    public static String finalPoint = " F ";
    public static String startPoint = " S ";

    /**                        Метод, който запълва на игралната дъска с подадения параметър symbol.
     *
     * @param gameBoard        Масив, от който се взимат данните за игралната дъска.
     * @param gameBoardHeight  Височината на дъската, взета от txt файла.
     * @param gameBoardWidth   Широчината на дъската, взета от txt файла.
     * @param random           Обект от тип Random.
     * @param symbol           Параметър, с който се попълва gameBoard.
     * @param mineBoard        Дублиран масив на gameBoard, където се разполагат бомбите, което остава скрито от потребителя.
     */
    public static void fillGameBoard(String[][] gameBoard, int gameBoardHeight,
                                     int gameBoardWidth, Random random, String symbol,
                                     String[][] mineBoard) {

        for (int i = 0; i < gameBoardHeight; i++) {
            for (int j = 0; j < gameBoardWidth; j++) {
                gameBoard[i][j] = symbol;
            }
        }

        GameBoard.generateStartAndFinish(gameBoard, random, gameBoardHeight, gameBoardWidth, mineBoard);

    }

    /**                        Метод, който визуализира игралната дъска.
     *
     * @param gameBoard        Масив, от който се взимат данните за игралната дъска.
     * @param boardInfo        Масив, в който се пазят номерата на редове и колони.
     * @param gameBoardHeight  Височината на дъската, взета от txt файла.
     * @param gameBoardWidth   Широчината на дъската, взета от txt файла.
     */
    public static void drawGameBoard(String[][] gameBoard,int[] boardInfo,
                                     int gameBoardHeight, int gameBoardWidth) {

        fillBoardInfo(boardInfo, gameBoardWidth);
        for (int i = 0; i < gameBoardHeight; i++) {
            for (int j = 0; j < gameBoardWidth; j++) {
                System.out.print(gameBoard[i][j]);
                System.out.print(" | ");
            }
            System.out.print(boardInfo[i]);
            System.out.println();
            System.out.print("-----------------------------------");
            System.out.println();


        }
        drawBoardInfo(boardInfo, gameBoardHeight);
        System.out.println();
        System.out.println();
    }

    /**                        Метод, който визуализира номерата на редовете на дъската.
     *
     * @param boardInfo        Масив, в който се пазят номерата на редовете.
     * @param gameBoardWidth   Широчината на дъската, взета от txt файла.
     */
    public static void fillBoardInfo(int[] boardInfo, int gameBoardWidth) {

        for(int i = 0; i < gameBoardWidth; i++) {
            boardInfo[i] = i;
        }

    }

    /**                        Метод, който визуализира номерата на колоните на дъската.
     *
     * @param boardInfo        Масив, в който се пазят номерата на колоните.
     * @param gameBoardHeight  Височината на дъската, взета от txt файла.
     */
    public static void drawBoardInfo(int[] boardInfo, int gameBoardHeight) {
        for(int i = 0; i < gameBoardHeight; i++) {
            System.out.print(" " + boardInfo[i]  + "    ");
        }
    }

    /**                        Метод, който генерира координати за начало и край на дъската.
     *
     * @param gameBoard        Масив, от който се взимат данните за игралната дъска.
     * @param random           Обект от тип Random.
     * @param gameBoardHeight  Височината на дъската, взета от txt файла.
     * @param gameBoardWidth   Широчината на дъската, взета от txt файла.
     * @param mineBoard        Дублиран масив на gameBoard, където се разполагат бомбите, което остава скрито от потребителя.
     */
    public static void generateStartAndFinish(String[][] gameBoard, Random random,
                                              int gameBoardHeight, int gameBoardWidth,
                                              String[][] mineBoard) {

        int firstNumber = random.nextInt(gameBoardWidth);
        int secondNumber = random.nextInt(gameBoardWidth);

        gameBoard[0][firstNumber] = finalPoint;
        gameBoard[gameBoardHeight - 1][secondNumber] = startPoint;

        mineBoard[0][firstNumber] = finalPoint;

    }

    /**                        Метод, който проверява дали играча е стъпил на бомба или дали е преминал през финала.
     *                         И в двата случая изпълнението на програмата приключва.
     *
     * @param gameBoard        Масив, от който се взимат данните за игралната дъска.
     * @param userNewRowInput  Новия ред, на който ще бъде преместен играчът.
     * @param userNewColInput  Новиата колона, на който ще бъде преместен играчът.
     * @return                 Връща true в зависимист от това дали играта е приключила(успешно) или
     *                         false ако все още има възможни ходове.
     */
    public static boolean isTheGameWon(String[][] gameBoard, int userNewRowInput, int userNewColInput) {

        if(Mines.isBombActivated) {
            return true;
        }

        if(gameBoard[userNewRowInput][userNewColInput] == finalPoint) {
            gameBoard[userNewRowInput][userNewColInput] = Player.PLAYER_SYMBOL;
            System.out.println("Вие преминахте успешно през полето и спечелихте играта!");
            return true;
        }
        return false;
    }

    /**                        Метод, който прави допълнителните ред и колона от null на празен стринг.
     *
     * @param gameBoard        Масив, от който се взимат данните за игралната дъска.
     * @param gameBoardHeight  Височината на дъската, взета от txt файла.
     * @param gameBoardWidth   Широчината на дъската, взета от txt файла.
     */
    public static void catchNullValue(String[][] gameBoard, int gameBoardHeight, int gameBoardWidth) {

        for (int i = 0; i < gameBoardHeight; i++) {
            for (int j = 0; j < gameBoardWidth; j++) {
                if(gameBoard[i][j] == null) {
                    gameBoard[i][j] = "";
                }
            }
        }

    }


}
