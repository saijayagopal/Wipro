import java.util.*;

public class PairFinder {
    public static int[] findPair(int size, int[] elements, int goal) {
        for (int a = 0; a < size; a++) {
            for (int b = a + 1; b < size; b++) {
                if (elements[a] + elements[b] == goal) {
                    return new int[]{a, b};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int[] numbers = new int[size];
        for (int k = 0; k < size; k++) {
            numbers[k] = scan.nextInt();
        }
        int goal = scan.nextInt();
        int[] result = findPair(size, numbers, goal);
        System.out.println("(" + result[0] + " , " + result[1] + ")");
        scan.close();
    }
}