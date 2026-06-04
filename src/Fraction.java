/** Program Name: Fraction.java
 *  Purpose: To provide a template for the Fraction object for use in the Fraction Calculator
 *  @author Xander Warchulski
 *  @version 2.0
 *  @since April 12, 2025
 */

public class Fraction implements Comparable<Fraction> 
{
	//class members are declared
    private int num;
    private int den;
    

    /**
     * 0 argument constructor for a Fraction object
     */
    public Fraction() 
    {
        this.num = 1;
        this.den = 1;
    }
    
    /**
     * 2 argument constructor for a Fraction object
     * @param num - the num of the Fraction
     * @param den - the den of the Fraction
     * @throws DivisionByZeroException
     */
    public Fraction(int num, int den) throws DivisionByZeroException 
    {
        if (den == 0) 
        {
            throw new DivisionByZeroException("Denominator cannot be zero.");
        }
        this.num = num;
        this.den = den;
    }

    
    /**
     * Gets the num of this Fraction
     * @return num
     */
    public int getNum() 
    { return num; }
    
    /**
     * Gets the den of this Fraction
     * @return den
     */
    public int getDen() 
    { return den; }

    /**
     * Sets the num of this Fraction
     * @param num - the num to set
     */
    public void setNum(int num) 
    { this.num = num; }

    /**
     * Sets the den of this Fraction unless it is 0
     * @param den - the den to set
     * @throws DivisionByZeroException
     */
    public void setDen(int den) throws DivisionByZeroException 
    {
        if (den == 0) 
        {
            throw new DivisionByZeroException("Denominator cannot be zero.");
        }
        this.den = den;
    }

    /**
     * Converts a fraction to a decimal value
     * @return double
     */
    public double toDecimal() 
    {
        return (double) num / den;
    }

    /**
     * Produces the reciprocal of a Fraction object
     * @return Fraction
     * @throws DivisionByZeroException
     */
    public Fraction toReciprocal() throws DivisionByZeroException 
    {
        return new Fraction(den, num);
    }

    /**
     * Adds two Fraction objects
     * @param f - the Fraction to add with
     * @return Fraction
     * @throws DivisionByZeroException
     */
    public Fraction add(Fraction f) throws DivisionByZeroException 
    {
        int commonDen = den * f.den;
        int newNum = num * f.den + f.num * den;
        return new Fraction(newNum, commonDen).lowestTerms();
    }

    /**
     * Multiplies two Fraction objects
     * @param f - the Fraction to multiply with
     * @return Fraction
     * @throws DivisionByZeroException
     */
    public Fraction multiply(Fraction f) throws DivisionByZeroException 
    {
        return new Fraction(num * f.num, den * f.den).lowestTerms();
    }

    /**
     * Checks if two fractions are equal to one another in value
     * @param f - the Fraction to compare with
     * @return boolean
     * @throws DivisionByZeroException
     */
    public boolean equals(Fraction f) throws DivisionByZeroException 
    {
        Fraction f1 = this.lowestTerms();
        Fraction f2 = f.lowestTerms();
        return f1.num == f2.num && f1.den == f2.den;
    }

    /**
     * Checks if a Fraction object is greater in value than another
     * @param f - the Fraction to compare with
     * @return boolean
     */
    public boolean greaterThan(Fraction f) 
    {
        return this.toDecimal() > f.toDecimal();
    }

    /**
     * Produces the greatest common denominator of two Fractions
     * @param a - first den
     * @param b - second den
     * @return int
     */
    private int gcd(int a, int b) 
    {
        return b == 0 ? a : gcd(b, a % b);
    }

    /**
     * Produces a Fraction in lowest terms
     * @return Fraction
     * @throws DivisionByZeroException
     */
    public Fraction lowestTerms() throws DivisionByZeroException 
    {
        int gcd = gcd(Math.abs(num), Math.abs(den));
        return new Fraction(num / gcd, den / gcd);
    }

    
    /**
     *Implements Compareable's abstract method 
     *@param Fraction - comparative Fraction
     *@return int
     */
    @Override
    public int compareTo(Fraction f) 
    {
        double thisVal = this.toDecimal();
        double otherVal = f.toDecimal();
        return Double.compare(thisVal, otherVal);
    }

    /**
     *Overrides Java's toString() method to display a Fraction object
     *@return String
     */
    @Override
    public String toString() 
    {
        return num + "/" + den;
    }
}