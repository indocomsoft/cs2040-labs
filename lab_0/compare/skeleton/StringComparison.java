/*
 *
 * author : [Julius Putra Tanu Setiaji]
 * matric no: [A0149787E]
 *
 */

import java.util.*;

public class StringComparison {

  public static void main(String[] args) {

    // declare the necessary variables

    // declare a Scanner object to read input
    Scanner scan = new Scanner(System.in);

    // read input and process them accordingly
    int result = scan.nextLine().compareToIgnoreCase(scan.nextLine());

    if (result > 0) {
      System.out.println(2);
    } else if (result < 0) {
      System.out.println(1);
    } else {
      System.out.println(0);
    }
  }
}
