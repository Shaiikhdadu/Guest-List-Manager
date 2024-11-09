import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GuestListManagerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> guestList = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("\nWelcome to the Guest List Manager App");
            System.out.println("1. Add a New Guest");
            System.out.println("2. View the Guest List");
            System.out.println("3. Delete a Guest");
            System.out.println("4. Guest List in Alphabetical order");
            System.out.println("5. Search for a Guest");
            System.out.println("6. Update the Guest Name");
            System.out.println("7. Total Number of Guests coming");
            System.out.println("8. Quit");
            System.out.print("Enter your choice [1 to 8]: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("\nEnter the Guest Name: ");
                    String newGuest = scanner.nextLine();
                    guestList.add(newGuest);
                    System.out.println(newGuest + " has been inserted successfully");
                    break;
                case 2:
                    System.out.println("\n-------------------------------");
                    System.out.println("Guest List is as follows:");
                    for (int i = 0; i < guestList.size(); i++) {
                        System.out.println((i + 1) + ". " + guestList.get(i));
                    }
                    System.out.println("-------------------------------");
                    break;
                case 3:
                    System.out.print("\nDo you want to delete based on\n" +
                                     "a. Value\n" +
                                     "b. Position\n" +
                                     "Your Choice [a/b]: ");
                    char deleteChoice = scanner.nextLine().charAt(0);
                    if (deleteChoice == 'a') {
                        System.out.print("Enter the Guest Name to be removed: ");
                        String guestToRemove = scanner.nextLine();
                        if (guestList.remove(guestToRemove)) {
                            System.out.println(guestToRemove + " has been successfully removed");
                        } else {
                            System.out.println("Guest not found.");
                        }
                    } else if (deleteChoice == 'b') {
                        System.out.print("Enter the Position Number to delete: ");
                        int position = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        if (position > 0 && position <= guestList.size()) {
                            String removedGuest = guestList.remove(position - 1);
                            System.out.println(removedGuest + " has been deleted successfully");
                        } else {
                            System.out.println("Invalid position.");
                        }
                    }
                    break;
                case 4:
                    Collections.sort(guestList);
                    System.out.println("\nGuest List sorted in Alphabetical Order");
                    System.out.println("-------------------------------");
                    System.out.println("Guest List is as follows:");
                    for (int i = 0; i < guestList.size(); i++) {
                        System.out.println((i + 1) + ". " + guestList.get(i));
                    }
                    System.out.println("-------------------------------");
                    break;
                case 5:
                    System.out.print("\nEnter the Guest Name to Search: ");
                    String searchGuest = scanner.nextLine();
                    if (guestList.contains(searchGuest)) {
                        System.out.println(searchGuest + " is part of the Guest List");
                    } else {
                        System.out.print("Sorry! " + searchGuest + " is not part of the Guest List\n" +
                                         "Do you want to add this as a Guest? [yes / no] : ");
                        String addChoice = scanner.nextLine();
                        if (addChoice.equalsIgnoreCase("yes")) {
                            guestList.add(searchGuest);
                            System.out.println(searchGuest + " has been inserted successfully");
                        }
                    }
                    break;
                case 6:
                    System.out.print("\nEnter the Guest Name to update: ");
                    String oldName = scanner.nextLine();
                    if (guestList.contains(oldName)) {
                        System.out.print("Enter the New Name: ");
                        String newName = scanner.nextLine();
                        guestList.set(guestList.indexOf(oldName), newName);
                        System.out.println("Guest name updated to " + newName);
                    } else {
                        System.out.println("Guest not found.");
                    }
                    break;
                case 7:
                    System.out.println("\nTotal Number of Guests coming to the Party = " + guestList.size());
                    break;
                case 8:
                    System.out.println("Thank you for using our Application");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please select between 1 to 8.");
            }
        }

        scanner.close();
    }
}