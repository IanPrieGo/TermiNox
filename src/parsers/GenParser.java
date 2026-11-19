package parsers;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import errormanagers.ProgramError;
import tokens.Token;

public class GenParser {
	
	String source = "";
	
	String currentLine = "";
	
	ArrayList<Token> tokens = new ArrayList<Token>();
	
	int parseIndex = 0 ;
	
	
	public GenParser() {}
	
	public String getSource() {
		return this.source;
	}
	
	public ArrayList<Token> getTokens() {
		return tokens;
	}
	
	public void sourceFile(String filePath) {
		
		try {
		source="";
		File sourceFile = new File(filePath);
		FileReader reader = new FileReader(sourceFile);
		int currCharCode;
		
		while((currCharCode = reader.read()) != -1) {
			source += (char)currCharCode;
		}
		
		reader.close();
		} catch (IOException e){
			System.err.println("Error. File not read properly");
			e.printStackTrace();
		}
		
	}
	
	char currentChar() { return source.charAt(parseIndex); }
	void advanceIndex() { parseIndex++; }
	boolean currentCharMatches(char[] suspects) {
		
		for (char sus : suspects) {
			if (this.currentChar() == sus) return true;
		}
		
		return false;
	}
	
	public void parse() {
				
		while (parseIndex < source.length()){
			
			if (this.currentChar() == '\0') ProgramError.report("Parsing", "Termination Character Found", 10);
			
			if (this.currentCharMatches(new char[]{' ', '\n', '\r'})) {
				this.advanceIndex();
			} 
			
			this.advanceIndex();
		}
		
		
	}
}
