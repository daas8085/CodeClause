import java.util.Scanner;
import java.io.File;

public class FolderLocker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    lockFolder(scanner);
                    break;
                case 2:
                    unlockFolder(scanner);
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Folder Locker Menu:");
        System.out.println("1. Lock Folder");
        System.out.println("2. Unlock Folder");
        System.out.println("3. Exit");
    }

    private static int getUserChoice(Scanner scanner) {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    private static void lockFolder(Scanner scanner) {
        System.out.print("Enter the folder path to lock: ");
        String folderPath = scanner.next();

        File folder = new File(folderPath);

        if (folder.exists() && folder.isDirectory()) {
            // Implement folder locking mechanism (e.g., encryption)
            System.out.println("Folder locked successfully!");
        } else {
            System.out.println("Invalid folder path. Please try again.");
        }
    }

    private static void unlockFolder(Scanner scanner) {
        System.out.print("Enter the folder path to unlock: ");
        String folderPath = scanner.next();

        File folder = new File(folderPath);

        if (folder.exists() && folder.isDirectory()) {
            // Implement folder unlocking mechanism (e.g., decryption)
            System.out.println("Folder unlocked successfully!");
        } else {
            System.out.println("Invalid folder path. Please try again.");
        }
    }
}
