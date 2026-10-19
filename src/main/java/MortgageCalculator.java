
public class MortgageCalculator {

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
