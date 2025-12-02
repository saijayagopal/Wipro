import java.util.Scanner;
public class Constructor {
    private int length;
    private int width;
    private int height;

public Constructor() {
        this.length = 10;
        this.width = 10;
        this.height = 10;
        System.out.println("Constructor without parameter");
        displayVolume();
    }
    public Constructor(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
        System.out.println("Constructor with parameter");
        displayVolume();
    }
public void displayVolume() {
    double volume = (double) this.length * this.width * this.height;
    System.out.println("Volume is " +volume);
}
public static void main(String[] args) {
   Scanner s = new Scanner(System.in);
	Constructor cuboid1 = new Constructor();
    int l = s.nextInt();
    int w = s.nextInt();
    int h = s.nextInt();

    Constructor cubiod2 = new Constructor(l,w,h);
    s.close();
    }
}