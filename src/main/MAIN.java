package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import parsers.GenParser;

public class MAIN {
	
	static JFrame window = new JFrame();
	static JPanel panel = new JPanel();
	
	public static void main(String [] args) {
		
		GenParser parser = new GenParser();
				
		window.setFocusable(true);
		window.setVisible(true);
		window.setSize(new Dimension(500,500));
		window.setLayout(new BorderLayout());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window.getContentPane().setBackground(Color.BLACK);
		
		panel.setPreferredSize(new Dimension(100, 100));
		panel.setBackground(Color.pink);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		

				
		String shortPath = "../../HTML/test.html";

		
		parser.sourceFile(getHTML("test"));
		parser.parse();
		
		window.add(panel);
		window.pack();
		
		
	}
	
	public static String getHTML(String name) {
		return "C:\\Users\\priet\\GameDev-Workspace\\TerminNox\\src\\HTML\\" + name + ".html";
	}
	


}
