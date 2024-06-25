//------------------------------------------------------------------------\
// Program Name: Option 2: Creating a User Interface II
//------------------------------------------------------------------------\
// Pseudocode: 1. Display a GUI with 4 options:
//                a. Parameters: show date and time
//                b. Returns: Concatenated string
//             2.Main program
//               a. Initialize variables.
//               b. Accept three names from the user.
//               c. Invoke name_game() function, passing the three strings.
//               d. Display three names in reverse order
//------------------------------------------------------------------------\
// Program Inputs: Three names.
// Program Outputs: Display three names in reverse order.
//------------------------------------------------------------------------\
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class MenuExample extends JFrame {

    private JTextArea outputTextArea;

    public MenuExample() {
        setTitle("Creating a User Interface II");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create a text area for output
        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);

        // Create a menu bar and menu items
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Options");

        JMenuItem showDateTimeItem = new JMenuItem("Show Date/Time");
        JMenuItem saveToFileItem = new JMenuItem("Save to File");
        JMenuItem changeColorItem = new JMenuItem("Change background Color");
        JMenuItem exitItem = new JMenuItem("Exit");

        // Add menu items to the menu
        fileMenu.add(showDateTimeItem);
        fileMenu.add(saveToFileItem);
        fileMenu.add(changeColorItem);
        fileMenu.add(exitItem);

        // Add action listeners for menu items
        showDateTimeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showDateTime();
            }
        });

        saveToFileItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveToFile();
            }
        });

        changeColorItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeBackgroundColor();
            }
        });

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Add menu to menu bar
        menuBar.add(fileMenu);

        // Set the menu bar for the frame
        setJMenuBar(menuBar);

        // Add text area to the frame
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private void showDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        outputTextArea.append("Current Date/Time: " + dateFormat.format(date) + "\n");
    }

    private void saveToFile() {
        String content = outputTextArea.getText();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt"));
            writer.write(content);
            writer.close();
            outputTextArea.append("Text saved to log.txt\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving to file: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void changeBackgroundColor() {
        Random rand = new Random();
        int hue = rand.nextInt(30) * 12; // Random hue in multiples of 12 (0-360 degrees)
        Color color = Color.getHSBColor(hue / 360f, 1.0f, 1.0f);
        outputTextArea.setBackground(color);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MenuExample menuExample = new MenuExample();
                menuExample.setVisible(true);
            }
        });
    }
}
