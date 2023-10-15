package Project1.LockedFolder;

import java.io.File;
import java.util.Scanner;

public class FolderLocker {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String folderPath = "C:\\Users\\DELL\\OneDrive\\Documents\\CodeClause\\Project1\\LockedFolder"; // Change this to your desired folder path
            String password = "12345678"; // Set your password

            while (true) {
                System.out.println("Enter 'lock' to lock the folder or 'unlock' to unlock it:");
                String choice = scanner.next();

                if (choice.equalsIgnoreCase("lock")) {
                    System.out.println("Enter the password to lock the folder:");
                    String enteredPassword = scanner.next();
                    if (enteredPassword.equals(password)) {
                        lockFolder(folderPath);
                        System.out.println("Folder locked successfully.");
                    } else {
                        System.out.println("Incorrect password. Folder not locked.");
                    }
                } else if (choice.equalsIgnoreCase("unlock")) {
                    System.out.println("Enter the password to unlock the folder:");
                    String enteredPassword = scanner.next();
                    if (enteredPassword.equals(password)) {
                        unlockFolder(folderPath);
                        System.out.println("Folder unlocked successfully.");
                    } else {
                        System.out.println("Incorrect password. Folder not unlocked.");
                    }
                } else {
                    System.out.println("Invalid choice. Please enter 'lock' or 'unlock'.");
                }
            }
        }
    }

    private static void lockFolder(String folderPath) {
        File folder = new File(folderPath);
        if (folder.exists() && folder.isDirectory()) {
            File newFolder = new File(folderPath + "_locked");
            folder.renameTo(newFolder);
        }
    }

    private static void unlockFolder(String folderPath) {
        File folder = new File(folderPath + "_locked");
        if (folder.exists() && folder.isDirectory()) {
            File newFolder = new File(folderPath);
            folder.renameTo(newFolder);
        }
    }
}
