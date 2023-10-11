package components;
public class Main {
    public static void main(String[] args){

        final int MIN_MONEY = 1000;
        final int MAX_MONEY = 1_000_000;
        final int MIN_ANNUALVALUE = 1;
        final int MAX_ANNUALVALUE = 30;
        final int MIN_PERIOD = 1;
        final int MAX_PERIOD = 30;

        int principalValue = (int) Console.readNumber("Principal: ", MIN_MONEY, MAX_MONEY);
        float annualInterestRate = (float) Console.readNumber("Annual Interest Rate: ", MIN_ANNUALVALUE, MAX_ANNUALVALUE);
        byte period = (byte) Console.readNumber("Period (Years): ", MIN_PERIOD, MAX_PERIOD);
           
        var mortgageCalculator = new MortgageCalculator(principalValue, annualInterestRate, period);
        var report = new MortgageReport(mortgageCalculator);
        report.printMortgage();
        report.printPaymentSchedule();

        System.out.println("");

    }

    


}


