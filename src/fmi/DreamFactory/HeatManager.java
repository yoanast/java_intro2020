package fmi.DreamFactory;

import java.util.Random;

public class HeatManager {
    Engine[] engines;


    public HeatManager(Engine[] engines) {
        this.engines = engines;
    }

    public Engine[] getEngines() {
        return engines;
    }


    public  void initEngines(Engine[] engines) {
        Random random = new Random();

        for (int i = 0; i <= 4; i++) {
            engines[i]= new WrapperEngine(random.nextInt(100)+1);
        }
        for (int i = 5; i <= 9; i++) {
            engines[i]= new HeatEngine(random.nextInt(100)+1);
        }

    }

    public void printMaxEnginePower(Engine[] engines) {
        int sum = 0;

        for (int i = 0; i <= engines.length - 1; i++) {

            System.out.println("Engine с номер "+ (i+1) + " има " + engines[i].getPower() + " power.");
            sum += engines[i].getPower();
        }
        System.out.println("Общия power на Engine е: " + sum);
        System.out.println();
    }

}
