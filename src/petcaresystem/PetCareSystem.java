package petcaresystem;

import data.Cabinet;
import ui.Menu;

/**
 * Main menu of the app
 */

public class PetCareSystem {
    public static void main(String[] args) {
        Menu menu = new Menu("PET CARE SYSTEM MANAGEMENT!");
        menu.addOptionsList("1.  ADD A NEW DOG PROFILE");
        menu.addOptionsList("2.  ADD A NEW CAT PROFILE");
        menu.addOptionsList("3.  SEARCH A PET PROFILE BY ID");
        menu.addOptionsList("4.  UPDATE A PET PROFILE BY ID");
        menu.addOptionsList("5.  REMOVE A PET PROFILE BY ID");
        menu.addOptionsList("6.  PRINT THE PET LIST ASCENDING BY ID");
        menu.addOptionsList("7.  PRINT THE PET LIST DESCENDING BY ID");
        menu.addOptionsList("8.  PRINT THE PET LIST ASCENDING BY NAME");
        menu.addOptionsList("9.  PRINT THE PET LIST DESCENDING BY NAME");
        menu.addOptionsList("10. PRINT THE PET LIST ASCENDING BY YEARS OF BIRTH");
        menu.addOptionsList("11. PRINT THE PET LIST DESCENDING BY YEARS OF BIRTH");
        menu.addOptionsList("12. PRINT THE PET LIST ASCENDING BY WEIGHT");
        menu.addOptionsList("13. PRINT THE PET LIST DESCENDING BY WEIGHT");
        menu.addOptionsList("14. QUIT");


        //Buy a new cabinet to contains and handling some information about pet.
        Cabinet cage = new Cabinet();

        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1 -> cage.addNewDog();
                case 2 -> cage.addNewCat();
                case 3 -> cage.searchByID();
                case 4 -> cage.updateByID();
                case 5 -> cage.removeByID();
                case 6 -> cage.printAscendingID();
                case 7 -> cage.printDescendingID();
                case 8 -> cage.printAscendingName();
                case 9 -> cage.printDescendingName();
                case 10 -> cage.printAscendingYob();
                case 11 -> cage.printDescendingYob();
                case 12 -> cage.printAscendingWeight();
                case 13 -> cage.printDescendingWeight();
                case 14 -> System.out.println("SEE YOU NEXT TIME!");
            }
        } while (choice != 14);
    }
}
