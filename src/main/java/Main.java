import java.util.Scanner;

public class Main {

    // Initiate scanner as read.
    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {

        // Display calculator menu options
        System.out.println("\nWhich calculator would you like to use? (type 1 or 2)");
        System.out.println("1. Mortgage Calculator");
        System.out.println("2. Future Value Calculator");

        int calculatorChoice = read.nextInt();


        if (calculatorChoice == 1) {

            System.out.println("\n------------ Welcome to the Mortgage Calculator! ------------\n");
            System.out.println("What is the principal amount?");
            double principalAmt = read.nextDouble();
            System.out.println("What is the annual interest rate (percent)?");
            double annualInterestRate = read.nextDouble();
            System.out.println("What is the loan length (years)?");
            int loanLength = read.nextInt();

            int numOfMoPayments = MortgageCalculator.calculateNumOfMoPayments(loanLength);
            double monthlyPayment = MortgageCalculator.calculateMonthlyPayment(principalAmt, annualInterestRate, numOfMoPayments);
            double totalInterest = MortgageCalculator.calculateTotalInterest(monthlyPayment, numOfMoPayments, principalAmt);

            MortgageCalculator.displayFinalMessage(monthlyPayment, totalInterest);
        }
        else if (calculatorChoice == 2) {

            System.out.println("------------ Welcome to the CD Future Value Calculator! ------------\n");
            System.out.println("What is the deposit amount?");
            double initialDeposit = read.nextDouble();
            System.out.println("What is the annual interest rate (percent)?");
            double cdAnnualInterestRatePercent = read.nextDouble();
            System.out.println("What is the investment length (years)?");
            int investmentLength = read.nextInt();

            int totalNumDays = FutureValueCalculator.calculateTotalNumDays(investmentLength);
            double bracketsFutureValue = FutureValueCalculator.calculateBracketsFutureValue(cdAnnualInterestRatePercent, totalNumDays);
            double futureValue = FutureValueCalculator.calculateFutureValue(initialDeposit, bracketsFutureValue);
            double totalInterestEarned = FutureValueCalculator.calculateTotalInterestEarned(futureValue, initialDeposit);

            FutureValueCalculator.displayFinalMessage(futureValue, totalInterestEarned);
        }
        else {
            System.out.println("Invalid selection. Please type 1 or 2.");
        }

        read.close();
    }
}
