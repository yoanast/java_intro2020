package fmi.MinefieldHW;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Application {

    public static int userRowInput;
    public static int userColInput;
    public static int userNewRowInput = 1;
    public static int userNewColInput;
    public static int numberOfProbes = 0;
    public static int numberOfDisposal = 0;

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

       File fileReference = new File("resources/enemy_territory.txt");
       File fileReference1 = new File("resources/configurations.txt");

        try {
            FileReader fileReader;
            BufferedReader bufferedReader;

            String lineReference;
            int gameBoardHeight;
            int gameBoardWidth;
            int mines;

            fileReader = new FileReader(fileReference);
            bufferedReader = new BufferedReader(fileReader);

            lineReference = bufferedReader.readLine();
            String[] result = lineReference.split("=");
            gameBoardHeight = Integer.parseInt(result[1]);

            lineReference = bufferedReader.readLine();
            result = lineReference.split("=");
            gameBoardWidth = Integer.parseInt(result[1]);

            lineReference = bufferedReader.readLine();
            result = lineReference.split("=");
            mines = Integer.parseInt(result[1]);

            String[][] gameBoard = new String[gameBoardHeight +1][gameBoardWidth +1];
            int[] boardInfo = new int[gameBoardWidth];
            String[][] mineBoard = new String[gameBoardHeight +1][gameBoardWidth +1];

            GameBoard.fillGameBoard(mineBoard, gameBoardHeight, gameBoardWidth, random, " N ", mineBoard);
            Mines.getRandomMineCoordinates(mineBoard,mines,gameBoardHeight,gameBoardWidth,random);
            GameBoard.fillGameBoard(gameBoard, gameBoardHeight, gameBoardWidth, random, " X ", mineBoard);
            GameBoard.catchNullValue(gameBoard, gameBoardHeight +1, gameBoardWidth +1);
            GameBoard.catchNullValue(mineBoard, gameBoardHeight +1, gameBoardWidth +1);

            fileReader = new FileReader(fileReference1);
            bufferedReader = new BufferedReader(fileReader);

            lineReference = bufferedReader.readLine();
            result = lineReference.split("=");
            numberOfProbes = Integer.parseInt(result[1]);

            lineReference = bufferedReader.readLine();
            result = lineReference.split("=");
            numberOfDisposal = Integer.parseInt(result[1]);
            fileReader.close();

            GameBoard.drawGameBoard(gameBoard, boardInfo, gameBoardHeight, gameBoardWidth);

           while (!GameBoard.isTheGameWon(gameBoard, userNewRowInput, userNewColInput)) {

               Player.getNewPosition();

               Mines.CombatOperationsMenu(scanner, gameBoard, mineBoard, numberOfDisposal,
                       userRowInput, userColInput, userNewRowInput, userNewColInput,
                       boardInfo, gameBoardHeight, gameBoardWidth);
           }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}