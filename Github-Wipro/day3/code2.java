import java.util.Scanner;
public class Main {

    public static int sumOfDigits(int x) {

        //write your answer here
        if (x == 0)
        return 0;
        return(x % 10) + sumOfDigits(x/10);
    }
            

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            int sum = sumOfDigits(num);
            System.out.println(sum);
            sc.close();
        }
    }