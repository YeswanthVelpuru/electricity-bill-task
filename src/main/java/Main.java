import java.util.Scanner;

public class Main {

    public static float calcAmount(int units) {
        float rate;
        if (units <= 199) rate = 1.20f;
        else if (units <= 399) rate = 1.50f;
        else if (units <= 599) rate = 1.80f;
        else rate = 2.00f;
        return units * rate;
    }

    public static float calcSurcharge(float amount) {
        if (amount > 400)
            return amount * 0.15f;
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Calculate Electricity Bill\n");
        System.out.print("Enter Customer ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter the name of the customer: ");
        String name = sc.nextLine();

        System.out.print("Enter the units consumed by the customer: \n");
        int units = sc.nextInt();

        float amount = calcAmount(units);
        float surcharge = calcSurcharge(amount);
        float total = amount + surcharge;
        if (total < 100) total = 100;

        float rate;
        if (units <= 199) rate = 1.20f;
        else if (units <= 399) rate = 1.50f;
        else if (units <= 599) rate = 1.80f;
        else rate = 2.00f;

        System.out.print("Electricity Bill\n");
        System.out.print("Customer ID: " + id + "\n");
        System.out.print("Customer Name: " + name + "\n");
        System.out.print("Unit Consumed: " + units + "\n");
        System.out.printf("Amount Charges @$%.2fper unit: %.2f\n", rate, amount);
        System.out.printf("Surcharge Amount: %.2f\n", surcharge);
        System.out.printf("Net Amount paid by the customer: %.2f", total);

        sc.close();
    }
}