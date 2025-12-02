import java.util.Scanner;

public class Person {
    String name;
    int age;
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String name = sc.nextLine();

    int age = sc.nextInt();

    Person per = new Person();
    per.name = name;
    per.age = age;

    System.out.println("Name: " + per.name);
    System.out.println("Age: " + per.age);
    sc.close();
}
}