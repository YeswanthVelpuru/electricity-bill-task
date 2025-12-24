import java.util.Scanner;

public class Main {

    static final String NL = "\n";   // FORCE UNIX newline

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Calculate Electricity Bill" + NL);

        System.out.print("Enter Customer ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter the name of the customer: ");
        String name = sc.nextLine();

        System.out.print("Enter the units consumed by the customer: ");
        int units = sc.nextInt();

        double amount = calcAmount(units);
        double surcharge = calcSurcharge(amount);
        double netAmount = amount + surcharge;

        System.out.print(NL);
        System.out.print("Electricity Bill" + NL);
        System.out.print("Customer ID: " + id + NL);
        System.out.print("Customer Name: " + name + NL);
        System.out.print("Unit Consumed: " + units + NL);
        System.out.print("Amount Charges @$1.80per unit: " + String.format("%.2f", amount) + NL);
        System.out.print("Surcharge Amount: " + String.format("%.2f", surcharge) + NL);
        System.out.print("Net Amount paid by the customer: " + String.format("%.2f", netAmount) + NL);
    }

    static double calcAmount(int units) {
        double amt = 0;
        if (units <= 199)
            amt = units * 1.20;
        else if (units <= 399)
            amt = (199 * 1.20) + ((units - 199) * 1.50);
        else if (units <= 599)
            amt = (199 * 1.20) + (200 * 1.50) + ((units - 399) * 1.80);
        else
            amt = (199 * 1.20) + (200 * 1.50) + (200 * 1.80) + ((units - 599) * 2.00);
        return amt;
    }

    static double calcSurcharge(double amount) {
        if (amount > 400) return amount * 0.15;
        return 0;
    }
}
