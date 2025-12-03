import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sai = new Scanner(System.in);

        int x = sai.nextInt();
        int y = sai.nextInt();

        ArthemeticOperations a = new ArthemeticOperations(x, y);

        System.out.println("ARITHEMATIC OPERATIONS");

        Thread th = new Thread(a);
        th.start();
    }
}

class ArthemeticOperations implements Runnable {

    int i, j;

    ArthemeticOperations(int x, int y) {
        i = x;
        j = y;
    }

    public void run() {

        System.out.println("SUM " + (i + j));
        System.out.println("DIFFERENCE " + (i - j));

        
        System.out.println(" PRODUCT  " + (i * j));

        if (j != 0)
            System.out.println("RATIO  " + (i / j));
        else
            System.out.println("RATIO  Infinity");

        System.out.println("POWER  " + Math.pow(i, j));
        System.out.println("END OF A");
}
}
     // write code here 

  // complete the class below and create the thread to achive desired output