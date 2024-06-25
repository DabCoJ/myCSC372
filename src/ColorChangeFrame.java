import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorChangeFrame extends JFrame {
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItemChangeColor;

    public ColorChangeFrame() {
        setTitle("Color Change Frame");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create menu bar
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Create menu
        menu = new JMenu("Options");
        menuBar.add(menu);

        // Create menu item to change color
        menuItemChangeColor = new JMenuItem("Change Background Color to Orange Hue");
        menu.add(menuItemChangeColor);

        // Add action listener to the menu item
        menuItemChangeColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeBackgroundColorToRandomOrangeHue();
            }
        });
    }

    private void changeBackgroundColorToRandomOrangeHue() {
        // Generate random hue of orange
        float hue = (float) Math.random();
        Color orangeHue = Color.getHSBColor(hue, 1.0f, 1.0f);

        // Set frame background color
        getContentPane().setBackground(orangeHue);
        repaint();
    }

    public static void main(String[] args) {
        // Create and display the frame
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ColorChangeFrame frame = new ColorChangeFrame();
                frame.setVisible(true);
            }
        });
    }
}
