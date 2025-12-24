import java.util.Scanner;

public class Main {

    public static float calcAmount(int units) {
        float amount;

        if (units <= 100)
            amount = units * 1.20f;
        else if (units <= 300)
            amount = 100 * 1.20f + (units - 100) * 1.50f;
        else if (units <= 600)
            amount = 100 * 1.20f + 200 * 1.50f + (units - 300) * 1.62f;
        else
            amount = 100 * 1.20f + 200 * 1.50f + 300 * 1.62f + (units - 600) * 2.00f;

        return amount;
    }

    public static float calcSurcharge(float amount) {
        return amount > 400 ? amount * 0.15f : 0;
    }

    public static float getRate(int units) {
        if (units <= 100) return 1.20f;
        else if (units <= 300) return 1.50f;
        else if (units <= 600) return 1.62f;
        else return 2.00f;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Calculate Electricity Bill\n");
        System.out.print("Enter Customer ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter the name of the customer: ");
        String name = sc.nextLine();

        System.out.print("Enter the units consumed by the customer: ");
        int units = sc.nextInt();

        float baseAmount = calcAmount(units);
        float surcharge = calcSurcharge(baseAmount);
        float total = baseAmount + surcharge;

        if (total < 100) {
            baseAmount = 100;
            total = 100;
        }

        float rate = getRate(units);

        System.out.println("\nElectricity Bill");
        System.out.println("Customer ID: " + id);
        System.out.println("Customer Name: " + name);
        System.out.println("Unit Consumed: " + units);
        System.out.printf("Amount Charges @$%.2fper unit: %.2f\n", rate, baseAmount);
        System.out.printf("Surcharge Amount: %.2f\n", surcharge);
        System.out.printf("Net Amount paid by the customer: %.2f\n", total);
    }
}
