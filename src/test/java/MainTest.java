import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class MainTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    public void testMain() {
        // Test 500 units: 199×$1.20 + 200×$1.50 + 101×$1.80
        // = $238.80 + $300.00 + $181.80 = $720.60
        // Surcharge: $720.60 × 15% = $108.09  
        // Total: $720.60 + $108.09 = $828.69
        String simulatedInput = "12345\nJohn Doe\n500\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Main.main(new String[]{});

        String expectedOutput = "Calculate Electricity Bill\n" +
                "Enter Customer ID: Enter the name of the customer: Enter the units consumed by the customer: \n" +
                "Electricity Bill\n" +
                "Customer ID: 12345\n" +
                "Customer Name: John Doe\n" +
                "Unit Consumed: 500\n" +
                "Amount Charges @$1.80per unit: 720.60\n" +
                "Surcharge Amount: 108.09\n" +
                "Net Amount paid by the customer: 828.69";

        assertEquals(expectedOutput, outContent.toString().trim());
    }
}