/**
 * Name         : Julius Putra Tanu Setiaji
 * Matric No.   : A0149787E
 * PLab Acct.   :
 */
import java.util.*;

class Modulo {
  private int
      value; // To store the value of the number, must be non-negative and less than the modulus
  private int modulus; // To store the modulus of the Modulo

  // Add more attributes, constructor and methods here if required

  /**
   * Constructor class for Modulo
   * Pre-condition: Modulus cannot be zero and value cannot be negative
   */
  Modulo(int value, int modulus) {
    if (modulus == 0) {
      throw new IllegalArgumentException("Modulus cannot be zero.");
    }
    this.value = value % modulus;
    this.modulus = modulus;
  }

  /**
   * Returns the value of the Modulo value
   */
  public int getValue() {
    return value;
  }

  /**
   * Adds two Modulo values and returns a new Modulo value as a result
   * Pre-condition: Modulus must be the same
   */
  public Modulo plus(Modulo other) {
    if (this.modulus != other.modulus) {
      throw new IllegalArgumentException("Modulus do not match.");
    }
    return new Modulo(this.getValue() + other.getValue(), this.modulus);
  }

  /**
   * Subtracts two Modulo values and returns a new Modulo value as a result
   * Pre-condition: Modulus must be the same
   */
  public Modulo minus(Modulo other) {
    if (this.modulus != other.modulus) {
      throw new IllegalArgumentException("Modulus do not match.");
    }
    int newValue = this.getValue() - other.getValue();
    if (newValue < 0) {
      newValue += modulus * (Math.abs(newValue) / modulus + 1);
    }
    return new Modulo(newValue, this.modulus);
  }

  /**
   * Multiples two Modulo values and returns a new Modulo value as a result
   * Pre-condition: Modulus must be the same
   */
  public Modulo times(Modulo other) {
    if (this.modulus != other.modulus) {
      throw new IllegalArgumentException("Modulus do not match.");
    }
    return new Modulo(this.getValue() * other.getValue(), this.modulus);
  }

  /**
   * Divides two Modulo values and returns a new Modulo value as a result
   * Pre-condition: Modulus must be the same and division must be valid
   */
  public Modulo divide(Modulo other) {
    if (this.modulus != other.modulus) {
      throw new IllegalArgumentException("Modulus do not match.");
    }
    return new Modulo(this.getValue() * other.findInverse().getValue(), this.modulus);
  }

  /**
   * Find modular inverse of the Modulo value
   * Pre-condition: Inverse must exist
   */
  public Modulo findInverse() {
    int xx = 0;
    int x = 1;
    int yy = 1;
    int y = 0;
    int a = this.value;
    int b = this.modulus;
    while (b > 0) {
      int q = a / b;
      int t = b;
      b = a % b;
      a = t;
      t = xx;
      xx = x - q * xx;
      x = t;
      t = yy;
      yy = y - q * yy;
      y = t;
    }
    if (a > 1) {
      throw new ArithmeticException("Inverse does not exist.");
    } else {
      return new Modulo((x + this.modulus) % this.modulus, this.modulus);
    }
  }
}

public class ModuloTester {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      int a = sc.nextInt();
      String op = sc.next();
      int b = sc.nextInt();
      int m = sc.nextInt();
      Modulo modA = new Modulo(a, m);
      Modulo modB = new Modulo(b, m);

      Modulo result;
      switch (op) {
        case "PLUS":
          result = modA.plus(modB);
          break;
        case "MINUS":
          result = modA.minus(modB);
          break;
        case "TIMES":
          result = modA.times(modB);
          break;
        case "DIVIDE":
          result = modA.divide(modB);
          break;
        default:
          result = null;
          break;
      }
      System.out.println(result.getValue());
    }
  }
}
