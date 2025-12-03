public class Main {

    public static void main(String[] args) {

        //write your answer here
        Vehicle x = new Vehicle();
        Scooter y = new Scooter();
        Car z = new Car();

        x.noOfWheels();
        y.noOfWheels();
        z.noOfWheels();
    }
}

class Vehicle {
    void noOfWheels() {
        System.out.println("No of wheels undefined");
    }
}

class Scooter extends Vehicle {
    void noOfWheels() {
        System.out.println("No of wheels 2");
    }
}

class  Car extends Vehicle {
    void noOfWheels() {
        System.out.println("No of wheels 4");
    }
}