package graphicGenerator;

import javax.swing.*;
//import javax.swing.event.*;
//import java.awt.event.*;
import java.awt.EventQueue; 

public class PiGraphic {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				PiFrame frame1 = new PiFrame();
				frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame1.setSize(700,700);
				frame1.setResizable(false);
				frame1.setVisible(true);
			}
		});
	}
	
}


