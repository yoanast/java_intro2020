package fmi.DreamFactory;

import java.util.ArrayList;

public class Person {

    private String name;

    ArrayList<Machine> machineList = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Machine> getMachineList() {
        return machineList;
    }

}
