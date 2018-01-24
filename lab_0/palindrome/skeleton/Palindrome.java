/*
 * author   : [Julius Putra Tanu Setiaji]
 * matric no. : [A0149787E]
 */

import java.util.*;

public class Palindrome {
  /* use this method to check whether the string is palindrome word or not
   *    PRE-Condition  : TRUE
   *    POST-Condition : returns true if the word is palindrome
   */
  public static boolean isPalindrome(String word) {
    return word.equals(new StringBuffer(word).reverse().toString());
  }

  public static void main(String[] args) {
    // declare the necessary variables

    // declare a Scanner object to read input
    Scanner scan = new Scanner(System.in);

    // read input and process them accordingly
    // simulate the problem
    // output the result
    if (isPalindrome(scan.nextLine() + scan.nextLine())) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }
}
