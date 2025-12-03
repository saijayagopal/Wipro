import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
		   
			  try {
		      String text = sc.nextLine();
        //write your answer here
        System.out.println("Original string: " + text);
        checkVowels(text);
        System.out.println("String contains vowels");
    }
    catch (NoVowelsException e) {
      System.out.println("String does not contain any vowels");
    }
    }
      public static void checkVowels(String text) 
      throws NoVowelsException { 
        if (!text.toLowerCase().matches(".*[aeiou].*")) {
          throw new NoVowelsException();
        }
        
      }
}
class NoVowelsException extends Exception
{
  
}
