

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sai = new Scanner(System.in);
        ArrayList<Integer> li = new ArrayList<>();
        while(sai.hasNext()) {
            li.add(sai.nextInt());
        }
        System.out.println("List before sort: " + li);
        Collections.sort(li);
        System.out.println("List after sort: " + li);
    }
}


