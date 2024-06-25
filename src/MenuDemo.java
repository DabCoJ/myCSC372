import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class MenuDemo extends JFrame {
    private JTextArea textBox;
    private Color initialColor;

    public MenuDemo() {
        setTitle("Menu Demo");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create text area
        textBox = new JTextArea();
        textBox.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textBox);
        add(scrollPane, BorderLayout.CENTER);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();

        // Menu item 1: Show Date and Time
        JMenuItem showDateTimeItem = new JMenuItem("Show Date and Time");
        showDateTimeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDateTime();
            }
        });

        // Menu item 2: Write to log.txt
        JMenuItem writeToLogFileItem = new JMenuItem("Write to log.txt");
        writeToLogFileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writeToLogFile();
            }
        });

        // Menu item 3: Change Background Color
        JMenuItem changeColorItem = new JMenuItem("Change Background Color");
        changeColorItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeBackgroundColor();
            }
        });

        // Menu item 4: Exit Program
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Add menu items to menu
        JMenu menu = new JMenu("Options");
        menu.add(showDateTimeItem);
        menu.add(writeToLogFileItem);
        menu.add(changeColorItem);
        menu.add(exitItem);

        // Add menu to menu bar
        menuBar.add(menu);

        // Set menu bar to frame
        setJMenuBar(menuBar);

        // Initialize initial color
        initialColor = generateRandomOrangeColor();

        // Set initial background color
        getContentPane().setBackground(initialColor);
    }

    // Method to show current date and time in text box
    private void showDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String dateTimeStr = dateFormat.format(now);
        textBox.append(dateTimeStr + "\n");
    }

    // Method to write text box contents to log.txt
    private void writeToLogFile() {
        String content = textBox.getText();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true));
            writer.write(content);
            writer.close();
            JOptionPane.showMessageDialog(this, "Contents written to log.txt", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error writing to log.txt", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    // Method to generate a random orange color
    private Color generateRandomOrangeColor() {
        Random random = new Random();
        float hue = random.nextFloat() * 30 + 15; // random hue between 15 and 45 (orange range)
        return Color.getHSBColor(hue / 360f, 1.0f, 1.0f);
    }

    // Method to change background color of frame
    private void changeBackgroundColor() {
        Color newColor = generateRandomOrangeColor();
        getContentPane().setBackground(newColor);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MenuDemo menuDemo = new MenuDemo();
                menuDemo.setVisible(true);
            }
        });
    }
}
