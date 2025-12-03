import java.util.InputMismatchException;
import java.util.*;

class Test {
    public static void main(String args[] ) throws Exception {
        
       
        Scanner scan = new Scanner(System.in);
        boolean valid = false;

        while (!valid) {
            try {
               
                int n1 = scan.nextInt();

              
                int n2 = scan.nextInt();

                int re = n1 / n2;
                System.out.println("Result: " + re);
                valid = true; 
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scan.nextLine();
            }
            catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero. Please enter a valid divisor.");
            }
        }
        scan.close();
    }
}