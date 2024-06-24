import javax.swing.*;
import java.awt.*;

public class EnhancedGUI {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Enhanced GUI Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        // Create the first panel
        JPanel panel1 = new JPanel();
        JLabel label = new JLabel("Enter your name:");
        JTextField textField = new JTextField(20);
        panel1.add(label);
        panel1.add(textField);

        // Create the second panel
        JPanel panel2 = new JPanel();
        JButton button = new JButton("Submit");
        panel2.add(button);

        // Add panels to the frame
        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.SOUTH);

        // Make the frame visible
        frame.setVisible(true);
    }
}
