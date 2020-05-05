package fmi.kingisdead;

import java.util.Scanner;

public class KingIsDeadHW {

    static final byte PLAYER_WHITE_ID = 1;
    static final byte PLAYER_BLACK_ID = 2;

    static short player1Moves = 1;
    static short player2Moves = 1;

    static boolean isGameRunning = true;

    static String userRowInputString;
    static String userColInputString;
    static int userRowInputInt;
    static int userColInputInt;

    static String userNewRowInputString;
    static String userNewColInputString;
    static int userNewRowInputInt;
    static int userNewColInputInt;


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[][] gameBoard = new String[6][6];
        String[] boardInfo = new String[6];
        fillBoardInfo(boardInfo);
        fillGameBoard(gameBoard);
        drawGameBoard(gameBoard, boardInfo);
        System.out.println("It's Player 1's turn (white pieces). Please make sure you use Uppercase Letters.");
        while (isGameRunning) {

            getNewPosition(scanner);
            Action(gameBoard, boardInfo, scanner);
        }
    }

    public static void fillGameBoard(String[][] gameBoard) {

        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 5; j++) {
                gameBoard[i][j] = "   ";
            }
        }

        gameBoard[0][0] = "wDw";
        gameBoard[0][1] = "wD ";
        gameBoard[0][2] = "wQ ";
        gameBoard[0][3] = "wK ";
        gameBoard[0][4] = "wM ";
        gameBoard[0][5] = "wDw";

        gameBoard[5][0] = "bDw";
        gameBoard[5][1] = "bM ";
        gameBoard[5][2] = "bK ";
        gameBoard[5][3] = "bQ ";
        gameBoard[5][4] = "bD ";
        gameBoard[5][5] = "bDw";

    }

    public static void drawGameBoard(String[][] gameBoard, String[] boardInfo) {

            /* That's how the board is displayed in the console.

                  wDw | wD  | wQ  | wK  | wM  | wDw | A
                  -----------------------------------
                      |     |     |     |     |     | B
                  -----------------------------------
                      |     |     |     |     |     | C
                  -----------------------------------
                      |     |     |     |     |     | D
                  -----------------------------------
                      |     |     |     |     |     | E
                  -----------------------------------
                  bDw | bM  | bK  | bQ  | bD  | bDw | F
                  -----------------------------------
                    A     B     C     D     E     F
              */

        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 5; j++) {
                System.out.print(gameBoard[i][j]);
                System.out.print(" | ");
            }
            System.out.print(boardInfo[i]);
            System.out.println();
            System.out.print("-----------------------------------");
            System.out.println();


        }
        System.out.print(" A     B     C     D     E     F");
        System.out.println();


    }

    public static void fillBoardInfo(String[] boardInfo) {

        boardInfo[0] = "A";
        boardInfo[1] = "B";
        boardInfo[2] = "C";
        boardInfo[3] = "D";
        boardInfo[4] = "E";
        boardInfo[5] = "F";

    }

    public static void parseStringToIntForRow(String userRowInputString) {

        switch (userRowInputString) {
            case "A":
                userRowInputInt = 0;
                break;

            case "B":
                userRowInputInt = 1;
                break;

            case "C":
                userRowInputInt = 2;
                break;

            case "D":
                userRowInputInt = 3;
                break;

            case "E":
                userRowInputInt = 4;
                break;

            case "F":
                userRowInputInt = 5;
                break;
            default:
                System.out.println("Invalid Input! Please try again!");
                break;
        }

    }

    public static void parseStringToIntForCol(String userColInputString) {

        switch (userColInputString) {
            case "A":
                userColInputInt = 0;
                break;

            case "B":
                userColInputInt = 1;
                break;

            case "C":
                userColInputInt = 2;
                break;

            case "D":
                userColInputInt = 3;
                break;

            case "E":
                userColInputInt = 4;
                break;

            case "F":
                userColInputInt = 5;
                break;
            default:
                System.out.println("Invalid Input! Please try again!");
                break;

        }

    }

    public static void parseStringToIntForNewRow(String userNewRowInputString) {

        switch (userNewRowInputString) {
            case "A":
                userNewRowInputInt = 0;
                break;

            case "B":
                userNewRowInputInt = 1;
                break;

            case "C":
                userNewRowInputInt = 2;
                break;

            case "D":
                userNewRowInputInt = 3;
                break;

            case "E":
                userNewRowInputInt = 4;
                break;

            case "F":
                userNewRowInputInt = 5;
                break;
            default:
                System.out.println("Invalid Input! Please try again!");
                break;
        }

    }

    public static void parseStringToIntForNewCol(String userNewColInputString) {

        switch (userNewColInputString) {
            case "A":
                userNewColInputInt = 0;
                break;

            case "B":
                userNewColInputInt = 1;
                break;

            case "C":
                userNewColInputInt = 2;
                break;

            case "D":
                userNewColInputInt = 3;
                break;

            case "E":
                userNewColInputInt = 4;
                break;

            case "F":
                userNewColInputInt = 5;
                break;
            default:
                System.out.println("Invalid Input! Please try again!");
                break;
        }

    }

    public static void getNewPosition(Scanner scanner) {

        System.out.println("Please input the current row of the figure you want to move: ");
        userRowInputString = scanner.nextLine();
        parseStringToIntForRow(userRowInputString);
        //System.out.println(userRowInputInt);

        System.out.println("Please input the current col of the figure you want to move: ");
        userColInputString = scanner.nextLine();
        parseStringToIntForCol(userColInputString);
        //System.out.println(userColInputInt);

        System.out.println("Please input the new row of the figure you want to move: ");
        userNewRowInputString = scanner.nextLine();
        parseStringToIntForNewRow(userNewRowInputString);
        //System.out.println(userNewRowInputInt);

        System.out.println("Please input the new col of the figure you want to move: ");
        userNewColInputString = scanner.nextLine();
        parseStringToIntForNewCol(userNewColInputString);
        //System.out.println(userNewColInputInt);

    }

    public static void moveBlackKing(String[][] gameBoard, String[] boardInfo, Scanner scanner) {

        if (userNewRowInputInt == (userRowInputInt -1) | userNewColInputInt == (userColInputInt - 1)) {
            if (gameBoard[userNewRowInputInt][userNewColInputInt] != "bDw" &
                    gameBoard[userNewRowInputInt][userNewColInputInt] != "bD " &
                    gameBoard[userNewRowInputInt][userNewColInputInt] != "bQ " &
                    gameBoard[userNewRowInputInt][userNewColInputInt] != "bM ") {

                        System.out.println("Success positioning! It is Player " + PLAYER_WHITE_ID + "'s turn now.");
                        isTheWhiteKingDead(gameBoard);
                        gameBoard[userNewRowInputInt][userNewColInputInt] = "bK ";
                        gameBoard[userRowInputInt][userColInputInt] = "   ";
                        drawGameBoard(gameBoard, boardInfo);
                        player2Moves++;
            } else {
                System.out.println("This cell is occupied by your own figure! Try again!");
                getNewPosition(scanner);
            }
        } else {
            System.out.println("The Black King can't move that way. Try again!");
            getNewPosition(scanner);
        }
    }

    public static void moveBlackDwarfs(String[][] gameBoard, String[] boardInfo, Scanner scanner) {

        if (userNewRowInputInt == (userRowInputInt - 1)) {
            if     (gameBoard[userNewRowInputInt][userNewColInputInt] != "bD " &
                    gameBoard[userNewRowInputInt][userNewColInputInt] != "bQ " &
                    gameBoard[userNewRowInputInt][userNewColInputInt] != "bK " &
                    gameBoard[userNewRowInputInt][userNewColInputInt] != "bM ") {

                        System.out.println("Success positioning! It is Player " + PLAYER_WHITE_ID + "'s turn now.");
                        isTheWhiteKingDead(gameBoard);
                        gameBoard[userNewRowInputInt][userNewColInputInt] = "bDw";
                        gameBoard[userRowInputInt][userColInputInt] = "   ";
                        drawGameBoard(gameBoard, boardInfo);
                        player2Moves++;

            } else {
                System.out.println("This cell is occupied by your own figure! Try again!");
                getNewPosition(scanner);
            }
        } else {
            System.out.println("The Black Dwarf can't move that way. Try again!");
            getNewPosition(scanner);
        }
    }

    public static void moveBlackDonkey(String[][] gameBoard, String[] boardInfo, Scanner scanner) {

        if (player2Moves % 3 == 0) {
            if (userNewRowInputInt == (userRowInputInt -2) || userNewColInputInt == (userColInputInt - 2)) {
                if (gameBoard[userNewRowInputInt][userNewColInputInt] != "bDw" &
                        gameBoard[userNewRowInputInt][userNewColInputInt] != "bK " &
                        gameBoard[userNewRowInputInt][userNewColInputInt] != "bQ " &
                        gameBoard[userNewRowInputInt][userNewColInputInt] != "bM ") {

                            System.out.println("Success positioning! It is Player " + PLAYER_WHITE_ID + "'s turn now.");
                            isTheWhiteKingDead(gameBoard);
                            gameBoard[userNewRowInputInt][userNewColInputInt] = "bD ";
                            gameBoard[userRowInputInt][userColInputInt] = "   ";
                            drawGameBoard(gameBoard, boardInfo);
                            player2Moves++;

                } else {
                    System.out.println("This cell is occupied by your own figure! Try again!");
                    getNewPosition(scanner);
                }
            }
        } else {
            System.out.println("You should reach 3 moves to be able to move this figure!");
            getNewPosition(scanner);
        }
    }

    public static void moveBlackQueen(String[][] gameBoard, String[] boardInfo, Scanner scanner) {

        if (userNewRowInputInt == (userRowInputInt -1) | userNewColInputInt == (userColInputInt - 1)) {
            if     (gameBoard[userNewRowInputInt][userNewColInputInt] != "bDw" &
                    gameBoard[userNewRowInputInt][userNewColInputInt] != "bD " &
                    gameBoard[userNewRowInputInt][userNewColInputInt] != "bK " &
                    gameBoard[userNewRowInputInt][userNewColInputInt] != "bM ") {

                        System.out.println("Success positioning! It is Player " + PLAYER_WHITE_ID + "'s turn now.");
                        isTheWhiteKingDead(gameBoard);
                        gameBoard[userNewRowInputInt][userNewColInputInt] = "bQ ";
                        gameBoard[userRowInputInt][userColInputInt] = "   ";
                        drawGameBoard(gameBoard, boardInfo);
                        player2Moves++;

            } else {
                System.out.println("This cell is occupied by your own figure! Try again!");
                getNewPosition(scanner);
            }
        } else {
            System.out.println("The Black Queen can't move that way. Try again!");
            getNewPosition(scanner);
        }
    }

    public static void moveBlackMachineGun(String[][] gameBoard, String[] boardInfo, Scanner scanner) {

        if (userNewRowInputInt == (userRowInputInt -1) || userNewColInputInt == (userColInputInt - 1)) {
            if (gameBoard[userNewRowInputInt][userNewColInputInt] != "bDw" &
                    gameBoard[userNewRowInputInt][userNewColInputInt] != "bD " &
                    gameBoard[userNewRowInputInt][userNewColInputInt] != "bK " &
                    gameBoard[userNewRowInputInt][userNewColInputInt] != "bQ ") {

                        System.out.println("Success positioning! It is Player " + PLAYER_WHITE_ID + "'s turn now.");
                        isTheWhiteKingDead(gameBoard);
                        gameBoard[userNewRowInputInt][userNewColInputInt] = "bM ";
                        gameBoard[userRowInputInt][userColInputInt] = "   ";
                        drawGameBoard(gameBoard, boardInfo);
                        player2Moves++;

            } else {
                System.out.println("This cell is occupied by your own figure! Try again!");
                getNewPosition(scanner);
            }
        } else {
            System.out.println("The Black Machine gun can't move that way. Try again!");
            getNewPosition(scanner);
        }

    }

    public static void moveWhiteKing(String[][] gameBoard, String[] boardInfo, Scanner scanner) {

        if (userNewRowInputInt == (userRowInputInt +1) || userNewColInputInt == (userColInputInt + 1)) {
            if (gameBoard[userNewRowInputInt][userNewColInputInt] != "wDw" &
                    gameBoard[userNewRowInputInt][userNewColInputInt] != "wD " &
                    gameBoard[userNewRowInputInt][userNewColInputInt] != "wQ " &
                    gameBoard[userNewRowInputInt][userNewColInputInt] != "wM ") {

                        System.out.println("Success positioning! It is Player " + PLAYER_BLACK_ID + "'s turn now.");
                        isTheBlackKingDead(gameBoard);
                        gameBoard[userNewRowInputInt][userNewColInputInt] = "wK ";
                        gameBoard[userRowInputInt][userColInputInt] = "   ";
                        drawGameBoard(gameBoard, boardInfo);
                        player1Moves++;

            } else {
                System.out.println("This cell is occupied by your own figure! Try again!");
                getNewPosition(scanner);
            }
        } else {
            System.out.println("The White King can't move that way. Try again!");
            getNewPosition(scanner);
        }
    }

    public static void moveWhiteDwarfs(String[][] gameBoard, String[] boardInfo, Scanner scanner) {

        if (userNewRowInputInt == (userRowInputInt + 1)) {
            if (gameBoard[userNewRowInputInt][userNewColInputInt] != "wD " &
                    gameBoard[userNewRowInputInt][userNewColInputInt] != "wQ " &
                    gameBoard[userNewRowInputInt][userNewColInputInt] != "wK " &
                    gameBoard[userNewRowInputInt][userNewColInputInt] != "wM ") {

                        System.out.println("Success positioning! It is Player " + PLAYER_BLACK_ID + "'s turn now.");
                        isTheBlackKingDead(gameBoard);
                        gameBoard[userNewRowInputInt][userNewColInputInt] = "wDw";
                        gameBoard[userRowInputInt][userColInputInt] = "   ";
                        drawGameBoard(gameBoard, boardInfo);
                        player1Moves++;

            } else {
                System.out.println("This cell is occupied by your own figure! Try again!");
                getNewPosition(scanner);
            }
        } else {
            System.out.println("The White Dwarf can't move that way. Try again!");
            getNewPosition(scanner);
        }
    }

    public static void moveWhiteQueen(String[][] gameBoard, String[] boardInfo, Scanner scanner) {

        if (userNewRowInputInt == (userRowInputInt +1) || userNewColInputInt == (userColInputInt +1)) {
            if (gameBoard[userNewRowInputInt][userNewColInputInt] != "wDw" &
                    gameBoard[userNewRowInputInt][userNewColInputInt] != "wD " &
                    gameBoard[userNewRowInputInt][userNewColInputInt] != "wK " &
                    gameBoard[userNewRowInputInt][userNewColInputInt] != "wM ") {

                        System.out.println("Success positioning! It is Player " + PLAYER_BLACK_ID + "'s turn now.");
                        isTheBlackKingDead(gameBoard);
                        gameBoard[userNewRowInputInt][userNewColInputInt] = "wQ ";
                        gameBoard[userRowInputInt][userColInputInt] = "   ";
                        drawGameBoard(gameBoard, boardInfo);
                        player1Moves++;

            } else {
                System.out.println("This cell is occupied by your own figure! Try again!");
                getNewPosition(scanner);
            }
        } else {
            System.out.println("The White Queen can't move that way. Try again!");
            getNewPosition(scanner);
        }

    }

    public static void moveWhiteDonkey(String[][] gameBoard, String[] boardInfo, Scanner scanner) {

        if (player1Moves % 3 == 0) {
            if (userNewRowInputInt == (userRowInputInt +2) || userNewColInputInt == (userColInputInt +2)) {
                if (gameBoard[userNewRowInputInt][userNewColInputInt] != "wDw" &
                        gameBoard[userNewRowInputInt][userNewColInputInt] != "wK " &
                        gameBoard[userNewRowInputInt][userNewColInputInt] != "wQ " &
                        gameBoard[userNewRowInputInt][userNewColInputInt] != "wM ") {

                            System.out.println("Success positioning! It is Player " + PLAYER_BLACK_ID + "'s turn now.");
                            isTheBlackKingDead(gameBoard);
                            gameBoard[userNewRowInputInt][userNewColInputInt] = "wD ";
                            gameBoard[userRowInputInt][userColInputInt] = "   ";
                            drawGameBoard(gameBoard, boardInfo);
                            player1Moves++;

                } else {
                    System.out.println("This cell is occupied by your own figure! Try again!");
                    getNewPosition(scanner);
                }
            }
        } else {
            System.out.println("You should reach 3 moves to be able to move this figure!");
            getNewPosition(scanner);
        }
    }

    public static void moveWhiteMachineGun(String[][] gameBoard, String[] boardInfo, Scanner scanner) {

        if (userNewRowInputInt == (userRowInputInt - 1) || userNewColInputInt == (userColInputInt + 1)) {
            if (gameBoard[userNewRowInputInt][userNewColInputInt] != "wDw" &
                    gameBoard[userNewRowInputInt][userNewColInputInt] != "wD " &
                    gameBoard[userNewRowInputInt][userNewColInputInt] != "wK " &
                    gameBoard[userNewRowInputInt][userNewColInputInt] != "wQ ") {

                        System.out.println("Success positioning! It is Player " + PLAYER_BLACK_ID + "'s turn now.");
                        isTheBlackKingDead(gameBoard);
                        gameBoard[userNewRowInputInt][userNewColInputInt] = "wM ";
                        gameBoard[userRowInputInt][userColInputInt] = "   ";
                        drawGameBoard(gameBoard, boardInfo);
                        player1Moves++;

            } else {
                System.out.println("This cell is occupied by your own figure! Try again!");
                getNewPosition(scanner);
            }
        } else {
            System.out.println("The White Machine gun can't move that way. Try again!");
            getNewPosition(scanner);
        }
    }

    public static void isTheWhiteKingDead(String[][] gameBoard) {

        if (gameBoard[userNewRowInputInt][userNewColInputInt] == "wK ") {

            System.out.println("The White King is dead! Player " + PLAYER_BLACK_ID + " won the game!");
            System.out.println("Game is over!");
            isGameRunning = false;
        }
    }

    public static void isTheBlackKingDead(String[][] gameBoard) {

        if (gameBoard[userNewRowInputInt][userNewColInputInt] == "bK ") {

            System.out.println("The Black King is dead! Player " + PLAYER_WHITE_ID + " won the game!");
            System.out.println("Game is over!");
            isGameRunning = false;
        }
    }

    public static void Action(String[][] gameBoard, String[] boardInfo, Scanner scanner) {

        switch (gameBoard[userRowInputInt][userColInputInt]) {

            case "wDw":
                moveWhiteDwarfs(gameBoard, boardInfo, scanner);
                break;
            case "wD ":
                moveWhiteDonkey(gameBoard, boardInfo, scanner);
                break;
            case "wQ ":
                moveWhiteQueen(gameBoard, boardInfo, scanner);
                break;
            case "wK ":
                moveWhiteKing(gameBoard, boardInfo, scanner);
                break;
            case "wM ":
                moveWhiteMachineGun(gameBoard, boardInfo, scanner);
                break;
            case "bDw":
                moveBlackDwarfs(gameBoard, boardInfo, scanner);
                break;
            case "bD ":
                moveBlackDonkey(gameBoard, boardInfo, scanner);
                break;
            case "bQ ":
                moveBlackQueen(gameBoard, boardInfo, scanner);
                break;
            case "bK ":
                moveBlackKing(gameBoard, boardInfo, scanner);
                break;
            case "bM ":
                moveBlackMachineGun(gameBoard, boardInfo, scanner);
                break;
            default:
                System.out.println("Invalid input!");
                break;
        }
    }
    
}




