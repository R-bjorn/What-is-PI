package graphicGenerator;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;

public class PiFrame extends JFrame{
	
	private JComponent piGraphicPanel;
	private JPanel piNumberPanel;
	private final int LENGTH = 500;
	private final int WIDE = 500;
	

	public PiFrame() {
//		this.setLayout();
		setTitle("Pi Graphic Generator");
		setLayout(new BorderLayout());
		
		piGraphicPanel = new PiComponent();
		piGraphicPanel.setPreferredSize(new Dimension(LENGTH, WIDE));
		piGraphicPanel.setBackground(Color.GRAY);
		
		piNumberPanel = new JPanel();
		piNumberPanel.add(new JLabel("This is where you can see the digits of pi!"));
		piNumberPanel.setPreferredSize(new Dimension(LENGTH, 30));
		piNumberPanel.setBackground(Color.YELLOW);
		
		JLabel label = new JLabel("A Graphic Design for how pi looks in 500 x 500 pixels if we take each number as a color"
				+ " and draw it in a grid of 500 by 500 pixel board as each pixel showing color according to the color."); 
		label.setPreferredSize(new Dimension(100, 50));
		
		add(label, BorderLayout.NORTH);
		add(piGraphicPanel, BorderLayout.CENTER);
		add(piNumberPanel, BorderLayout.SOUTH);
		
	}
	
	protected class PiComponent extends JComponent{
		
		public PiComponent() {
			
		}
	}

}