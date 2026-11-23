package parsers;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

import errormanagers.ProgramError;
import tokens.HTML_TYPE;
import tokens.Token;

public class GenParser {
	
	String source = "";
	
	String currentLine = "";
	
	ArrayList<Token> tokens = new ArrayList<Token>();
	
	int parseIndex = 0 ;
	int lineIndex = 1;
	
	
	public GenParser() {
//		tokens.add(new Token());
	}
	
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
	
	char currentChar() { 
		if (this.parseIndex < this.source.length()) {
			return source.charAt(parseIndex); 
		} else {
			return '\0';
		}
	}
	char nextChar() {
		if (this.parseIndex + 1< this.source.length()) {
			return source.charAt(parseIndex + 1); 
		} else {
			return '\0';
		}
	}
	void advanceIndex() { this.parseIndex++; }
	void lineJump() {this.advanceIndex(); this.lineIndex++;}
	
	boolean currentCharMatches(char[] suspects) {
		
		for (char sus : suspects) {
			if (this.currentChar() == sus) return true;
		}
		
		return false;
	}
	
boolean nextCharMatches(char[] suspects) {
		
		for (char sus : suspects) {
			if (this.nextChar() == sus) return true;
		}
		
		return false;
	}
	
	String rawChar(char c) {
		switch(c) {
		case '\n': return "\\n";
		case '\r': return "\\r";
		case '\0': return "\\0";
		default: return String.valueOf(c);
		}
	}
	
	public void parse() {
				
		while (parseIndex < source.length()){
				
			while (this.currentCharMatches(new char[] {'\r',' ', '\n', '\0'})) {
				if (this.currentChar() == '\n') {
					this.lineJump();
				} else if (this.currentChar() == '\0') {
					ProgramError.report("Parsing", "Termination Character Found", 10);
					this.advanceIndex();
				} else {
					this.advanceIndex();
				}
			}

			
//			System.out.println(this.rawChar(this.currentChar()) + "{ pos: "+ this.parseIndex +",  linea: " + this.lineIndex + " }");

			switch(this.currentChar()) {
				case '<':
					this.advanceIndex();
					String tag ="";	
					while(!this.currentCharMatches(new char[]{'>'})) {
						tag+= this.currentChar();
						this.advanceIndex();
					}
					
					if (tag.charAt(0) == '/') {
						tokens.add(new Token(tag.substring(1, tag.length()), HTML_TYPE.CLOSING_TAG, this.parseIndex, this.lineIndex));

					} else {
						tokens.add(new Token(tag, HTML_TYPE.OPENING_TAG, this.parseIndex, this.lineIndex));
					}
					break;	
				default:
					String plainText = "";
					int i = 0;
					
					System.out.println("Word Found with: " + this.currentChar());
					while(!this.nextCharMatches(new char[]{'<'}) && !this.currentCharMatches(new char[]{'\0'})) {
						System.out.println(this.currentChar() +", "+ i);
						plainText+= this.currentChar();
						this.advanceIndex();
						i++;
						
					}
					
					System.out.println("Word Found ended with: " + this.currentChar());
					
					tokens.add(new Token(plainText, HTML_TYPE.PLAIN_TEXT, this.parseIndex, this.lineIndex));

					break;
			}
						
			this.advanceIndex();
		}
		
		System.out.println("Tokens [\n");
		for (Token tk : tokens) {
			System.out.println("   " + tk);
		}
		System.out.println("\n]");
		
		
	}
}
