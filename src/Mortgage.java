import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Mortgage {
    public static void main(String[] args){
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        final int MIN_MONEY = 1000;
        final int MAX_MONEY = 1_000_000;
        final int MIN_ANNUALVALUE = 0;
        final int MAX_ANNUALVALUE = 30;
        final int MIN_PERIOD = 0;
        final int MAX_PERIOD = 30;

        int pricipalValue = 0;

        float monthlyInterestRate = 0;
        int numberOfPayments = 0;

        Scanner input = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        while(true){

            while (true){
                System.out.print("Principal ($1K - $1M ): ");
                pricipalValue = input.nextInt();
                if(pricipalValue < MIN_MONEY || pricipalValue > MAX_MONEY){
                    System.out.println("Enter a number between 1,000 and 1,000,000");
                    continue;
                }
                break;
            }

            while(true){
                System.out.print("Annual Interest Rate: ");
                float annualInterestRate = input.nextFloat();
                if(annualInterestRate <= MIN_ANNUALVALUE || annualInterestRate > MAX_ANNUALVALUE){
                    System.out.println("Enter a value greater than 0 and less than or equal to 30");
                    continue;
                }
                monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
                break;
            }

            while(true){
                System.out.print("Period (Years): ");
                int period = input.nextInt();
                if(period <= MIN_PERIOD || period > MAX_PERIOD){
                    System.out.println("Enter a value between 1 and 30");
                    continue;
                }
                numberOfPayments = period * MONTHS_IN_YEAR;
                break;
            }

            double mortgageCalc = pricipalValue * ( monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, numberOfPayments)) / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1 ));
            
            String mortgageFormatted = NumberFormat.getCurrencyInstance(new Locale.Builder().setLanguage("en").setRegion("US").build()).format(mortgageCalc);
            // String mortgageDecimalFormatted = decimalFormat.format(mortgageFormatted);

            System.out.println("Mortgage: " + mortgageFormatted);
            break;
        }

    }
}
