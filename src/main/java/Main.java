import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // TODO: Implement the main method
        // 1. Print "Calculate Electricity Bill"
        // 2. Get customer ID, name, and units consumed
        // 3. Calculate amount using calcAmount() method
        // 4. Calculate surcharge using calcSurcharge() method  
        // 5. Print the electricity bill in required format
        
        scanner.close();
    }
    
    /**
     * Calculate the base amount based on units consumed
     * @param units - electricity units consumed
     * @return base amount as float
     */
    public static float calcAmount(int units) {
        // TODO: Implement pricing logic
        // Up to 199: $1.20 per unit
        // 200-399: $1.50 per unit  
        // 400-599: $1.80 per unit
        // 600+: $2.00 per unit
        // Minimum bill: $100
        
        return 0.0f; // Replace with actual implementation
    }
    
    /**
     * Calculate surcharge if bill amount exceeds $400
     * @param amount - base bill amount
     * @return surcharge amount as float (15% if amount > 400, else 0)
     */
    public static float calcSurcharge(float amount) {
        // TODO: Implement surcharge logic
        // If amount > $400, return 15% of amount
        // Otherwise return 0
        
        return 0.0f; // Replace with actual implementation
    }
}