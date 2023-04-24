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
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PiGuiGenerator implements ActionListener {
	
	// Variables for Frame size
	private int width = 4;
	private int height = 4;
	private int limit = width * height;
    private int newLimit = limit;
    private boolean textVisible = false;
    // Width - Height Text input fields
    private JTextField widthField = new JTextField(5);
    private JTextField heightField = new JTextField(5);
    private JLabel widthLabel = new JLabel("Enter Width: ");
    private JLabel heightLabel = new JLabel("Enter Height: "); 
    private JCheckBox checkBox = new JCheckBox("Hide Text", textVisible);
    
    // Pi Number Generator
    private PiNumber pi = new PiNumber();	
    
    // GUI Variables
    private int currentIndex = 0;
    private String piDigits = "";
    private JLabel[][] digits = new JLabel[width][height];
    private JFrame frame = new JFrame("Pi Number");
    private JPanel panel = new JPanel(new GridLayout(width, height, 1, 1));
    private JPanel inputPanel = new JPanel();    
    private JPanel buttonPanel = new JPanel();
    
    
    // User buttons
    private JButton prevButton = new JButton("Previous"); // goes to previous panel
    private JButton nextButton = new JButton("Next"); // goes to next panel
    private JButton saveButton = new JButton("Save as JPG"); // create the JButton
    private JButton submitButton = new JButton("Submit");  
    // Add a new button to save 10 panels together
    private JButton saveTenButton = new JButton("Save 10 Panels");
    
    // Declare a global counter variable to keep track of the current panel index
    private int panelIndex = 0;
    
    
       
    public PiGuiGenerator() {
    	// Calculate the first width * height digits of pi
    	piDigits = pi.getPiDigits(currentIndex, limit);
        // Create the JLabels and add them to the panel
    	for (int i = 0; i < width*height; i++) {
    		int row = i / height;
    		int col = i % height;
    		digits[row][col] = new JLabel(" ");
    		digits[row][col].setFont(new Font("Courier New", Font.PLAIN, 12));
    		digits[row][col].setHorizontalAlignment(SwingConstants.CENTER);
    		digits[row][col].setPreferredSize(new Dimension(20, 20));
    		digits[row][col].setBackground(Color.WHITE);
    		digits[row][col].setOpaque(true);
    		panel.add(digits[row][col]);
    	}
        
        // Set the first 2500 digits of pi in the JLabels
        setCurrentDigits();

        submitButton.addActionListener(this);
        inputPanel.add(widthLabel);
        inputPanel.add(widthField);
        inputPanel.add(heightLabel);
        inputPanel.add(heightField);
        inputPanel.add(checkBox);
        inputPanel.add(submitButton);
       
        
        
        // Add the input panel to the frame
        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        
        // Button Panel
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(saveTenButton);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        nextButton.addActionListener(this);
        prevButton.addActionListener(this);
        saveButton.addActionListener(this);
        saveTenButton.addActionListener(this);
        
        // Set frame properties
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
       
    private void setCurrentDigits() {
        int i = 0;
        for (int j = 0; j < width * height; j++) {
            if (i < piDigits.length()) {
                int row = j / height;
                int col = j % height;
                char digit = piDigits.charAt(i);
                digits[row][col].setText( (textVisible) ? Character.toString(digit) : "");
                digits[row][col].setBackground(getColor(digit - '0'));
                i++;
            } else {
                int row = j / height;
                int col = j % height;
                digits[row][col].setBackground(new Color(255,0,0));
            }
        }
    }
    
    private Color getColor(int digit) {
        Color[] colors = {Color.WHITE, new Color(224, 224, 224), new Color(192, 192, 192),
                          new Color(160, 160, 160), new Color(128, 128, 128), new Color(96, 96, 96),
                          new Color(64, 64, 64), new Color(32, 32, 32), new Color(16, 16, 16), Color.BLACK};
        return digit >= 0 && digit <= 9 ? colors[digit] : Color.WHITE;
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            width = Integer.parseInt(widthField.getText());
            height = Integer.parseInt(heightField.getText());
            textVisible = checkBox.isSelected();
            System.out.println("text visible : " + textVisible);
            limit = width * height;
            newLimit = limit;
            digits = new JLabel[width][height];
            panel.removeAll();
            panel.setLayout(new GridLayout(width, height, 1, 1));
            for (int i = 0; i < width * height; i++) {
                JLabel label = new JLabel(" ");
                label.setFont(new Font("Courier New", Font.PLAIN, 12));
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setPreferredSize(new Dimension(20, 20));
                label.setBackground(Color.WHITE);
                label.setOpaque(true);
                digits[i / height][i % height] = label;
                panel.add(label);
            }
//            frame.pack();
            piDigits = pi.getPiDigits(currentIndex, newLimit);
            setCurrentDigits();
        } else if (e.getSource() == nextButton) {
//        	// Save the current panel as a JPG with the name 1.jpg, 2.jpg, 3.jpg, and so on
//            BufferedImage image = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
//            panel.paint(image.getGraphics());
//            String folderPath = System.getProperty("user.dir") + "/src/images/" + width + " x " + height;
//            File folder = new File(folderPath);
//            if (!folder.exists()) {
//                folder.mkdirs();
//            }
//            File file = new File(folder, (currentIndex / limit + 1) + ".jpg");
//            try {
//                ImageIO.write(image, "jpg", file);
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
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
        } else if(e.getSource() == saveTenButton) {
        	// Loop through 10 panels starting from the current index and save each one
            for (int i = panelIndex; i < panelIndex + 50; i++) {
            	// Save the current panel as a JPG with the name 1.jpg, 2.jpg, 3.jpg, and so on
                BufferedImage image = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
                panel.paint(image.getGraphics());
                String folderPath = System.getProperty("user.dir") + "/src/images/" + width + " x " + height;
                File folder = new File(folderPath);
                if (!folder.exists()) {
                    folder.mkdirs();
                }
                File file = new File(folder, (currentIndex / limit + 1) + ".jpg");
                try {
                    ImageIO.write(image, "jpg", file);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                // Move to the next 2500 digits of pi and update the JLabels
                currentIndex += limit;
                newLimit += limit;
                System.out.println("startIndex : " + currentIndex + ", newLimit : "+ newLimit + ", limit : " + limit );
                piDigits = pi.getPiDigits(currentIndex, newLimit);
                setCurrentDigits();
            }
        }  
    }
    
    public static void main(String[] args) {
        new PiGuiGenerator();
    }
    
}

