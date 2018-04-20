package biz.aeffegroup.exception;

public class AeffeException extends Exception
{

	private static final long serialVersionUID = 5291351690881082568L;

	public AeffeException() {
    }

    public AeffeException(String message) {
        super(message);
    }

    public AeffeException(Throwable cause) {
        super(cause);
    }

    public AeffeException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public String getMessage()
    {
    	// tutto quello che mi pare.
    	if ( super.getMessage().equalsIgnoreCase(""))
    		
    		; // TODO.
    	
    	
    	return super.getMessage();
    }

}
