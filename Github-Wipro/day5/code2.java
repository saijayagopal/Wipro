import java.util.Scanner;
public class Test {

    public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
        //write your answer here
        try {
            String input = sc.nextLine();
            int num = Integer.parseInt(input);
            if (99 % num == 0) {
                System.out.println(num + " is a factor of 99");
            } else {
                System.out.println(num + " is a not a factor of 99");
            }
        }
        catch (ArithmeticException e) {
            System.out.println("Arthemetic Exception" + e);
        }
        catch (NumberFormatException e) {
            System.out.println("Number Format Exception " + e);
        }
    }
}
