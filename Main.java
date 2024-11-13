import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("enter a and b for complex number a + bi: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        System.out.print("enter c and d for complex number c + di: ");
        double c = input.nextDouble();
        double d = input.nextDouble();
        input.close();
        Complex c1 = new Complex(a, b);
        Complex c2 = new Complex(c, d);
        System.out.println("\nc1=" + c1 + " c2=" + c2 + "\n");
        System.out.println("c1+c2=" + c1.add(c2));
        System.out.println("c1-c2= " + c1.subtract(c2));
        System.out.println("c1xc2= " + c1.multiply(c2));
        System.out.println("c1/c2= " + c1.divide(c2));
        System.out.println("|c1|= " + c1.abs());
        Complex c3 = (Complex) c1.clone();
        System.out.println("c3= " + c3);
        System.out.println("real part of c3: " + c3.getRealPart());
        System.out.println("imaginary part of c3: " + c3.getImaginaryPart());
        System.out.println("c1==c3 " + (c1 == c3));
        System.out.println("c1.equals(c3) " + c1.equals(c3));
        Complex c4 = new Complex(4, -0.5);
        System.out.println("c4 = " + c4);
        Complex[] list = { c1, c2, c3, c4 };
        Arrays.sort(list);
        System.out.println("c1, c2, c3 and c4 sorted: " + Arrays.toString(list));
    }}
class Complex implements Cloneable, Comparable<Complex> {
    private double real;
    private double imaginary;
    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    public double getRealPart() {
        return real;
    }
    public double getImaginaryPart() {
        return imaginary;
    }
    public Complex add(Complex other) {
        return new Complex(this.real + other.real, this.imaginary + other.imaginary);
    }
    public Complex subtract(Complex other) {
        return new Complex(this.real - other.real, this.imaginary - other.imaginary);
    }
    public Complex multiply(Complex other) {
        double newReal = this.real * other.real - this.imaginary * other.imaginary;
        double newImaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new Complex(newReal, newImaginary);
    }
    public Complex divide(Complex other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        double newReal = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
        double newImaginary = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
        return new Complex(newReal, newImaginary);
    }
    public double abs() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }
    @Override
    public Object clone() {
        return new Complex(this.real, this.imaginary);
    }
    @Override
    public int compareTo(Complex other) {
        double thisAbs = this.abs();
        double otherAbs = other.abs();
        if (thisAbs < otherAbs) {
            return -1;
        } else if (thisAbs > otherAbs) {
            return 1;
        } else {
            return 0;
        }}
    @Override
    public String toString() {
        if (imaginary >= 0) {
            return real + "+" + imaginary + "i";
        } else {
            return real + "-" + (-imaginary) + "i";
        }}
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Complex)) {
            return false;
        }
        Complex other = (Complex) obj;
        return this.real == other.real && this.imaginary == other.imaginary;
    }}
