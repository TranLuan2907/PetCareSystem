package util;

import java.util.Scanner;

public class MyToys {
    private static Scanner in = new Scanner(System.in);


    /**
     * This method get a primitive value input from the user.
     * All the exceptions will be handled, for example input a string instead an int.
     * Avoiding buffer by scanner.nextInt() by using wrapper class
     * Can check the input in a range.
     */
    public static int getAnInteger(String inputMessage, String errorMessage, int lowerBound, int upperBound) {
        int n, temp;
        if (lowerBound > upperBound) {
            temp = lowerBound;
            lowerBound = upperBound;
            upperBound = temp;
        }

        while (true) {
            try {
                System.out.print(inputMessage);
                n = Integer.parseInt(in.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMessage);
            }

        }
    }

    public static int getAnInteger(String inputMessage, String errorMessage) {
        int n;
        while (true) {
            try {
                System.out.print(inputMessage);
                n = Integer.parseInt(in.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errorMessage);
            }
        }
    }

    public static double getADouble(String inputMessage, String errorMessage, double upperBound, double lowerBound) {
        double n, temp;
        if (lowerBound > upperBound) {
            temp = lowerBound;
            lowerBound = upperBound;
            upperBound = temp;
        }

        while (true) {
            try {
                System.out.print(inputMessage);
                n = Double.parseDouble(in.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMessage);
            }
        }
    }

    public static double getADouble(String inputMessage, String errorMessage) {
        double n;
        while (true) {
            try {
                System.out.print(inputMessage);
                n = Double.parseDouble(in.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errorMessage);
            }
        }
    }

    //Get a string not empty
    public static String getString(String inputMessage, String errorMessage) {
        String n;
        while (true) {
            System.out.print(inputMessage);
            n = in.nextLine().trim();
            if (n.isEmpty()) {
                System.out.println(errorMessage);
            } else
                return n;
        }
    }

    public static String getID(String inputMessage, String errorMessage, String format) {
        String n;
        boolean match;
        while (true) {
            System.out.print(inputMessage);
            n = in.nextLine().trim().toUpperCase();
            match = n.matches(format);
            if (n.isEmpty() || !match) {
                System.out.println(errorMessage);
            } else
                return n;
        }
    }
}
