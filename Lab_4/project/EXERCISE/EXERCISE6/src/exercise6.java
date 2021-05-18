import java.util.Scanner;
public class exercise6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int year, month, yu, yu2, days, run = 0;
        String monthname;
        System.out.println("Please enter the year and month: ");
        year = input.nextInt();
        month = input.nextInt();
        yu = year % 4;
        yu2 = year % 400;
        if( yu == 0 && yu2 == 400)
            run = 1;
        switch(month){
            case 1:
                days = 31;
                monthname = "January";
                System.out.printf("%s of %d has %d days.\n", monthname, year, days);
                break;
            case 2:
                monthname = "February";
                switch(run){
                    case 1:
                        days = 29;
                        System.out.printf("%s of %d has %d days.\n", monthname, year, days);
                        break;
                    case 0:
                        days = 28;
                        System.out.printf("%s of %d has %d days.\n", monthname, year, days);
                        break;
                }
                break;
            case 3:
                days = 31;
                monthname = "March";
                System.out.printf("%s of %d has %d days.\n", monthname, year, days);
                break;
            case 4:
                days = 30;
                monthname = "April";
                System.out.printf("%s of %d has %d days.\n", monthname, year, days);
                break;
            case 5:
                days = 31;
                monthname = "May";
                System.out.printf("%s of %d has %d days.\n", monthname, year, days);
                break;
            case 6:
                days = 30;
                monthname = "June";
                System.out.printf("%s of %d has %d days.\n", monthname, year, days);
                break;
            case 7:
                days = 31;
                monthname = "July";
                System.out.printf("%s of %d has %d days.\n", monthname, year, days);
                break;
            case 8:
                days = 31;
                monthname = "August";
                System.out.printf("%s of %d has %d days.\n", monthname, year, days);
                break;
            case 9:
                days = 30;
                monthname = "September";
                System.out.printf("%s of %d has %d days.\n", monthname, year, days);
                break;
            case 10:
                days = 31;
                monthname = "October";
                System.out.printf("%s of %d has %d days.\n", monthname, year, days);
                break;
            case 11:
                days = 30;
                monthname = "November";
                System.out.printf("%s of %d has %d days.\n", monthname, year, days);
                break;
            case 12:
                days = 31;
                monthname = "December";
                System.out.printf("%s of %d has %d days.\n", monthname, year, days);
                break;

        }

    }
}
