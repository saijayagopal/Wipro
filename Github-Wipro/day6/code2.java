import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();

        switch (option) {
            case 1:
                Calculator<Integer> obj1 = new Calculator<>();
                obj1.sum(30, 20);
                break;

            case 2:
                Calculator<Double> obj2 = new Calculator<>();
                obj2.sum(10.0, 20.0);
                break;

            case 3:
                Calculator<Float> obj3 = new Calculator<>();
                obj3.sum(20.0f, 20.0f);
                break;

            default:
                System.out.println("Invalid input");
        }
    }
}

class Calculator<N extends Number> {
    void sum(N num1, N num2) {
        double result = num1.doubleValue() + num2.doubleValue();
        System.out.println("the sum is = " + result);
    }
}


