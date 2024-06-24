import javax.swing.*;

public class SimpleGUI {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Simple GUI Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create a panel
        JPanel panel = new JPanel();

        // Add components to the panel
        JLabel label = new JLabel("Hello, Swing!");
        JButton button = new JButton("Click Me");
        panel.add(label);
        panel.add(button);

        // Add the panel to the frame
        frame.add(panel);

        // Make the frame visible
        frame.setVisible(true);
    }
}
