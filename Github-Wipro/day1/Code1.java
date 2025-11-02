import java.util.Scanner;

public class ArithmeticOperations {
    public static void main(String[] args) {
        Scanner sai = new Scanner(System.in);

        
        int firstNumber = sai.nextInt();
        int secondNumber = sai.nextInt();

        
        System.out.println("Sum: " + (firstNumber + secondNumber));
        System.out.println("Difference: " + (firstNumber - secondNumber));
        System.out.println("Product: " + (firstNumber * secondNumber));
        System.out.println("Quotient: " + (firstNumber / secondNumber));
        System.out.println("Remainder: " + (firstNumber % secondNumber));

        sai.close();
    }
}