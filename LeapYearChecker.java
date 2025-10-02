import java.util.Scanner;

public class LeapYearChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = 0; // Initialize year to avoid potential compilation error

        try {
            year = scanner.nextInt(); // Read the integer input
            if (isLeapYear(year)) {
                System.out.println(year + " is a leap year.");
            } else {
                System.out.println(year + " is not a leap year.");
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter an integer for the year.");
        } finally {
            scanner.close(); // Close the scanner to prevent resource leak
        }
    }

    /**
     * Checks if a given year is a leap year.
     * A year is a leap year if it is divisible by 4 but not by 100,
     * unless it is also divisible by 400.
     *
     * @param year The year to check.
     * @return true if the year is a leap year, false otherwise.
     */
    public static boolean isLeapYear(int year) {
        // Condition for a leap year:
        // (divisible by 4 AND not divisible by 100) OR (divisible by 400)
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}