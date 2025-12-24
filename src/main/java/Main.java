import java.util.Scanner;

public class Main {

    // Slab based calculation
    public static float calcAmount(int units) {
        float amount = 0;

        if (units <= 199) {
            amount = units * 1.20f;
        } else if (units <= 399) {
            amount = (199 * 1.20f) + ((units - 199) * 1.50f);
        } else if (units <= 599) {
            amount = (199 * 1.20f) + (200 * 1.50f) + ((units - 399) * 1.80f);
        } else {
            amount = (199 * 1.20f) + (200 * 1.50f) + (200 * 1.80f) + ((units - 599) * 2.00f);
        }
        return amount;
    }

    public static float calcSurcharge(float amount) {
        if (amount > 400)
            return amount * 0.15f;
        return 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder out = new StringBuilder();

        out.append("Calculate Electricity Bill\n");
        out.append("Enter Customer ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        out.append("Enter the name of the customer: ");
        String name = sc.nextLine();

        out.append("Enter the units consumed by the customer: \n"); // IMPORTANT SPACE

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

        out.append("Electricity Bill\n");
        out.append("Customer ID: ").append(id).append("\n");
        out.append("Customer Name: ").append(name).append("\n");
        out.append("Unit Consumed: ").append(units).append("\n");
        out.append(String.format("Amount Charges @$%.2fper unit: %.2f\n", rate, amount));
        out.append(String.format("Surcharge Amount: %.2f\n", surcharge));
        out.append(String.format("Net Amount paid by the customer: %.2f", total));

        System.out.print(out.toString());
        sc.close();
    }
}
