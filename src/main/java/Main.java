import java.util.Scanner;

public class Main {

    // Initiate scanner as read.
    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {

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

        read.close();
    }

}
