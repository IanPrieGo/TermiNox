package tokens;

public class Token {
	
	String lexeme; // Texto plano que identifica al Token
	HTML_TYPE  type; // Tipo especifico de Token
	Object value; // Valor que tiene el Token, en caso de tenerlo.
	int line; // Line en la que se ubica el Token
	
	public Token(String lexeme, HTML_TYPE type, Object value, int line) {
		this.lexeme = lexeme;
		this.type = type;
		this.value = value; 
		this.line = line;
	}
	
	public Token() {
		this.lexeme = "Puto";
		this.type = HTML_TYPE.PLAIN_TEXT;
		this.value = false; 
		this.line = 666;
	}
	
	public String toString() {
		return "Token [ Lexema: " + this.lexeme + ", Tipo: " + this.type + ", Valor: " + this.value + ", Linea: " + this.line;
	}
	
}
