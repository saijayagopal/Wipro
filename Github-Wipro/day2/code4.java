import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        //write your answer here
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        int maxFreq = 0;
        for (int f : freq) {
            if (f > maxFreq) {
                maxFreq = f;
            }
        }
        int minMoves = s.length() - maxFreq;
        System.out.println(minMoves);
        scanner.close();
    }
}