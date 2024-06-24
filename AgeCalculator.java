import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;

public class AgeCalculator extends JFrame {
    private JTextField birthDateField;
    private JButton calculateButton;
    private JPanel panel;
    private JLabel resultLabel;

    public AgeCalculator() {
        // Create the main frame
        setTitle("How old are you?");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        birthDateField = new JTextField(10);
        calculateButton = new JButton("Calculate Age");
        resultLabel = new JLabel("Your age will be displayed here.");

        // Create panel and add components to it
        panel = new JPanel();
        panel.add(new JLabel("Enter your birth date (YYYY-MM-DD):"));
        panel.add(birthDateField);
        panel.add(calculateButton);
        panel.add(resultLabel);

        // Add ActionListener to the button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateAge();
            }
        });

        // Add panel to the frame
        add(panel);

        // Make the frame visible
        setVisible(true);
    }

    private void calculateAge() {
        try {
            String birthDateString = birthDateField.getText();
            LocalDate birthDate = LocalDate.parse(birthDateString);
            LocalDate currentDate = LocalDate.now();
            int age = Period.between(birthDate, currentDate).getYears();
            resultLabel.setText("Your age is: " + age + " years");
        } catch (Exception e) {
            resultLabel.setText("Invalid date format. Please enter in YYYY-MM-DD format.");
        }
    }

    public static void main(String[] args) {
        new AgeCalculator();
    }
}
