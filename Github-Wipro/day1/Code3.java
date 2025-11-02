import java.util.Scanner;

public class RelationalOperatorExample {
    public static void main(String[] args) {
        Scanner sai = new Scanner(System.in);
        int num1 = sai.nextInt();
        int num2 = sai.nextInt();
        if(num1 > num2) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
           sai.close();
    }
}