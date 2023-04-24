package GuiGenerator;

import numberGenerator.PiNumber;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PiGuiGenerator implements ActionListener {
	
	private int width = 4;
	private int height = 4;
    
    private PiNumber pi = new PiNumber();	
    private int limit = width * height;
    private int newLimit = limit;
    private int currentIndex = 0;
    private String piDigits = "";
    private JLabel[][] digits = new JLabel[width][height];
    private JFrame frame = new JFrame("Pi Number");
    private JPanel panel = new JPanel(new GridLayout(width, height, 1, 1));
    
    // User buttons
    private JButton prevButton = new JButton("Previous"); // goes to previous panel
    private JButton nextButton = new JButton("Next"); // goes to next panel
    private JButton saveButton = new JButton("Save as JPG"); // create the JButton
    private JPanel buttonPanel = new JPanel();
    
    // Width - Height Text input fields
    private JTextField widthField = new JTextField(5);
    private JTextField heightField = new JTextField(5);
    private JLabel widthLabel = new JLabel("Enter Width: ");
    private JLabel heightLabel = new JLabel("Enter Height: ");    
    private JPanel inputPanel = new JPanel();    
    private JButton submitButton = new JButton("Submit");
    
    public PiGuiGenerator() {
    	// Calculate the first width * height digits of pi
    	piDigits = pi.getPiDigits(currentIndex, limit);
        // Create the JLabels and add them to the panel
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                digits[i][j] = new JLabel(" ");
                digits[i][j].setFont(new Font("Courier New", Font.PLAIN, 12));
                digits[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                digits[i][j].setPreferredSize(new Dimension(20, 20));
                digits[i][j].setBackground(Color.WHITE);
                digits[i][j].setOpaque(true);
                panel.add(digits[i][j]);
            }
        }
        
        // Set the first 2500 digits of pi in the JLabels
        setCurrentDigits();

        submitButton.addActionListener(this);
        inputPanel.add(widthLabel);
        inputPanel.add(widthField);
        inputPanel.add(heightLabel);
        inputPanel.add(heightField);
        inputPanel.add(submitButton);
        
        // Add the input panel to the frame
        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        
        // Button Panel
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(saveButton);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        nextButton.addActionListener(this);
        prevButton.addActionListener(this);
        saveButton.addActionListener(this);
        
        // Set frame properties
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private void setCurrentDigits() {
        int i = 0;
        for (int row = 0; row < width; row++) {
            for (int col = 0; col < height; col++) {
                if (i < piDigits.length()) {
                    digits[row][col].setText(Character.toString(piDigits.charAt(i)));
                    digits[row][col].setBackground(getColor(Integer.parseInt(Character.toString(piDigits.charAt(i)))));
                    i++;
                } else {
//                    digits[row][col].setText("");
                    digits[row][col].setBackground(new Color(255,0,0));
                }
            }
        }
    }
    
    private Color getColor(int digit) {
    	Color bgColor;
    	switch(digit) {
    	    case 0:
    	        bgColor = Color.WHITE;
    	        break;
    	    case 1:
    	        bgColor = new Color(224, 224, 224); // light gray
    	        break;
    	    case 2:
    	        bgColor = new Color(192, 192, 192); // gray
    	        break;
    	    case 3:
    	        bgColor = new Color(160, 160, 160); // dark gray
    	        break;
    	    case 4:
    	        bgColor = new Color(128, 128, 128); // darker gray
    	        break;
    	    case 5:
    	        bgColor = new Color(96, 96, 96); // even darker gray
    	        break;
    	    case 6:
    	        bgColor = new Color(64, 64, 64); // very dark gray
    	        break;
    	    case 7:
    	        bgColor = new Color(32, 32, 32); // almost black
    	        break;
    	    case 8:
    	        bgColor = new Color(16, 16, 16); // very dark
    	        break;
    	    case 9:
    	        bgColor = Color.BLACK;
    	        break;
    	    default:
    	        bgColor = Color.WHITE; // default to white for invalid digits
    	}
    	
    	return bgColor;
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            width = Integer.parseInt(widthField.getText());
            height = Integer.parseInt(heightField.getText());
            limit = width * height;
            newLimit = limit;
            digits = new JLabel[width][height];
            panel.removeAll();
            panel.setLayout(new GridLayout(width, height, 1, 1));
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    digits[i][j] = new JLabel(" ");
                    digits[i][j].setFont(new Font("Courier New", Font.PLAIN, 12));
                    digits[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                    digits[i][j].setPreferredSize(new Dimension(20, 20));
                    digits[i][j].setBackground(Color.WHITE);
                    digits[i][j].setOpaque(true);
                    panel.add(digits[i][j]);
                }
            }
//            frame.pack();
            piDigits = pi.getPiDigits(currentIndex, newLimit);
            setCurrentDigits();
        } else if (e.getSource() == nextButton) {
            // Move to the next 2500 digits of pi and update the JLabels
            currentIndex += limit;
            newLimit += limit;
            System.out.println("startIndex : " + currentIndex + ", newLimit : "+ newLimit + ", limit : " + limit );
            piDigits = pi.getPiDigits(currentIndex, newLimit);
            setCurrentDigits();
        } else if (e.getSource() == prevButton) {
        	currentIndex -= limit;
        	currentIndex = Math.max(0,  currentIndex);
        	newLimit -= limit;
        	newLimit = Math.max(limit, newLimit);
        	System.out.println("startIndex : " + currentIndex + ", newLimit : "+ newLimit + ", limit : " + limit );
            piDigits = pi.getPiDigits(currentIndex, limit);
            setCurrentDigits();
        } else if(e.getSource() == saveButton) {
        	// create a BufferedImage with the same size as the JPanel
            BufferedImage image = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);

            // paint the JPanel to the BufferedImage
            panel.paint(image.getGraphics());

            // create a FileChooser dialog to let the user choose where to save the file
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(frame);

            // if the user chose a file, save the BufferedImage as a JPG
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    ImageIO.write(image, "jpg", file);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    public static void main(String[] args) {
        new PiGuiGenerator();
    }
    
}

