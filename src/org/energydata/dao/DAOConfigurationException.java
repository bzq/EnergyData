package org.energydata.dao;

public class DAOConfigurationException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7438449427078982013L;

    public DAOConfigurationException( String message ) {
        super( message );
    }
 
    public DAOConfigurationException( String message, Throwable cause ) {
        super( message, cause );
    }
 
    public DAOConfigurationException( Throwable cause ) {
        super( cause );
    }
}
