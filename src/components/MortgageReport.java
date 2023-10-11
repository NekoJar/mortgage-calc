package components;

import java.text.NumberFormat;
import java.util.Locale;

public class MortgageReport {
    private MortgageCalculator mortgageCalculator;

    public MortgageReport(MortgageCalculator mortgageCalculator) {
        this.mortgageCalculator = mortgageCalculator;
    }

    public void printMortgage() {
        double mortgage = mortgageCalculator.calculateMortgage();
        
        String mortgageFormatted = NumberFormat.getCurrencyInstance(new Locale.Builder().setLanguage("en").setRegion("US").build()).format(mortgage);
        System.out.println("\nMORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }

    public void printPaymentSchedule() {
        System.out.println("\nPAYMENT SCHEDULE");
        System.out.println("--------");
        for(double balance : mortgageCalculator.getRemainingBalance()){
            String balanceFormatted = NumberFormat.getCurrencyInstance(new Locale.Builder().setLanguage("en").setRegion("US").build()).format(balance);
            System.out.println(balanceFormatted);
        }
    }
}
