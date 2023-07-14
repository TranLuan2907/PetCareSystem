package data;

import util.MyToys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cabinet {
    private static final List<Pet> petList = new ArrayList<>();

    public void addNewDog() {
        String id, name;
        int yob, pos;
        double weight;

        name = MyToys.getString("INPUT DOG NAME: ", "THE DOG NAME IS REQUIRED!");
        yob = MyToys.getAnInteger("INPUT DOG YEARS OF BIRTH: ", "THE YEARS OF BIRTH MUST BE FROM 2000 TO 2023!", 2000, 2023);
        weight = MyToys.getADouble("INPUT DOG WEIGHT: ", "THE DOG WEIGHT MUST BE FROM 0.1 TO 99.0!", 0.1, 99.0);
        do {
            id = MyToys.getID("INPUT DOG ID: ", "THE FORMAT OF ID IS FXXXXX (X STANDS FOR DIGIT)", "F\\d{5}");
            pos = searchPetByID(id);
            if (pos >= 0) {
                System.out.println("THE DOG ID IS ALREADY EXISTED! PLEASE TRY AGAIN!");
            }
        } while (pos != -1); //Prompt them to input again until they do it right.
        petList.add(new Dog(id, name, yob, weight));
        System.out.println("A DOG PROFILE IS ADDED SUCCESSFULLY!");
    }

    /**
     * Helper method
     * This method will return Pet found position in an array
     * -1: Not Found
     * >=0:Found
     */
    public int searchPetByID(String id) {
        if (petList.isEmpty()) {
            return -1; //Not Found!
        }

        for (int i = 0; i < petList.size(); i++) {
            if (petList.get(i).getId().equalsIgnoreCase(id)) {
                return i; //Return an address of duplicated id
                //Can return any other positive numbers
                //and using for-each.
            }
        }
        return -1; //Not Found!
    }

    public void addNewCat() {
        String id, name;
        int yob, pos;
        double weight;

        name = MyToys.getString("INPUT CAT NAME: ", "A CAT NAME IS REQUIRED!");
        yob = MyToys.getAnInteger("INPUT CAT YEARS OF BIRTH: ", "A CAT YEARS OF BIRTH MUST BE FROM 2000 TO 2023!", 2000, 2023);
        weight = MyToys.getADouble("INPUT CAT WEIGHT: ", "A CAT WEIGHT MUST BE FROM 0.1 TO 99.0!", 0.1, 99.0);
        do {
            id = MyToys.getID("INPUT CAT ID: ", "A CAT ID MUST BE IN FORMAT DXXXXX (X STAND FOR DIGIT)", "D\\d{5}");
            pos = searchPetByID(id);
            if (pos >= 0) {
                System.out.println("THE CAT ID IS ALREADY EXISTED. PLEASE TRY AGAIN!");
            }
        } while (pos != -1);
        petList.add(new Cat(id, name, yob, weight));
        System.out.println("A CAT PROFILE IS ADDED SUCCESSFULLY");
    }

    public void searchByID() {
        String id;
        Pet x;
        id = MyToys.getString("INPUT PET ID: ", "PET ID IS REQUIRED!");
        x = searchObjectPetID(id);
        if (x == null) {
            System.out.println("NOT FOUND!");
        } else {
            System.out.println("FOUND! HERE IT IS");
            String header = String.format("|%3s|%-8s|%-25s|%-4s|%6s|", "PET", "ID", "NAME", "YOB", "WEIGHT");
            System.out.println(header);
            x.showProfile();
        }
    }

    /**
     * Return an object
     * If found, return the pointer that point to Pet found, it means
     * we have 2 pointers simultaneously pointed to same new Pet
     */
    public Pet searchObjectPetID(String id) {
        if (petList.isEmpty()) {
            return null;
        }

        for (Pet pet : petList) {
            if (pet.getId().equalsIgnoreCase(id)) {
                return pet;
            }
        }
        return null;
    }

    public void updateByID() {
        Pet x;
        String tmpName;
        String id;
        int tmpYob;
        double tmpWeight;
        id = MyToys.getString("INPUT A PET ID: ", "PET ID IS REQUIRED!");
        x = searchObjectPetID(id);
        if (x == null) {
            System.out.println("NOT FOUND!");
        } else {
            System.out.println("BEFORE UPDATING: ");
            x.showProfile();


            printUpdatedMenu();

            int choice = MyToys.getAnInteger("SELECT AN OPTION: ", "YOUR OPTIONS MUST BE FROM 1 TO 4!", 1, 4);
            switch (choice) {
                case 1 -> {
                    System.out.println("YOU ARE REQUIRED TO INPUT A NEW NAME");
                    tmpName = MyToys.getString("INPUT A NEW NAME: ", "A NEW NAME IS REQUIRED!");
                    x.setName(tmpName);
                    System.out.println("CHANGING SUCCESSFULLY!");
                }
                case 2 -> {
                    System.out.println("YOU ARE REQUIRED TO INPUT A NEW YEARS OF BIRTH");
                    tmpYob = MyToys.getAnInteger("INPUT A NEW YEARS OF BIRTH: ", "YEARS OF BIRTH MUST BE FROM 2000 TO 2023", 2000, 2023);
                    x.setYob(tmpYob);
                    System.out.println("CHANGING SUCCESSFULLY!");
                }
                case 3 -> {
                    System.out.println("YOU ARE REQUIRED TO INPUT A NEW WEIGHT");
                    tmpWeight = MyToys.getADouble("YOU ARE REQUIRED TO INPUT A NEW WEIGHT", "WEIGHT MUST BE FROM 0.1 to 99.0!", 0.1, 99.0);
                    x.setWeight(tmpWeight);
                    System.out.println("CHANGING SUCCESSFULLY!");
                }
                case 4 -> System.out.println("UPDATED CANCELLED");
            }
        }
    }

    public void removeByID() {
        String id, answer;
        int pos;
        id = MyToys.getString("INPUT A PET ID: ", "A PET ID IS REQUIRED!");
        pos = searchPetByID(id);
        if (pos == -1) {
            System.out.println("NOT FOUND!");
        } else {
            System.out.println("ARE YOU SURE YOU WANT TO REMOVE THE PET (Y OR N)");
            System.out.println("THIS IS THE PET LIST BEFORE REMOVING");
            Pet petToRemove = petList.get(pos);
            petToRemove.showProfile();
            answer = MyToys.getString("ENTER YOUR CHOICE (Y OR N): ", "AN ANSWER IS REQUIRED!");

            if (answer.equalsIgnoreCase("Y")) {
                petList.remove(pos);
                System.out.println("PET HAS BEEN DELETED SUCCESSFULLY");
            } else {
                System.out.println("DELETE CANCELLED!");
            }
        }
    }

    public void printAscendingID() {
        if (petList.isEmpty()) {
            System.out.println("NOT FOUND!");
        } else {

            Collections.sort(petList);
            System.out.println("----------------------------------");
            System.out.println("HERE IS THE PET LIST");
            String header = String.format("|%3s|%-8s|%-25s|%-4s|%6s|", "PET", "ID", "NAME", "YOB", "WEIGHT");
            System.out.println(header);
            petList.forEach(Pet::showProfile);

        }
    }

    public void printDescendingID() {
        if (petList.isEmpty()) {
            System.out.println("NOT FOUND!");
        } else {
            petList.sort(Comparator.comparing(Pet::getId, String.CASE_INSENSITIVE_ORDER).reversed());
            System.out.println("-----------------------------------");
            System.out.println("HERE IS THE PET LIST");
            String header = String.format("|%3s|%-8s|%-25s|%-4s|%6s|", "PET", "ID", "NAME", "YOB", "WEIGHT");
            System.out.println(header);
            petList.forEach(Pet::showProfile);
        }
    }

    public void printAscendingName() {
        if (petList.isEmpty()) {
            System.out.println("NOT FOUND!");
        } else {
            petList.sort(Comparator.comparing(Pet::getName, String.CASE_INSENSITIVE_ORDER));
            System.out.println("------------------------------------");
            System.out.println("HERE IS THE PET LIST");
            String header = String.format("|%3s|%-8s|%-25s|%-4s|%6s|", "PET", "ID", "NAME", "YOB", "WEIGHT");
            System.out.println(header);
            petList.forEach(Pet::showProfile);
        }
    }

    public void printDescendingName() {
        if (petList.isEmpty()) {
            System.out.println("NOT FOUND!");
        } else {
            petList.sort(Comparator.comparing(Pet::getName, String.CASE_INSENSITIVE_ORDER).reversed());
            System.out.println("------------------------------------");
            System.out.println("HERE IS THE PET LIST");
            String header = String.format("|%3s|%-8s|%-25s|%-4s|%6s|", "PET", "ID", "NAME", "YOB", "WEIGHT");
            System.out.println(header);
            petList.forEach(Pet::showProfile);
        }
    }

    public void printAscendingYob() {
        if (petList.isEmpty()) {
            System.out.println("NOT FOUND!");
        } else {
            petList.sort(Comparator.comparingInt(Pet::getYob));
            System.out.println("-------------------------------------");
            System.out.println("HERE IS THE PET LIST");
            String header = String.format("|%3s|%-8s|%-25s|%-4s|%6s|", "PET", "ID", "NAME", "YOB", "WEIGHT");
            System.out.println(header);
            petList.forEach(Pet::showProfile);
        }
    }

    public void printDescendingYob() {
        if (petList.isEmpty()) {
            System.out.println("NOT FOUND!");
        } else {
            petList.sort(Comparator.comparingInt(Pet::getYob).reversed());
            System.out.println("---------------------------------------");
            System.out.println("HERE IS THE PET LIST");
            String header = String.format("|%3s|%-8s|%-25s|%-4s|%6s|", "PET", "ID", "NAME", "YOB", "WEIGHT");
            System.out.println(header);
            petList.forEach(Pet::showProfile);
        }
    }

    public void printUpdatedMenu() {
        System.out.println("SELECT THE INFORMATION THAT YOU WANT TO CHANGE");
        System.out.println("1. NAME");
        System.out.println("2. YEARS OF BIRTH ");
        System.out.println("3. WEIGHT");
        System.out.println("4. QUIT");
    }

    public void printAscendingWeight() {
        if (petList.isEmpty()) {
            System.out.println("NOT FOUND!");
        } else {
            petList.sort(Comparator.comparingDouble(Pet::getWeight));
            System.out.println("---------------------------------------");
            System.out.println("HERE IS THE PET LIST");
            String header = String.format("|%3s|%-8s|%-25s|%-4s|%6s|", "PET", "ID", "NAME", "YOB", "WEIGHT");
            System.out.println(header);
            petList.forEach(Pet::showProfile);
        }
    }

    public void printDescendingWeight() {
        if (petList.isEmpty()) {
            System.out.println("NOT FOUND!");
        } else {
            petList.sort(Comparator.comparingDouble(Pet::getWeight).reversed());
            System.out.println("---------------------------------------");
            System.out.println("HERE IS THE PET LIST");
            String header = String.format("|%3s|%-8s|%-25s|%-4s|%6s|", "PET", "ID", "NAME", "YOB", "WEIGHT");
            System.out.println(header);
            petList.forEach(Pet::showProfile);
        }
    }
}
