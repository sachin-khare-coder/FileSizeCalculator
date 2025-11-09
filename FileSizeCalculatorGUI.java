import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

/**
 * File Size Calculator GUI
 * Created by Sachin Khare.
 * A simple and colourful GUI for calculating file information.
 */
public class FileSizeCalculatorGUI extends JFrame {

    // Labels and button
    JLabel lblFileName, lblSize, lblWords, lblChars, lblLongest, lblAverage;
    JButton btnSelect;

    public FileSizeCalculatorGUI() {

        // --- Basic window setup ---
        setTitle("File Size Calculator");
        setSize(650, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(false); // keep normal window look, more realistic

        // --- Background color ---
        getContentPane().setBackground(new Color(240, 248, 255)); // light bluish shade
        setLayout(new BorderLayout(10, 10));

        // --- Top title panel ---
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(70, 130, 180)); // steel blue
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        JLabel lblTitle = new JLabel("📁 File Size Calculator", SwingConstants.LEFT);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitle.setForeground(Color.WHITE);

        JLabel lblCredit = new JLabel("Created by Sachin Khare", SwingConstants.RIGHT);
        lblCredit.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        lblCredit.setForeground(Color.WHITE);

        topPanel.add(lblTitle, BorderLayout.WEST);
        topPanel.add(lblCredit, BorderLayout.EAST);

        // --- Center area with results ---
        JPanel centerPanel = new JPanel(new GridLayout(7, 1, 8, 8));
        centerPanel.setBackground(new Color(240, 248, 255));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        lblFileName = makeLabel("No file selected");
        lblSize = makeLabel("File Size: ");
        lblWords = makeLabel("Word Count: ");
        lblChars = makeLabel("Character Count: ");
        lblLongest = makeLabel("Longest Word: ");
        lblAverage = makeLabel("Average Word Length: ");

        btnSelect = new JButton("Select File");
        btnSelect.setBackground(new Color(30, 144, 255));
        btnSelect.setForeground(Color.WHITE);
        btnSelect.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnSelect.setFocusPainted(false);
        btnSelect.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Button hover color
        btnSelect.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btnSelect.setBackground(new Color(65, 105, 225));
            }
            public void mouseExited(MouseEvent e) {
                btnSelect.setBackground(new Color(30, 144, 255));
            }
        });

        btnSelect.addActionListener(e -> openFileChooser());

        // Add all labels
        centerPanel.add(lblFileName);
        centerPanel.add(lblSize);
        centerPanel.add(lblWords);
        centerPanel.add(lblChars);
        centerPanel.add(lblLongest);
        centerPanel.add(lblAverage);
        centerPanel.add(btnSelect);

        // --- Bottom footer ---
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(70, 130, 180));
        JLabel lblFooter = new JLabel("© 2025 - Made with ❤ by Sachin");
        lblFooter.setForeground(Color.WHITE);
        lblFooter.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        bottomPanel.add(lblFooter);

        // Add panels to frame
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Simple method to create consistent labels
    private JLabel makeLabel(String text) {
        JLabel lbl = new JLabel(text);
        lbl.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lbl.setForeground(new Color(25, 25, 112)); // dark blue
        return lbl;
    }

    // File chooser logic
    private void openFileChooser() {
        JFileChooser chooser = new JFileChooser();
        int option = chooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            lblFileName.setText("File: " + selectedFile.getName());

            FileProcessor processor = new FileProcessor(selectedFile);
            lblSize.setText("File Size: " + processor.getFileSize());
            lblWords.setText("Word Count: " + processor.getWordCount());
            lblChars.setText("Character Count: " + processor.getCharCount());
            lblLongest.setText("Longest Word: " + processor.getLongestWord());
            lblAverage.setText("Average Word Length: " + processor.getAverageLength());
        }
    }

    // (Optional) main method for direct testing
    public static void main(String[] args) {
        new FileSizeCalculatorGUI();
    }
}
