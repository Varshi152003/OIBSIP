import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ATMInterface {

    private static final String USER_ID = "user123";
    private static final String USER_PIN = "1234";

    private static final String DATA_FOLDER = "ATMInterface/data";
    private static final String BALANCE_FILE = DATA_FOLDER + "/balance.txt";
    private static final String HISTORY_FILE = DATA_FOLDER + "/transactions.txt";

    private static double balance = 5000.00;
    private static ArrayList<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        createDataFolder();
        loadBalance();
        loadTransactionHistory();

        System.out.println("====================================");
        System.out.println("          ATM INTERFACE");
        System.out.println("====================================");

        if (login(scanner)) {
            addTransaction("Login successful");
            showMenu(scanner);
        } else {
            System.out.println("\nInvalid User ID or PIN. Access denied.");
        }

        scanner.close();
    }

    private static boolean login(Scanner scanner) {

        System.out.print("Enter User ID: ");
        String enteredUserId = scanner.nextLine();

        System.out.print("Enter PIN: ");
        String enteredPin = scanner.nextLine();

        return enteredUserId.equals(USER_ID) && enteredPin.equals(USER_PIN);
    }

    private static void showMenu(Scanner scanner) {

        int choice = 0;

        do {
            System.out.println("\n========== ATM MENU ==========");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Check Balance");
            System.out.println("6. Quit");
            System.out.println("==============================");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        showTransactionHistory();
                        break;

                    case 2:
                        withdraw(scanner);
                        break;

                    case 3:
                        deposit(scanner);
                        break;

                    case 4:
                        transfer(scanner);
                        break;

                    case 5:
                        checkBalance();
                        addTransaction("Balance checked: Rs." + balance);
                        break;

                    case 6:
                        System.out.println("\nThank you for using the ATM. Goodbye!");
                        addTransaction("User logged out");
                        break;

                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }

            } else {
                System.out.println("Invalid input. Please enter a number from the menu.");
                scanner.next();
            }

        } while (choice != 6);
    }

    private static void checkBalance() {
        System.out.println("Current Balance: Rs." + balance);
    }

    private static void deposit(Scanner scanner) {

        System.out.print("Enter amount to deposit: Rs.");

        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid amount. Please enter numbers only.");
            scanner.next();
            return;
        }

        double amount = scanner.nextDouble();

        if (amount > 0) {
            balance += amount;
            saveBalance();

            System.out.println("Amount deposited successfully.");
            addTransaction("Deposited Rs." + amount);
            checkBalance();
        } else {
            System.out.println("Deposit amount must be greater than zero.");
            addTransaction("Failed deposit attempt: Rs." + amount);
        }
    }

    private static void withdraw(Scanner scanner) {

        System.out.print("Enter amount to withdraw: Rs.");

        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid amount. Please enter numbers only.");
            scanner.next();
            return;
        }

        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than zero.");
            addTransaction("Failed withdrawal attempt: Rs." + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
            addTransaction("Failed withdrawal due to insufficient balance: Rs." + amount);
        } else {
            balance -= amount;
            saveBalance();

            System.out.println("Withdrawal successful.");
            addTransaction("Withdrawn Rs." + amount);
            checkBalance();
        }
    }

    private static void transfer(Scanner scanner) {

        System.out.print("Enter receiver account number: ");
        String receiverAccount = scanner.next();

        System.out.print("Enter amount to transfer: Rs.");

        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid amount. Please enter numbers only.");
            scanner.next();
            return;
        }

        double amount = scanner.nextDouble();

        if (receiverAccount.length() < 6) {
            System.out.println("Invalid receiver account number.");
            addTransaction("Failed transfer due to invalid account number");
        } else if (amount <= 0) {
            System.out.println("Transfer amount must be greater than zero.");
            addTransaction("Failed transfer attempt: Rs." + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance for transfer.");
            addTransaction("Failed transfer due to insufficient balance: Rs." + amount);
        } else {
            balance -= amount;
            saveBalance();

            System.out.println("Transfer successful.");
            System.out.println("Amount transferred to account: " + receiverAccount);
            addTransaction("Transferred Rs." + amount + " to account " + receiverAccount);
            checkBalance();
        }
    }

    private static void showTransactionHistory() {

        System.out.println("\n====== TRANSACTION HISTORY ======");

        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions available.");
        } else {
            for (int i = 0; i < transactionHistory.size(); i++) {
                System.out.println((i + 1) + ". " + transactionHistory.get(i));
            }
        }

        System.out.println("=================================");
    }

    private static void addTransaction(String transaction) {
        transactionHistory.add(transaction);
        saveTransaction(transaction);
    }

    private static void createDataFolder() {

        File folder = new File(DATA_FOLDER);

        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    private static void loadBalance() {

        File file = new File(BALANCE_FILE);

        try {
            if (file.exists()) {
                Scanner fileReader = new Scanner(file);

                if (fileReader.hasNextDouble()) {
                    balance = fileReader.nextDouble();
                }

                fileReader.close();
            } else {
                saveBalance();
            }

        } catch (IOException e) {
            System.out.println("Could not load balance. Default balance will be used.");
        }
    }

    private static void saveBalance() {

        try {
            createDataFolder();

            FileWriter writer = new FileWriter(BALANCE_FILE);
            writer.write(String.valueOf(balance));
            writer.close();

        } catch (IOException e) {
            System.out.println("Could not save balance.");
        }
    }

    private static void loadTransactionHistory() {

        File file = new File(HISTORY_FILE);

        try {
            if (file.exists()) {
                Scanner fileReader = new Scanner(file);

                while (fileReader.hasNextLine()) {
                    transactionHistory.add(fileReader.nextLine());
                }

                fileReader.close();
            }

        } catch (IOException e) {
            System.out.println("Could not load transaction history.");
        }
    }

    private static void saveTransaction(String transaction) {

        try {
            createDataFolder();

            FileWriter writer = new FileWriter(HISTORY_FILE, true);
            writer.write(transaction + System.lineSeparator());
            writer.close();

        } catch (IOException e) {
            System.out.println("Could not save transaction.");
        }
    }
}