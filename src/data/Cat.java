package data;

import java.util.Random;

public class Cat extends Pet {
    private static final double MAX_SPEED = 30.00;

    public Cat(String id, String name, int yob, double weight) {
        super(id, name, yob, weight);
    }

    @Override
    public double run() {
        return new Random().nextDouble() * MAX_SPEED;
    }

    @Override
    public void showProfile() {
        String message = String.format("|%3s|%-8s|%-25s|%4d|%-6.1f|\n", "CAT", id, name, yob, weight);
        System.out.print(message);
    }
}
