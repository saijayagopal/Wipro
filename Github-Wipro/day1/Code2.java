import java.util.Scanner;

public class LogicalOperatorsExample {
    public static void main(String[] args) {
        Scanner sai = new Scanner(System.in);
        boolean input1 = sai.nextBoolean();
        boolean input2 = sai.nextBoolean();
        System.out.println(input1 && input2);
        System.out.println(input1 || input2);
    }
}