package equals111;

/**
 * Created by User on 01.10.2015.
 */
public final class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public int hashCode() {
        return (new Double(this.re)).hashCode() + (new Double(this.im)).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ComplexNumber cn = (ComplexNumber) obj;
        if(this.re == cn.getRe() && this.im == cn.getIm())
            return true;
        else return false;
    }
}