import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DesktopNotifier {
    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame();
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Desktop Notifier");

        // Create a JPanel to hold components
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new BorderLayout());

        // Create a label for the notification
        JLabel label = new JLabel(" Prajwal.ggs Time to take a break  !");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label, BorderLayout.CENTER);

        // Create a button to close the notification
        JButton closeButton = new JButton("Close");
        panel.add(closeButton, BorderLayout.SOUTH);

        // Add action listener to the close button
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the frame
            }
        });

        // Set frame to appear in the center of the screen
        frame.setLocationRelativeTo(null);
        
        // Make frame visible
        frame.setVisible(true);
        
        // Notify user after a delay
        notifyAfterDelay(frame);
    }

    private static void notifyAfterDelay(JFrame frame) {
        // Schedule a task after a delay
        Timer timer = new Timer(5000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Make the frame visible again if it's not disposed
                if (frame.isDisplayable()) {
                    frame.setVisible(true);
                    frame.toFront(); // Bring frame to front
                }
            }
        });
        timer.setRepeats(false); // Only notify once
        timer.start();
    }
}
