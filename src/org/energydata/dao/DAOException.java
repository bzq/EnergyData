package org.energydata.dao;

public class DAOException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3644880673892442160L;

	public DAOException( String message ) {
        super( message );
    }
 
    public DAOException( String message, Throwable cause ) {
        super( message, cause );
    }
 
    public DAOException( Throwable cause ) {
        super( cause );
    }
}
