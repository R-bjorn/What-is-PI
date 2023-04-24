package TryScripts;
//package numberGenerator;
//
//import java.awt.Color;
//import java.awt.GridLayout;
//import java.math.BigInteger;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
//public class PiImageGenerator {
//    
//    private static final int GRID_SIZE = 50;
//    private static final int DIGIT_BLOCK_SIZE = 10;
//    private static final int DIGIT_BLOCK_BRIGHTNESS_STEP = 25;
//
//    private PiNumber piNumber;
//    private int digitsShown;
//    private JFrame frame;
//    private JPanel panel;
//    private JButton nextButton;
//
//    public PiImageGenerator() {
//        piNumber = new PiNumber();
//        digitsShown = 0;
//        initGUI();
//    }
//
//    private void initGUI() {
//        frame = new JFrame("Pi Number");
//        panel = new JPanel();
//        panel.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
//        nextButton = new JButton("Next");
//        nextButton.addActionListener(e -> showNextDigits());
//        frame.add(panel);
//        frame.add(nextButton, "South");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(800, 800);
//        frame.setVisible(true);
//    }
//
//    private void showNextDigits() {
//        String digits = piNumber.calcPiDigits(digitsShown + 2500);
//        for (int i = digitsShown; i < digitsShown + 2500 && i < digits.length(); i++) {
//            int digit = Character.getNumericValue(digits.charAt(i));
//            Color color = getColorForDigit(digit);
//            JPanel digitPanel = new JPanel();
//            digitPanel.setBackground(color);
//            panel.add(digitPanel);
//        }
//        digitsShown += 2500;
//        panel.repaint();
//    }
//
//    private Color getColorForDigit(int digit) {
//        int brightness = 255 - digit * DIGIT_BLOCK_BRIGHTNESS_STEP;
//        return new Color(brightness, brightness, brightness);
//    }
//
//    public static void main(String[] args) {
//        new PiImageGenerator();
//    }
//}
