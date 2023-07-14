package data;

import java.util.Random;

public class Dog extends Pet {

    private static final double MAX_SPEED = 40.00;

    public Dog(String id, String name, int yob, double weight) {
        super(id, name, yob, weight);
    }

    @Override
    public double run() {
        return new Random().nextDouble() * MAX_SPEED;
    }

    @Override
    public void showProfile() {
        String message = String.format("|%3s|%-8s|%-25s|%4d|%-6.1f|\n", "DOG", id, name, yob, weight);
        System.out.print(message);
    }
}
