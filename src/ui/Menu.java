package ui;

import util.MyToys;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private static final List<String> optionsList = new ArrayList<>();
    private final String menuTitle;

    public Menu(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    /**
     * Checking if the option is already in present (duplicated) or not.
     * If it's empty, add it to the menu, otherwise ignore it.
     */
    public void addOptionsList(String newOption) {
        if (!optionsList.contains(newOption))
            optionsList.add(newOption);
    }

    /**
     * Method to display menu to users and print out
     * the options list retrieved by users input.
     */
    public void printMenu() {
        if (optionsList.isEmpty()) {
            System.out.println("NOTHING TO PRINT!");
        }
        System.out.println("\n--------------------------------------");
        System.out.println("WELCOME TO " + menuTitle);
        optionsList.forEach(System.out::println);
    }

    /**
     * Return the number which user choose as the function
     * that user want the app to do.
     * This method include getAnInteger method for handling
     * invalidate input.
     *
     */
    public int getChoice() {
        int maxOption = optionsList.size();
        String inputMessage = "CHOOSE FROM [1..." + maxOption + "]: ";
        String errorMessage = "YOU ARE REQUIRED TO CHOOSE FROM [1..." + maxOption + "]: ";
        return MyToys.getAnInteger(inputMessage, errorMessage, 1, maxOption);
        //Print out choose from [1..8] :
        //If they type wrong by any chances, getAnInteger will handle that situation.
    }
}

