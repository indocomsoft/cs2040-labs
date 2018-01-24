/*
 *
 * author	    : [Julius Putra Tanu Setiaji]
 * matric no  : [A0149787E]
 *
 */

import java.util.*;

public class HelloWorld {

  public static void main(String[] args) {

    // declare the necessary variables

    // declare a Scanner object to read input
    Scanner scan = new Scanner(System.in);

    // read input and process them accordingly
    int mode = scan.nextInt();

    if (mode == 1) {
      int n = scan.nextInt();
      // Advances the scanner to the next line
      scan.nextLine();
      for (int i = 1; i <= n; i++) {
        parseInput(scan.nextLine());
      }
    } else if (mode == 2) {
      String input = null;
      do {
        input = scan.nextLine();
        parseInput(input);
      } while (!input.equals("0"));
    } else if (mode == 3) {
      while (scan.hasNextLine()) {
        parseInput(scan.nextLine());
      }
    }
  }

  private static void parseInput(String input) {
    String[] parts = input.split(" ");
    if (parts[0].equals("AND")) {
      System.out.println(Integer.parseInt(parts[1]) & Integer.parseInt(parts[2]));
    } else if (parts[0].equals("OR")) {
      System.out.println(Integer.parseInt(parts[1]) | Integer.parseInt(parts[2]));
    }
  }
}
