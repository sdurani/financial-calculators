
public class FutureValueCalculator {

    final static int daysPerYear = 365;

    public static int calculateTotalNumDays(int investmentLength) {

        int totalNumDays = daysPerYear * investmentLength;
        return totalNumDays;
    }

    public static double calculateBracketsFutureValue(double cdAnnualInterestRatePercent, int totalNumDays) {

        double cdAnnualInterestRateDecimal = cdAnnualInterestRatePercent / 100;
        double bracketsFutureValue = Math.pow(1 + (cdAnnualInterestRateDecimal / daysPerYear), totalNumDays);
        return bracketsFutureValue;
    }

    public static double calculateFutureValue(double initialDeposit, double bracketsFutureValue) {

        double futureValue = initialDeposit * bracketsFutureValue;
        return futureValue;
    }

    public static double calculateTotalInterestEarned(double futureValue, double initialDeposit) {

        double totalInterestEarned = futureValue - initialDeposit;
        return totalInterestEarned;
    }

    public static void displayFinalMessage(double futureValue, double totalInterestEarned) {
        System.out.printf("Your expected future value is: $%.2f%n", futureValue);
        System.out.printf("Your total interest earned is: $%.2f%n", totalInterestEarned);
    }
}
