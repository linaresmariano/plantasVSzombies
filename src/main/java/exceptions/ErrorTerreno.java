package exceptions;

public class ErrorTerreno extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ErrorTerreno() {
		super();
	}

	public ErrorTerreno(String message, Throwable cause) {
		super(message, cause);
	}

	public ErrorTerreno(String message) {
		super(message);
	}

	public ErrorTerreno(Throwable cause) {
		super(cause);
	}
}
