package exceptions;

public class IllegalDateException extends Exception {
private static final long serialVersionUID = 1L;
	
	public IllegalDateException(String mensaje) {
        super(mensaje);
    }
}