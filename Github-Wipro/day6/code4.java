

import java.util.*;

public class UniqueHashMapDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<Integer, String> data = new HashMap<>();
        
        int count = 4;
        int index = 1;
        while (index <= count) {
            String value = input.next();
            data.put(index, value);
            index++;
        }

        System.out.print("Mappings of HashMap are : ");
        System.out.println(data);

        int keyToDelete = input.nextInt();
        if (data.containsKey(keyToDelete)) {
            data.remove(keyToDelete);
        }

        System.out.print("Mappings after removal are : ");
        System.out.println(data);

        input.close();
    }
}


