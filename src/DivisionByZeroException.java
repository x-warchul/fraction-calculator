/** Program Name: DivisionByZeroException.java
 *  Purpose: An exception class to be thrown by the Calculator program and Fraction class
 *  @author Xander Warchulski
 *  @version 1.0
 *  @since April 13, 2025
 */

public class DivisionByZeroException extends Exception 
{
    public DivisionByZeroException(String message) 
    {
        super(message);
    }
}