package fmi.MinefieldHW;

import java.util.Random;
import java.util.Scanner;

public class Mines {

    public static boolean isAnalyzed = false;
    public static final String VISITED = " V ";
    public static String mine = " Y ";
    public static boolean isBombActivated = false;

    /**                          Метод, чрез който задаваме случайно координати на мините в полето.
     *
     * @param mineBoard         Дублиран масив на gameBoard, където се разполагат бомбите, което остава скрито от потребителя.
     * @param mines             Броят на мините, взети от txt файла.
     * @param gameBoardHeight   Височината на дъската, взета от txt файла.
     * @param gameBoardWidth    Широчината на дъската, взета от txt файла.
     * @param random            Обект от тип Random.
     */
    public static void getRandomMineCoordinates(String[][] mineBoard, int mines, int gameBoardHeight,
                                                int gameBoardWidth, Random random) {
        int firstRandomCoord;
        int secondRandomCoord;

        for(int i = 0; i < mines; i++) {
            firstRandomCoord = random.nextInt(gameBoardHeight);
            secondRandomCoord = random.nextInt(gameBoardWidth);
            mineBoard[firstRandomCoord][secondRandomCoord] = mine;

        }
    }

    /**                          Метод, чрез който избираме желаната операция след като сме избрали нови координати.
     *
     * @param scanner            Обект от тип Scanner.
     * @param gameBoard          Масив, от който се взимат данните за игралната дъска.
     * @param mineBoard          Дублиран масив на gameBoard, където се разполагат бомбите, което остава скрито от потребителя.
     * @param numberOfDisposal   Броя на възможните опити за обезвреждане на бомба, взети от txt файла.
     * @param userRowInput       Старият ред, на който се намира играчът преди преместването.
     * @param userColInput       Старата колона, на която се намира играчът преди преместването.
     * @param userNewRowInput    Новия ред, на който ще бъде преместен играчът.
     * @param userNewColInput    Новата колона, на който ще бъде преместен играчът.
     * @param boardInfo          Масив, в който се пазят номерата на редове и колони.
     * @param gameBoardHeight    Височината на дъската, взета от txt файла.
     * @param gameBoardWidth     Широчината на дъската, взета от txt файла.
     */
    public static void CombatOperationsMenu(Scanner scanner, String[][] gameBoard,
                                            String[][] mineBoard, int numberOfDisposal,
                                            int userRowInput, int userColInput,
                                            int userNewRowInput, int userNewColInput,
                                            int[] boardInfo, int gameBoardHeight,
                                            int gameBoardWidth) {
        displayCOM();
        System.out.println("Въведете номера на процеса, който искате да бъде изпълнен: ");
        byte oDecision = scanner.nextByte();
        switch (oDecision) {
            case 1:
                try {
                    analyzeArea(gameBoard, mineBoard, userRowInput, userColInput, userNewRowInput, userNewColInput);
                } catch (Exception e) {
                    System.out.println("С клетката за анализиране излизате от рамките на дъската и\n" +
                            "може да се визуализира само клетката, на която искате да се придвижите.");
                    }
                GameBoard.drawGameBoard(gameBoard, boardInfo, gameBoardHeight, gameBoardWidth);
                break;
            case 2:
                defuseABomb(gameBoard, numberOfDisposal, userRowInput,
                            userColInput, userNewRowInput, userNewColInput, mine, mineBoard);
                GameBoard.drawGameBoard(gameBoard, boardInfo, gameBoardHeight, gameBoardWidth);
                break;
            case 3:
                moveWithoutDefusing(gameBoard, mineBoard, userRowInput,
                                     userColInput, userNewRowInput, userNewColInput);
                GameBoard.drawGameBoard(gameBoard, boardInfo, gameBoardHeight, gameBoardWidth);
                break;
        }
    }

    /**                          Метод, който визуализира менюто за бойни действия.
     *
     */
    public static void displayCOM() {
        System.out.println("=Бойни действия=\n" +
                "[1] Анализ на бойното поле\n" +
                "[2] Обезвреждане на бомба\n" +
                "[3] Придвижване по бойното поле\n");
    }

    /**                          Метод, който използваме, за да обезвредим бомба и да преминем.
     *
     * @param gameBoard          Масив, от който се взимат данните за игралната дъска.
     * @param numberOfDisposal   Броя на възможните опити за обезвреждане на бомба, взети от txt файла.
     * @param userRowInput       Старият ред, на който се намира играчът преди преместването.
     * @param userColInput       Старата колона, на която се намира играчът преди преместването.
     * @param userNewRowInput    Новия ред, на който ще бъде преместен играчът.
     * @param userNewColInput    Новата колона, на който ще бъде преместен играчът.
     * @param mine               Параметър, чрез който задаваме как да се визуализира мина на дъската.
     * @param mineBoard          Дублиран масив на gameBoard, където се разполагат бомбите, което остава скрито от потребителя.
     */
    public static void defuseABomb(String[][] gameBoard, int numberOfDisposal,
                                   int userRowInput, int userColInput,
                                   int userNewRowInput, int userNewColInput,
                                   String mine, String[][] mineBoard) {

        if (numberOfDisposal != 0) {
            if (isAnalyzed) {
                if (mineBoard[userNewRowInput][userNewColInput].equals(mine)) {
                    if (Player.isMoveValid(userRowInput, userColInput, userNewRowInput, userNewColInput)) {
                        System.out.println("Бомбата е обезвредена успешно!");
                        numberOfDisposal--;
                        isAnalyzed = false;
                        gameBoard[userNewRowInput][userNewColInput] = Player.PLAYER_SYMBOL;
                        gameBoard[userRowInput][userColInput] = VISITED;
                    } else System.out.println("Невалидни данни! Опитайте отново!");
                }
            }
        }
    }

    /**                          Метод, който проверява за бомби полетата на и в близост до желаните координати.
     *
     * @param gameBoard          Масив, от който се взимат данните за игралната дъска.
     * @param mineBoard          Дублиран масив на gameBoard, където се разполагат бомбите, което остава скрито от потребителя.
     * @param userRowInput       Старият ред, на който се намира играчът преди преместването.
     * @param userColInput       Старата колона, на която се намира играчът преди преместването.
     * @param userNewRowInput    Новия ред, на който ще бъде преместен играчът.
     * @param userNewColInput    Новата колона, на който ще бъде преместен играчът.
     */
    public static void analyzeArea(String[][] gameBoard, String[][] mineBoard,
                                   int userRowInput, int userColInput,
                                   int userNewRowInput, int userNewColInput) {

        //движение наляво
        if(userColInput > userNewColInput && userRowInput == userNewRowInput) {
            gameBoard[userNewRowInput][userNewColInput] = mineBoard[userNewColInput][userNewColInput];
            gameBoard[userNewRowInput][userNewColInput - 1] = mineBoard[userNewColInput][userNewColInput - 1];
            gameBoard[userNewRowInput - 1][userNewColInput] = mineBoard[userNewColInput - 1][userNewColInput];
            gameBoard[userNewRowInput - 1][userNewColInput - 1] = mineBoard[userNewColInput - 1][userNewColInput - 1];
            gameBoard[userNewRowInput + 1][userNewColInput] = mineBoard[userNewRowInput +1][userNewColInput];
            gameBoard[userNewRowInput + 1][userNewColInput - 1] = mineBoard[userNewRowInput + 1][userNewColInput - 1];
            isAnalyzed = true;
        }

        //движение надясно
        if(userColInput < userNewColInput && userRowInput == userNewRowInput) {
            gameBoard[userNewRowInput][userNewColInput] = mineBoard[userNewRowInput][userNewColInput];
            gameBoard[userNewRowInput][userNewColInput + 1] = mineBoard[userNewRowInput][userNewColInput + 1];
            gameBoard[userNewRowInput - 1][userNewColInput] = mineBoard[userNewRowInput - 1][userNewColInput];
            gameBoard[userNewRowInput - 1][userNewColInput + 1] = mineBoard[userNewRowInput - 1][userNewColInput + 1];
            gameBoard[userNewRowInput + 1][userNewColInput] = mineBoard[userNewRowInput + 1][userNewColInput];
            gameBoard[userNewRowInput + 1][userNewColInput + 1] = mineBoard[userNewRowInput + 1][userNewColInput + 1];
            isAnalyzed = true;
        }

        //движение нагоре
        if(userRowInput > userNewRowInput && userColInput == userNewColInput) {
            gameBoard[userNewRowInput][userNewColInput] = mineBoard[userNewRowInput][userNewColInput];
            gameBoard[userNewRowInput][userNewColInput + 1] = mineBoard[userNewRowInput][userNewColInput + 1];
            gameBoard[userNewRowInput][userNewColInput - 1] = mineBoard[userNewRowInput][userNewColInput - 1];
            gameBoard[userNewRowInput - 1][userNewColInput] = mineBoard[userNewRowInput - 1][userNewColInput];
            gameBoard[userNewRowInput - 1][userNewColInput + 1] = mineBoard[userNewRowInput - 1][userNewColInput + 1];
            gameBoard[userNewRowInput - 1][userNewColInput - 1] = mineBoard[userNewRowInput - 1][userNewColInput -1];
            isAnalyzed = true;

        }

        // движение надолу
        if(userRowInput < userNewRowInput && userColInput == userNewColInput) {
            gameBoard[userNewRowInput][userNewColInput] = mineBoard[userNewRowInput][userNewColInput];
            gameBoard[userNewRowInput][userNewColInput + 1] = mineBoard[userNewRowInput][userNewColInput + 1];
            gameBoard[userNewRowInput][userNewColInput - 1] = mineBoard[userNewRowInput][userNewColInput - 1];
            gameBoard[userNewRowInput + 1][userNewColInput] = mineBoard[userNewRowInput + 1][userNewColInput];
            gameBoard[userNewRowInput + 1][userNewColInput - 1] = mineBoard[userNewRowInput + 1][userNewColInput - 1];
            gameBoard[userNewRowInput + 1][userNewColInput + 1] = mineBoard[userNewRowInput + 1][userNewColInput + 1];
            isAnalyzed = true;
        }
    }

    /**                          Метод, чрез който се осъществява движението по игралната дъска.
     *
     * @param gameBoard          Масив, от който се взимат данните за игралната дъска.
     * @param mineBoard          Дублиран масив на gameBoard, където се разполагат бомбите, което остава скрито от потребителя.
     * @param userRowInput       Старият ред, на който се намира играчът преди преместването.
     * @param userColInput       Старата колона, на която се намира играчът преди преместването.
     * @param userNewRowInput    Новия ред, на който ще бъде преместен играчът.
     * @param userNewColInput    Новата колона, на който ще бъде преместен играчът.
     */
    public static void moveWithoutDefusing(String[][] gameBoard, String[][] mineBoard,
                                           int userRowInput, int userColInput,
                                           int userNewRowInput, int userNewColInput)  {

        if (Player.isMoveValid(userRowInput, userColInput, userNewRowInput, userNewColInput)) {
            if (mineBoard[userNewRowInput][userNewColInput].equals(" N ")) {
                gameBoard[userNewRowInput][userNewColInput] = Player.PLAYER_SYMBOL;
                gameBoard[userRowInput][userColInput] = VISITED;
            } else if (mineBoard[userNewRowInput][userNewColInput].equals(mine)) {
                System.out.println("Стъпихте на бомба и загубихте играта!");
                isBombActivated = true;

            }
        } else System.out.println("Невалидни данни! Опитайте отново!");
    }


}

