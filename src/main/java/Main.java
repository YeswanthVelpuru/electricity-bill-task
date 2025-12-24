import java.util.Scanner;

public class Main {

    public static float calcAmount(int units) {
        float amount = 0;

        if (units <= 100)
            amount = units * 1.20f;
        else if (units <= 300)
            amount = 100 * 1.20f + (units - 100) * 1.50f;
        else if (units <= 600)
            amount = 100 * 1.20f + 200 * 1.50f + (units - 300) * 1.80f;
        else
            amount = 100 * 1.20f + 200 * 1.50f + 300 * 1.80f + (units - 600) * 2.00f;

        return amount;
    }

    public static float calcSurcharge(float amount) {
        if (amount > 400)
            return amount * 0.15f;
        return 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int id = sc.nextInt();
        sc.nextLine();
        String name = sc.nextLine();
        int units = sc.nextInt();

        float baseAmount = calcAmount(units);
        float surcharge = calcSurcharge(baseAmount);
        float total = baseAmount + surcharge;

        if (total < 100)
            total = 100;

        System.out.println("Customer IDNO : " + id);
        System.out.println("Customer Name : " + name);
        System.out.println("Unit Consumed : " + units);
        System.out.printf("Amount Charges @Rs. %.2f per unit : %.2f\n", (baseAmount / units), baseAmount);
        System.out.printf("Surcharge Amount : %.2f\n", surcharge);
        System.out.printf("Net Amount Paid By the Customer : %.2f\n", total);
    }
}
