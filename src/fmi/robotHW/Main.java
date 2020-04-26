package fmi.robotHW;

import java.util.Random;
import java.util.Scanner;

public class Main {




    public static void main(String[] args) {

        int battery = 0;
        typeOfObstacle(battery);
    }

    public static int typeOfObstacle(int battery) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Въведете вид на препятствието пред робота (0 - нищо; 1 - стол; 2 - стена): ");
        int obstacle = scan.nextInt();
        if (obstacle == 0) {
            System.out.println("Няма препяствие пред робота.");
            goForward(battery);
        } else if (obstacle == 1) {
            System.out.println("Препятствието пред робота е стол.");
            Jump(battery);
        } else if (obstacle == 2) {
            System.out.println("Препятствието пред робота е стена.");
            goSideways(battery);
        }
        if (obstacle > 2 || obstacle < 0) {
            System.out.println("Неразпознат обект.");
            typeOfObstacle(battery);
        }

        return obstacle;
    }


    public static boolean findTheMouse() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Въведете броя на пикселите по хоризонтала: ");
        int pixelsA = scan.nextInt();
        System.out.println("Въведете броя на пикселите по вертикала: ");
        int pixelsB = scan.nextInt();

        if ((pixelsA * pixelsB) % 2 == 0) {
            System.out.println("Мишката е засечена.");
            return true;
        } else
            System.out.println("Няма засечена мишка. Роботът трябва да сканира отново.");
            findTheMouse();
            return false;

    }

    public static boolean checkBattery(int battery) {
        if ( battery > 0) {
            System.out.println("Роботът има достатъчно батерия, за да осъществи удар.");
            return true;
        }
        System.out.println("Роботът няма достатъчно батерия, за да осъществи удар. " +
                "Необходимо е да се насочи към контакт.");
        chargeBattery(battery);
        return false;
    }

    public static boolean chargeBattery(int battery) {
        Random random = new Random();
        int firstRandomNumber  = random.nextInt((1000-1) +1) + 1;
        int secondRandomNumber = random.nextInt((1000-1) +1) + 1;

        if (firstRandomNumber > secondRandomNumber) {
            System.out.println("Роботът намери работещ контакт. Батерията е заредена.");
            return true;
        } else if (firstRandomNumber == secondRandomNumber) {
            chargeBattery(battery);
        } else if (firstRandomNumber < secondRandomNumber) {
            System.out.println("В този контакт няма ток. Роботът се насочва към следвашия контакт.");
            chargeBattery(battery);
            return false;
        }
        return false;
    }


    public static boolean isTheHitOverwhelming() {
        Random random = new Random();
        int randomNumber = random.nextInt((10-1) +1) +1;
        if ( randomNumber != 5) {
            System.out.println("Ударът няма да бъде съкрушителен. Следователно роботът може да нападне мишката.");
            return false;
        } else {
            System.out.println("Ударът ще бъде съкрушителен за мебелите. Атаката ще бъде отложена.");
            return true;
        }

    }

    public static void jobIsDone() {
        for (int i=10; i>0; i--) {
            if (i % 2 == 0) {
                System.out.println(i + " I am Robotttt");
            } else System.out.println(i);
        }

    }

    public static void isAnotherSearchingWanted(int battery) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Желаете ли роботът да започне ново търсене (0 - не; 1 - да)");
        int decision = scan.nextInt();
        if (decision == 0) {
            System.out.println("Роботът няма да започне ново търсене.");
            System.out.println("Роботът се изключва.");
        } else if (decision == 1) {
            System.out.println("Роботът започва ново търсене.");
            typeOfObstacle(battery);
        }

        if (decision > 1 || decision < 0) {
            System.out.println("Невалидни входни данни. Опитайте отново.");
            isAnotherSearchingWanted(battery);
        }

    }

    public static void goForward(int battery) {
        System.out.println("Роботът тръгна напред.");
        findTheMouse();
        if (!checkBattery(battery)) {
            battery = 4;
        }

       if (!isTheHitOverwhelming()) {
            System.out.println("Мишката е убита.");
            jobIsDone();
            battery--;
        } else {
                System.out.println("Атаката се отлага.");
        }
        System.out.println("Ниво на батерията: "+battery);
        isAnotherSearchingWanted(battery);

    }

    public static void Jump(int battery){
        System.out.println("Роботът прескочи стола.");
        findTheMouse();
        if (!checkBattery(battery)) {
            battery = 4;
        }

        if (!isTheHitOverwhelming()) {
            System.out.println("Мишката е убита.");
            jobIsDone();
            battery--;
        } else {
                 System.out.println("Атаката се отлага.");
        }
        System.out.println("Ниво на батерията: "+battery);
        isAnotherSearchingWanted(battery);
    }

    public static void goSideways(int battery) {
        System.out.println("Роботът тръгна настрани.");
        findTheMouse();
        if (!checkBattery(battery)) {
            battery = 4;
        }

        if (!isTheHitOverwhelming()) {
            System.out.println("Мишката е убита.");
            jobIsDone();
            battery--;
        } else {
                System.out.println("Атаката се отлага.");
        }
        System.out.println("Ниво на батерията: "+battery);
        isAnotherSearchingWanted(battery);
    }

}


