package fmi.DreamFactory;

import java.util.Random;
import java.util.Scanner;

public class Machine {

    int power;
    int height;
    String color;

    public Machine(int power, int height, String color) {
        this.power = power;
        this.height = height;
        this.color = color;
    }

    public int getPower() {
        return power;
    }

    public int getHeight() {
        return height;
    }

    public String getColor() {
        return color;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static void initMachines(Scanner scanner, Machine[] machines) {

        Random random = new Random();

        for (int i = 0; i <= 2; i++) {
            machines[i]= new Machine(random.nextInt(100) +1, random.nextInt(5) + 1, "black");
        }
        for (int i = 3; i <= 5; i++) {
            machines[i]= new Machine(random.nextInt(100) +1, random.nextInt(5) + 1, "gray");
        }
    }

    public static void printMachinePower(Machine[] machines) {

        for (int i = 0; i <= machines.length - 1; i++) {

            System.out.println("Machine с номер "+ (i+1) + " има " + machines[i].getPower() + " power.");

        }

    }
}
