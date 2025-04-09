import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("\n Calendar Tool");
            System.out.println("1. View Current Month");
            System.out.println("2. View Specific Month");
            System.out.println("3. Check Leap Year");
            System.out.println("4. Exit");
            System.out.printf("\n Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 : viewCurrentMonth();
                         break;
                case 2 : viewSpecificMonth(scanner);
                         break;
                case 3 : checkLeapYear(scanner);
                         break;
                case 4 : System.out.println("Exiting Calendar Tool.");
                         return;
                default : System.out.println("Invalid Choice. Try again.");
            }
        }
    }

    private static void checkLeapYear(Scanner scanner) {
        System.out.println("Enter year to check: ");
        int year = scanner.nextInt();

        if((year%4 == 0) && (year%100 != 0 || year%400 == 0)){
            System.out.println("It's a leap year.");
        }else{
            System.out.println("It is not a leap year.");
        }
    }

    private static void viewSpecificMonth(Scanner scanner) {
        System.out.println("Enter year: ");
        int year = scanner.nextInt();
        System.out.println("Enter month (1-12): ");
        int month = scanner.nextInt();
        displayMonth(year, month);
    }

    private static void viewCurrentMonth() {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        displayMonth(year, month);
    }

    private static void displayMonth(int year, int month) {
        YearMonth yearMonth = YearMonth.of(year, month);
        System.out.println("\n "+yearMonth.getMonth() + " " + year);
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");

        int firstDayOfMonth = yearMonth.atDay(1).getDayOfWeek().getValue() % 7;
        int daysInMonth = yearMonth.lengthOfMonth();

        for (int i=0; i<firstDayOfMonth; i++){
            System.out.print("    ");
        }

        for (int day=1; day<=daysInMonth; day++){
            System.out.printf("%4d", day);

            if ((day + firstDayOfMonth)%7 == 0 || day == daysInMonth){
                System.out.println();
            }
        }
    }

}