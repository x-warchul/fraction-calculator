/** Program Name: LongOperandException.java
 *  Purpose: An exception class to be thrown by the Calculator program
 *  @author Xander Warchulski
 *  @version 1.0
 *  @since April 13, 2025
 */

public class LongOperandException extends Exception 
{
    public LongOperandException(String message) 
    {
        super(message);
    }
}