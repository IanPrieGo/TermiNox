package errormanagers;

public class ProgramError {
	public static void report(String area, String message, int line) {
		System.out.println(area + " Error. " + message + " [ at line" + line + " ]");
	} 
}
