package fmi.homework1;

public class Main {

    public static void main(String[] args) {

        calculatePerimeter();
        calucateSurfaceArea();
    }

    public static void calculatePerimeter() {
        int sideA = 2;
        int sideB = 6;
        int Perimeter = 2*sideA + 2*sideB;

        System.out.println("Периметърът на правоъгълника е " + Perimeter + " см.");
    }

    public static void calucateSurfaceArea() {
        int sideA = 2;
        int sideB = 6;
        int SurfaceArea = sideA*sideB;

        System.out.println("Лицето на правоъгълника е " + SurfaceArea + " см.");
    }

}
