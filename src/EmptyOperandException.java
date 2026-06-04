/** Program Name: EmptyOperandException.java
 *  Purpose: An exception class to be thrown by the Calculator program
 *  @author Xander Warchulski
 *  @version 1.0
 *  @since April 13, 2025
 */

public class EmptyOperandException extends Exception 
{
    public EmptyOperandException(String message) 
    {
        super(message);
    }
}