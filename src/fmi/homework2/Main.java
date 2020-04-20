package fmi.homework2;

public class Main {

    public static void main(String[] args) {

        calculateNumberOfDays();

    }

    public static void calculateNumberOfDays () {
        String month = "Юни";

        if (month == "Януари" || month == "Март" || month == "Май" || month == "Юли" ||
                month == "Август" || month == "Октомври" || month == "Декември") {
            System.out.println("Месецът има 31 дни.");
        } else if (month == "Февруари")
                { System.out.println("Месецът има 28 дни."); }
            else if (month == "Април" ||  month == "Юни"|| month == "Септември" || month =="Ноември")
                    { System.out.println("Месецът има 30 дни."); }
                else
                    { System.out.println("Въведена е невалидна стойност!"); }

    }
}
