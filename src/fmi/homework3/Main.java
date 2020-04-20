package fmi.homework3;

public class Main {

    public static void main(String[] args) {

    greetTheNeighbors();

    }

    public static void greetTheNeighbors() {

        int floorNumber = 8;
        String floorName;

        switch(floorNumber) {
            case 8:
                floorName = "Етаж 8";
                System.out.println("Здравей, Мими!");
            case 7:
                floorName = "Етаж 7";
                System.out.println("Здравей, Пепи!");
            case 6:
                floorName = "Етаж 6";
                System.out.println("Здравей, Ваня!");
            case 5:
                floorName = "Етаж 5";
                System.out.println("Здравей, Кате!");
            case 4:
                floorName = "Етаж 4";
                System.out.println("Здравей, Габи!");
            case 3:
                floorName = "Етаж 3";
                System.out.println("Здравей, Сиси!");
            case 2:
                floorName = "Етаж 2";
                System.out.println("Здравей, Теди!");
            case 1:
                floorName = "Етаж 1";
                System.out.println("Здравей, Ники!");
            case 0:
                floorName = "Тротоар";
                System.out.println("Ауч!");
                break;

        }
    }
}
