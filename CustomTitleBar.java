import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomTitleBar extends JPanel {

    public CustomTitleBar(JFrame frame) {
        setLayout(new BorderLayout());
        setBackground(new Color(70, 130, 180));
        setPreferredSize(new Dimension(frame.getWidth(), 40));

        JLabel titleLabel = new JLabel("  📁 File Size Calculator", SwingConstants.LEFT);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));

        JButton closeButton = new JButton("✖");
        closeButton.setForeground(Color.WHITE);
        closeButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        closeButton.setBackground(new Color(220, 20, 60));
        closeButton.setFocusPainted(false);
        closeButton.setBorderPainted(false);
        closeButton.setPreferredSize(new Dimension(50, 40));
        closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Hover effect
        closeButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                closeButton.setBackground(new Color(255, 69, 58));
            }
            public void mouseExited(MouseEvent e) {
                closeButton.setBackground(new Color(220, 20, 60));
            }
        });

        closeButton.addActionListener(e -> System.exit(0));

        add(titleLabel, BorderLayout.WEST);
        add(closeButton, BorderLayout.EAST);
    }
}
