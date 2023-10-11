package versions;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class MortgageV1 {
    public static void main(String[] args){
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner input = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        System.out.print("Principal: ");
        int pricipalValue = input.nextInt();

        System.out.print("Annual Interest Rate: ");
        float annualInterestRate = input.nextFloat();
        float monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;

        System.out.print("Period (Years): ");
        int period = input.nextInt();
        int numberOfPayments = period * MONTHS_IN_YEAR;

        double mortgageCalc = pricipalValue * ( monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, numberOfPayments)) / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1 ));
        
        String mortgageFormatted = NumberFormat.getCurrencyInstance(new Locale.Builder().setLanguage("en").setRegion("US").build()).format(mortgageCalc);
        // String mortgageDecimalFormatted = decimalFormat.format(mortgageFormatted);

        System.out.print("Mortgage: " + mortgageFormatted);



    }
}
