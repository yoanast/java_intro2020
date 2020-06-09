package fmi.DreamFactory;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Machine[] machines = new Machine[6];
        Scanner scanner = new Scanner(System.in);
        HeatManager heatManager1 = new HeatManager(new Engine[10]);
        heatManager1.initEngines(heatManager1.getEngines());
        heatManager1.printMaxEnginePower(heatManager1.getEngines());
        Machine.initMachines(scanner, machines);
        Machine.printMachinePower(machines);
    }


}
