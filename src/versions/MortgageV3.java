package versions;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class MortgageV3 {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;
    public static void main(String[] args){

        final int MIN_MONEY = 1000;
        final int MAX_MONEY = 1_000_000;
        final int MIN_ANNUALVALUE = 1;
        final int MAX_ANNUALVALUE = 30;
        final int MIN_PERIOD = 1;
        final int MAX_PERIOD = 30;
        

        int principalValue = 0;

        byte period = 0;
        float annualInterestRate = 0;
            
        principalValue = (int) readNumber("Principal: ", MIN_MONEY, MAX_MONEY);
        annualInterestRate = (float) readNumber("Annual Interest Rate: ", MIN_ANNUALVALUE, MAX_ANNUALVALUE);
        period = (byte) readNumber("Period (Years): ", MIN_PERIOD, MAX_PERIOD);
           
        printMortgage(principalValue, period, annualInterestRate);

        printPaymentSchedule(principalValue, period, annualInterestRate);
        System.out.println("");

    }

    private static void printMortgage(int principalValue, byte period, float annualInterestRate) {
        double mortgage = calculateMortgage(principalValue, annualInterestRate, period);
        
        String mortgageFormatted = NumberFormat.getCurrencyInstance(new Locale.Builder().setLanguage("en").setRegion("US").build()).format(mortgage);
        System.out.println("\nMORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }

    private static void printPaymentSchedule(int principalValue, byte period, float annualInterestRate) {
        System.out.println("\nPAYMENT SCHEDULE");
        System.out.println("--------");
        for(short month = 1; month <= period * MONTHS_IN_YEAR; month++){
            double balance = calculateRemains(principalValue, annualInterestRate, period, month);
            String balanceFormatted = NumberFormat.getCurrencyInstance(new Locale.Builder().setLanguage("en").setRegion("US").build()).format(balance);
            System.out.println(balanceFormatted);
        }
    }

    public static double readNumber(String prompt, double min, double max){
        Scanner scanner = new Scanner(System.in);
        double value;

        while(true){
            System.out.print(prompt);
            value = scanner.nextFloat();
            if(value >= min && value <= max)
                break;
            System.out.println("Enter a value between " +min + " and " +max); 
      
        }
        return value;
    }

    public static double calculateMortgage(int principalValue, float annualInterestRate, byte period){

        short numberOfPayments = (short)(period * MONTHS_IN_YEAR);
        float monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;

        double mortgageCalc = principalValue * ( monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, numberOfPayments)) / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1 ));

        return mortgageCalc;
    }

    public static double calculateRemains(int principalValue, float annualInterestRate, byte period, short numberOfPaymentsMade){

        short numberOfPayments = (short)(period * MONTHS_IN_YEAR);
        float monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;

        double remainsCalc = principalValue * ((Math.pow(1 + monthlyInterestRate, numberOfPayments)) - (Math.pow(1 + monthlyInterestRate, numberOfPaymentsMade))) / (Math.pow(1 + monthlyInterestRate, numberOfPayments)-1);
        
        return remainsCalc;
    }


}


