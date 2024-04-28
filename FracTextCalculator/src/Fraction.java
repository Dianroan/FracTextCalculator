public class Fraction {
    private  int numerator;
    private int denominator;

    public Fraction() {
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public Fraction add(Fraction fraction){
        return new Fraction((this.numerator * fraction.denominator) + (fraction.numerator * this.denominator), this.denominator * fraction.denominator);
    }

    public Fraction subtract(Fraction fraction){
        return new Fraction((this.numerator * fraction.denominator) - (fraction.numerator * this.denominator), this.denominator * fraction.denominator);
    }

    public Fraction multiply(Fraction fraction){
        return new Fraction(this.numerator * fraction.numerator, this.denominator * fraction.denominator);
    }

    public Fraction divide(Fraction fraction){
        return new Fraction(this.numerator * fraction.denominator, this.denominator * fraction.numerator);
    }

    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }
    public void simplifyFraction() {
        int num = numerator;
        int den = denominator;
        while (den != 0)
        {
            int temp = den;
            den = num % den;
            num = temp;
        }
        numerator /= num;
        denominator /= num;
    }
}