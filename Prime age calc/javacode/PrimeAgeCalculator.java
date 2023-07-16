// Import necessary libraries
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Year;

// Class declaration
public class PrimeAgeCalculator {

    // Declare GUI components
    private JFrame frame;
    private JTextField textFieldBirthYear;
    private JTextArea textAreaResult;

    // Class constructor
    public PrimeAgeCalculator() {
        // Initialize JFrame with title
        frame = new JFrame("Prime Age Calculator");
        // Set default close operation for JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set size of the JFrame
        frame.setSize(300, 200);

        // Initialize JTextField and JTextArea
        textFieldBirthYear = new JTextField();
        textAreaResult = new JTextArea();

        // Initialize JButton and its ActionListener
        JButton buttonCalculate = new JButton("Calculate");
        buttonCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // Check if textFieldBirthYear is not empty
                if (!textFieldBirthYear.getText().isEmpty()) {
                    // Convert the birthYear from string to int
                    int birthYear = Integer.parseInt(textFieldBirthYear.getText());
                    // Calculate the next year of prime age
                    int nextPrimeYear = nextPrimeAgeYear(birthYear);
                    // Display the next year of prime age in textAreaResult
                    textAreaResult.setText("Next prime age year for you will be: " + nextPrimeYear);
                } else {
                    // Display error message in textAreaResult if textFieldBirthYear is empty
                    textAreaResult.setText("Please enter a valid birth year.");
                }
            }
        });

        // Add JTextField, JButton and JTextArea to JFrame
        frame.getContentPane().add(textFieldBirthYear, "North");
        frame.getContentPane().add(buttonCalculate, "Center");
        frame.getContentPane().add(textAreaResult, "South");
    }

    // Method to display the JFrame
    public void show() {
        frame.setVisible(true);
    }

    // Method to calculate the next year of prime age
    public int nextPrimeAgeYear(int birthYear) {
        // Get the current year and calculate age
        int currentYear = Year.now().getValue();
        int age = currentYear - birthYear;

        // Keep incrementing the age until it is a prime number
        while (true) {
            age++;
            if (isPrime(age)) {
                // Return the year when age will be a prime number
                return birthYear + age;
            }
        }
    }

    // Method to check if a number is prime
    public boolean isPrime(int n) {
        // Check if number is less than or equal to 1
        if (n <= 1) {
            return false;
        }
        // Check if number is less than or equal to 3
        if (n <= 3) {
            return true;
        }
        // Check if number is divisible by 2 or 3
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        // Check if number is divisible by any number from 5 to sqrt(n)
        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        // Return true if number is prime
        return true;
    }

    // Main method to create and display the PrimeAgeCalculator GUI
    public static void main(String[] args) {
        PrimeAgeCalculator calculator = new PrimeAgeCalculator();
        calculator.show();
    }
}
