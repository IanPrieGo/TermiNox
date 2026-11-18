package parsers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GenParser {
	
	String source ="";
	
	public GenParser() {
		
	}
	
	public String getSource() {
		return this.source;
	}
	
	public void parse(String sourcePath) {
		File sourceFile = new File(sourcePath);
		Scanner reader;
		
		try {
			reader = new Scanner(sourceFile);
			while (reader.hasNextLine())
			source+=reader.nextLine()+"\n";
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
