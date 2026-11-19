package tokens;

public class Token {
	
	String lexeme; // Texto plano que identifica al Token
	String type; // Tipo especifico de Token
	HTML_TYPE value; // Valor que tiene el Token, en caso de tenerlo.
	int line; // Line en la que se ubica el Token
	
	public Token(String lexeme, String type, HTML_TYPE value, int line) {
		this.lexeme = lexeme;
		this.type = type;
		this.value = value; 
		this.line = line;
	}
	
}
