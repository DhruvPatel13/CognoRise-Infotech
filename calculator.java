
import java.util.InputMismatchException;
import java.util.Scanner;

public class calculator {
//    TASK 3 : CALCULATOR APP
    public static void main(String[] args) throws ArithmeticException,InputMismatchException {
        Scanner sc = new Scanner(System.in);
        myCalculator cal = new myCalculator();
        String ip = null;
        do {
            try {
                System.out.println("\nPlease select the operation you want to perform: '+', '-', '/', '*' (x or X for Exit).");
                ip = sc.nextLine().toLowerCase();
                switch (ip) {
                    case "+" -> cal.addition();
                    case "-" -> cal.subtraction();
                    case "/" -> cal.division();
                    case "*" -> cal.multiplication();
                    case "x" -> {System.out.println("Thank You for using my program");}
                    default -> System.out.println("Invalid Operator Selected!");
                }
            } catch (InputMismatchException ie) {
                System.out.println("Only numbers input Acceptable!");
                System.out.println("Turning off Calculator!!");
            } catch (ArithmeticException ae) {
                System.out.println("Dividing by Zero Not Allowed!");
            } catch (Exception e) {
                System.out.println(e);
            }

        }while (!ip.equalsIgnoreCase("x"));

    }
}

class myCalculator {
    Scanner sc = new Scanner(System.in);
    private double num1, num2;

    private double num1Ip(){
        System.out.println("Enter 1st number :");
        return sc.nextInt();
    }
    private double num2IP(){
        System.out.println("Enter 2nd number :");
        return sc.nextInt();
    }

    public void addition() throws InputMismatchException {
        num1 = num1Ip();
        num2 = num2IP();
        System.out.println("Sum of " + num1 + " & " + num2 + " is: " + (num1 + num2));

    }

    public void subtraction() throws InputMismatchException {
        num1 = num1Ip();
        num2 = num2IP();
        System.out.println("Subtraction of " + num1 + " & " + num2 + " is: " + (num1 - num2));
    }

    public void division() throws ArithmeticException, InputMismatchException {
        num1 = num1Ip();
        num2 = num2IP();
        System.out.println("Division of " + num1 + " & " + num2 + " is: " + (num1 / num2));
    }

    public void multiplication() throws InputMismatchException {
        num1 = num1Ip();
        num2 = num2IP();
        System.out.println("multiplication of " + num1 + " & " + num2 + " is: " + (num1 * num2));
    }
}