package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import parsers.GenParser;

public class MAIN {
	
	static JFrame window = new JFrame();
	static JPanel panel = new JPanel();
	
	public static void main(String [] args) {
		
		GenParser parser = new GenParser();
		
		JLabel label = new JLabel();
		
		window.setFocusable(true);
		window.setVisible(true);
		window.setSize(new Dimension(500,500));
		window.setLayout(new BorderLayout());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window.getContentPane().setBackground(Color.BLACK);
		
		parser.parse("C:\\Users\\priet\\GameDev-Workspace\\TerminNox\\src\\HTML\\index.html");
		
		System.out.println(parser.getSource());
		
		panel.setPreferredSize(new Dimension(10, 50));
		panel.setBackground(Color.pink);
		
		panel.add(label);
		label.setText(parser.getSource());
		
		window.add(panel);
		window.pack();
		
		
	}
	


}
