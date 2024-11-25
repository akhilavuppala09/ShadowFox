import java.util.InputMismatchException;
import java.util.Scanner;

public class EnhancedCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nWelcome to Enhanced Console-based Calculator!");
            System.out.println("==============================================");
            System.out.println("1. Basic Arithmetic");
            System.out.println("2. Scientific Calculations");
            System.out.println("3. Unit Conversions");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        basicArithmetic(scanner);
                        break;
                    case 2:
                        scientificCalculations(scanner);
                        break;
                    case 3:
                        unitConversions(scanner);
                        break;
                    case 4:
                        System.out.println("Exiting... Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
                choice = 0; // Reset choice to continue the loop
            }

        } while (choice != 4);

        scanner.close();
    }

    // Basic Arithmetic Operations with Error Handling
    public static void basicArithmetic(Scanner scanner) {
        try {
            System.out.println("\nBasic Arithmetic Operations:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.print("Enter your choice: ");
            int operation = scanner.nextInt();

            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();

            switch (operation) {
                case 1:
                    System.out.println("Result: " + (num1 + num2));
                    break;
                case 2:
                    System.out.println("Result: " + (num1 - num2));
                    break;
                case 3:
                    System.out.println("Result: " + (num1 * num2));
                    break;
                case 4:
                    if (num2 != 0) {
                        System.out.println("Result: " + (num1 / num2));
                    } else {
                        System.out.println("Error: Division by zero!");
                    }
                    break;
                default:
                    System.out.println("Invalid operation!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter numeric values.");
            scanner.next(); // Clear invalid input
        }
    }

    // Scientific Calculations with Error Handling
    public static void scientificCalculations(Scanner scanner) {
        try {
            System.out.println("\nScientific Calculations:");
            System.out.println("1. Square Root");
            System.out.println("2. Exponentiation");
            System.out.println("3. Logarithm (Base 10)");
            System.out.println("4. Natural Logarithm (Base e)");
            System.out.println("5. Sine");
            System.out.println("6. Cosine");
            System.out.println("7. Tangent");
            System.out.println("8. Factorial");
            System.out.print("Enter your choice: ");
            int operation = scanner.nextInt();

            switch (operation) {
                case 1:
                    System.out.print("Enter number: ");
                    double num = scanner.nextDouble();
                    if (num >= 0) {
                        System.out.println("Square Root: " + Math.sqrt(num));
                    } else {
                        System.out.println("Error: Negative number!");
                    }
                    break;
                case 2:
                    System.out.print("Enter base: ");
                    double base = scanner.nextDouble();
                    System.out.print("Enter exponent: ");
                    double exponent = scanner.nextDouble();
                    System.out.println("Result: " + Math.pow(base, exponent));
                    break;
                case 3:
                    System.out.print("Enter number: ");
                    num = scanner.nextDouble();
                    if (num > 0) {
                        System.out.println("Logarithm (Base 10): " + Math.log10(num));
                    } else {
                        System.out.println("Error: Non-positive number!");
                    }
                    break;
                case 4:
                    System.out.print("Enter number: ");
                    num = scanner.nextDouble();
                    if (num > 0) {
                        System.out.println("Natural Logarithm (Base e): " + Math.log(num));
                    } else {
                        System.out.println("Error: Non-positive number!");
                    }
                    break;
                case 5:
                    System.out.print("Enter angle in degrees: ");
                    double angle = Math.toRadians(scanner.nextDouble());
                    System.out.println("Sine: " + Math.sin(angle));
                    break;
                case 6:
                    System.out.print("Enter angle in degrees: ");
                    angle = Math.toRadians(scanner.nextDouble());
                    System.out.println("Cosine: " + Math.cos(angle));
                    break;
                case 7:
                    System.out.print("Enter angle in degrees: ");
                    angle = Math.toRadians(scanner.nextDouble());
                    System.out.println("Tangent: " + Math.tan(angle));
                    break;
                case 8:
                    System.out.print("Enter a non-negative integer: ");
                    int n = scanner.nextInt();
                    if (n >= 0) {
                        System.out.println("Factorial: " + factorial(n));
                    } else {
                        System.out.println("Error: Negative number!");
                    }
                    break;
                default:
                    System.out.println("Invalid operation!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter numeric values.");
            scanner.next(); // Clear invalid input
        }
    }

    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // Unit Conversions with Error Handling
    public static void unitConversions(Scanner scanner) {
        try {
            System.out.println("\nUnit Conversions:");
            System.out.println("1. Celsius to Fahrenheit");
            System.out.println("2. Fahrenheit to Celsius");
            System.out.println("3. Currency Conversion (USD to INR)");
            System.out.println("4. Kilometers to Miles");
            System.out.println("5. Miles to Kilometers");
            System.out.println("6. Kilograms to Pounds");
            System.out.println("7. Pounds to Kilograms");
            System.out.println("8. Minutes to Seconds");
            System.out.println("9. Seconds to Minutes");
            System.out.print("Enter your choice: ");
            int operation = scanner.nextInt();

            switch (operation) {
                case 1:
                    System.out.print("Enter temperature in Celsius: ");
                    double celsius = scanner.nextDouble();
                    System.out.println("Fahrenheit: " + (celsius * 9/5 + 32));
                    break;
                case 2:
                    System.out.print("Enter temperature in Fahrenheit: ");
                    double fahrenheit = scanner.nextDouble();
                    System.out.println("Celsius: " + ((fahrenheit - 32) * 5/9));
                    break;
                case 3:
                    System.out.print("Enter amount in USD: ");
                    double usd = scanner.nextDouble();
                    System.out.println("INR: " + (usd * 83.0)); // Example conversion rate
                    break;
                case 4:
                    System.out.print("Enter distance in Kilometers: ");
                    double km = scanner.nextDouble();
                    System.out.println("Miles: " + (km * 0.621371));
                    break;
                case 5:
                    System.out.print("Enter distance in Miles: ");
                    double miles = scanner.nextDouble();
                    System.out.println("Kilometers: " + (miles / 0.621371));
                    break;
                case 6:
                    System.out.print("Enter weight in Kilograms: ");
                    double kg = scanner.nextDouble();
                    System.out.println("Pounds: " + (kg * 2.20462));
                    break;
                case 7:
                    System.out.print("Enter weight in Pounds: ");
                    double pounds = scanner.nextDouble();
                    System.out.println("Kilograms: " + (pounds / 2.20462));
                    break;
                case 8:
                    System.out.print("Enter time in Minutes: ");
                    double minutes = scanner.nextDouble();
                    System.out.println("Seconds: " + (minutes * 60));
                    break;
                case 9:
                    System.out.print("Enter time in Seconds: ");
                    double seconds = scanner.nextDouble();
                    System.out.println("Minutes: " + (seconds / 60));
                    break;
                default:
                    System.out.println("Invalid operation!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter numeric values.");
            scanner.next(); // Clear invalid input
        }
    }
}
