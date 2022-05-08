package gr.aueb.cf.project02;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Project02 {

    static Scanner in = new Scanner(System.in);
    static int positionOfFound;
    static int emptyPosition;

    public static void main(String[] args) {
        runApp();
    }

    public static void printMenu () {
        System.out.println("1. Search contact based on phone number");
        System.out.println("2. Create new contact");
        System.out.println("3. Update contact");
        System.out.println("4. Delete contact");
        System.out.println("5. Exit");
    }

    public static void printUpdateMenu () {
        System.out.println("1. Surname");
        System.out.println("2. First name");
        System.out.println("3. Phone number");
        System.out.println("4. Everything");
    }

    public static void searchContact (String[][] strArr) {
        String phoneNo;
        boolean found = false;

        System.out.println("Please type the phone number of the contact you are looking for");
        phoneNo = in.next();

        found = contactFound(strArr, phoneNo);

        if (found) {
            System.out.println("Contact found");
            System.out.printf("Your contact is: %s %s", strArr[positionOfFound][1], strArr[positionOfFound][0]);
        } else {
            System.out.println("Contact was not found");
        }
    }

    public static void createContact (String[][] strArr) {
        boolean emptyPositionFound = emptyPositionFound(strArr);;

        if (emptyPositionFound) {
            String phoneNo;
            boolean found = false;

            System.out.println("Please type the phone number of the new contact");
            phoneNo = in.next();

            found = contactFound(strArr, phoneNo);

            if (found) {
                System.out.println("This phone number already exists");
                System.out.printf("It represents the following contact: %s %s", strArr[positionOfFound][1], strArr[positionOfFound][0]);
            } else {
                strArr[emptyPosition][2] = phoneNo;

                System.out.println("Please type the surname of the new contact");
                strArr[emptyPosition][0] = in.next();

                System.out.println("Please type the first name of the new contact");
                strArr[emptyPosition][1] = in.next();

                System.out.println("New contact created successfully");
                System.out.printf("Surname: %s First name: %s Phone: %s", strArr[emptyPosition][0], strArr[emptyPosition][1], phoneNo);
            }
        } else {
            System.out.println("You cannot insert any other contacts; table is full");
        }
    }

    public static void updateContact (String[][] strArr) {
        String phoneNo;
        boolean found = false;
        int userInput;

        System.out.println("Please type the phone number of the contact you want to update");
        phoneNo = in.next();

        found = contactFound(strArr, phoneNo);

        if (found) {
            System.out.println("Please choose which input you want to update based on the below:");
            printUpdateMenu();

            try {
                userInput = in.nextInt();

                switch (userInput) {
                    case 1:
                        System.out.println("Please insert new surname");
                        strArr[positionOfFound][0] = in.next();
                        System.out.printf("\nContact updated successfully to: Surname: %s, First name: %s, Phone: %s", strArr[positionOfFound][0], strArr[positionOfFound][1], strArr[positionOfFound][2]);
                        break;
                    case 2:
                        System.out.println("Please insert new first name");
                        strArr[positionOfFound][1] = in.next();
                        System.out.printf("\nContact updated successfully to: Surname: %s, First name: %s, Phone: %s", strArr[positionOfFound][0], strArr[positionOfFound][1], strArr[positionOfFound][2]);
                        break;
                    case 3:
                        System.out.println("Please insert new phone number");
                        strArr[positionOfFound][2] = in.next();
                        System.out.printf("\nContact updated successfully to: Surname: %s, First name: %s, Phone: %s", strArr[positionOfFound][0], strArr[positionOfFound][1], strArr[positionOfFound][2]);
                        break;
                    case 4:
                        System.out.println("Please insert new surname");
                        strArr[positionOfFound][0] = in.next();
                        System.out.println("Please insert new first name");
                        strArr[positionOfFound][1] = in.next();
                        System.out.println("Please insert new phone number");
                        strArr[positionOfFound][2] = in.next();
                        System.out.printf("\nContact updated successfully to: Surname: %s, First name: %s, Phone: %s", strArr[positionOfFound][0], strArr[positionOfFound][1], strArr[positionOfFound][2]);
                        break;
                    default:
                        System.out.println("Invalid input; please enter from choices 1-4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input; please enter from choices 1-4");
                in.nextLine();
            }

        } else {
            System.out.println("This contact does not exist");
        }
    }

    public static void deleteContact (String[][] strArr) {
        String phoneNo;
        boolean found = false;

        System.out.println("Please type the phone number of the contact you want to delete");
        phoneNo = in.next();

        found = contactFound(strArr, phoneNo);

        if (found) {
            for (int i = 0; i < 3; i++) strArr[positionOfFound][i] = "";
            System.out.println("Contact successfully deleted");
        } else {
            System.out.println("This contact does not exist");
        }
    }

    public static boolean contactFound (String[][] strArr, String phoneNo) {
        boolean found = false;
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i][2].equals(phoneNo)) {
                found = true;
                positionOfFound = i;
                break;
            }
        }
        return found;
    }

    public static boolean emptyPositionFound (String[][] strArr) {
        boolean emptyPositionFound = false;
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i][0].isEmpty()) {
                emptyPositionFound = true;
                emptyPosition = i;
                break;
            }
        }
        return emptyPositionFound;
    }

    public static void fillArr (String[][] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            Arrays.fill(strArr[i], "");
        }
    }

    public static void insertData (String[][] strArr) {
        //contact 1
        strArr[0][0] = "Skywalker";
        strArr[0][1] = "Luke";
        strArr[0][2] = "001";

        //contact 2
        strArr[1][0] = "Vader";
        strArr[1][1] = "Darth";
        strArr[1][2] = "002";

        //contact 3
        strArr[2][0] = "Solo";
        strArr[2][1] = "Hans";
        strArr[2][2] = "003";

        //contact 4
        strArr[3][0] = "Organa Solo";
        strArr[3][1] = "Leia";
        strArr[3][2] = "004";

        //contact 5
        strArr[4][0] = "D2";
        strArr[4][1] = "R2";
        strArr[4][2] = "005";

        //contact 6
        strArr[5][0] = "Unknown";
        strArr[5][1] = "Chewbacca";
        strArr[5][2] = "006";
    }

    public static void runApp () {
        String[][] contacts = new String[500][3];
        int userInput;

        fillArr(contacts);

        insertData(contacts);

        while (true) {
            System.out.println("\n\nChoose what you want to do");
            printMenu();
            try {
                userInput = in.nextInt();

                if (userInput == 5){
                    System.out.println("Bye!");
                    break;
                }

                switch (userInput) {
                    case 1:
                        searchContact(contacts);
                        break;
                    case 2:
                        createContact(contacts);
                        break;
                    case 3:
                        updateContact(contacts);
                        break;
                    case 4:
                        deleteContact(contacts);
                        break;
                    default:
                        System.out.println("Invalid input; please enter from choices 1-5");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input; please enter from choices 1-5");
                in.nextLine();
            }
        }
    }
}