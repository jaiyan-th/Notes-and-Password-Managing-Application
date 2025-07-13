import java.util.*;

public class NotesAndPasswordManager {
    private static Scanner scanner = new Scanner(System.in);

    private static List<String> notes = new ArrayList<>();
    private static Map<String, String> passwordStore = new HashMap<>();

    private static String masterPassword = "jaiy2005"; // Change this in production

    public static void main(String[] args) {
        if (!authenticate()) {
            System.out.println("Authentication Failed. Exiting...");
            return;
        }

        int choice;
        do {
            System.out.println("\n===== Notes and Password Manager =====");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Save Password");
            System.out.println("4. Retrieve Password");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addNote();
                    break;
                case 2:
                    viewNotes();
                    break;
                case 3:
                    savePassword();
                    break;
                case 4:
                    retrievePassword();
                    break;
                case 5:
                    System.out.println("Thank you for using the app.");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        } while (choice != 5);
    }

    private static boolean authenticate() {
        System.out.print("Enter master password: ");
        String input = scanner.nextLine();
        return input.equals(masterPassword);
    }

    private static void addNote() {
        System.out.print("Enter your note: ");
        String note = scanner.nextLine();
        notes.add(note);
        System.out.println("Note added.");
    }

    private static void viewNotes() {
        if (notes.isEmpty()) {
            System.out.println("No notes available.");
            return;
        }

        System.out.println("Your Notes:");
        for (int i = 0; i < notes.size(); i++) {
            System.out.println((i + 1) + ". " + notes.get(i));
        }
    }

    private static void savePassword() {
        System.out.print("Enter account name (e.g., Gmail): ");
        String account = scanner.nextLine();
        System.out.print("Enter password for " + account + ": ");
        String password = scanner.nextLine();
        passwordStore.put(account, password);
        System.out.println("Password saved.");
    }

    private static void retrievePassword() {
        System.out.print("Enter account name to retrieve password: ");
        String account = scanner.nextLine();
        if (passwordStore.containsKey(account)) {
            System.out.println("Password for " + account + ": " + passwordStore.get(account));
        } else {
            System.out.println("No password found for that account.");
        }
    }
}
 