import java.util.Scanner;

public class MortgageCalculator {

    // Initiate scanner as read.
    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("What is the principal amount?");
        double principalAmt = read.nextDouble();
        System.out.println("What is the interest rate?");
        double annualInterestRate = read.nextDouble();
        System.out.println("What is the loan length (years)?");
        int loanLength = read.nextInt();

        int numOfMoPayments = calculateNumOfMoPayments(loanLength);
        double monthlyPayment = calculateMonthlyPayment(principalAmt, annualInterestRate, numOfMoPayments);
        double totalInterest = calculateTotalInterest(monthlyPayment, numOfMoPayments, principalAmt);

        displayFinalMessage(monthlyPayment, totalInterest);

        read.close();
    }

    public static int calculateNumOfMoPayments(int loanLength) {
        int numOfMoPayments = loanLength * 12;

        return numOfMoPayments;
    }

    public static double calculateMonthlyPayment(double principalAmt, double annualInterestRate, int numOfMoPayments) {
        double monthlyInterestRate = annualInterestRate / (100 * 12);

        double numerator = monthlyInterestRate * Math.pow((1 + monthlyInterestRate), numOfMoPayments);
        double denominator = Math.pow(1 + monthlyInterestRate, numOfMoPayments) - 1;
        double monthlyPayment = principalAmt * (numerator / denominator);

        return monthlyPayment;
    }

    public static double calculateTotalInterest(double monthlyPayment, int numOfMoPayments, double principalAmt) {

        double totalInterest = (monthlyPayment * numOfMoPayments) - principalAmt;

        return totalInterest;
    }

    public static void displayFinalMessage(double monthlyPayment, double totalInterest) {
        System.out.printf("Your expected monthly payment is: $%.2f%n", monthlyPayment);
        System.out.printf("Your total interest is: $%.2f%n", totalInterest);
    }
}
