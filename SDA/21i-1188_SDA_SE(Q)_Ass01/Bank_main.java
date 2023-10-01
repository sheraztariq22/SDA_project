import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainBank {
  public static void main(String[] args) {
    System.out.println("------------------------------------");
    System.out.println("|Welcome to the Bank of Java!      |");
    System.out.println("------------------------------------");
    System.out.println(" ");
    System.out.println(" ");

    System.out.println("Press 1 to Account Management.");
    System.out.println("Press 2 to User Management.");
    System.out.println("Press 3 to Transactions Details.");
    System.out.println("Press 4 to Print Statement.");
    System.out.println("Press 5 to Determine Account Types.");
    System.out.println("Press 6 to Reactivate Account.");
    System.out.println("Press 7 to Exit.");
    System.out.println("\n");

    Scanner input = new Scanner(System.in);
    System.out.println("Enter your choice: ");
    int choice = input.nextInt();

    

    switch(choice)
    {
        case 1:
        Bank bank = new Bank(1234567890, 40000, "Sheraz");
        Bank bank1 = new Bank(123456, 500.99, "Heena");
        Bank bank2 = new Bank(1234567892, 600.77, "Ifitikhaar");
        bank.addAccount(bank);
        bank.addAccount(bank1);
        bank.addAccount(bank2);

        bank.displayAccount();
        break;

        case 2:
        //you cannot add more than 3 users
        System.out.println("Enter the number of users: ");
        int Users = input.nextInt();
      
        if( Users < 3)
        {
            System.out.println("Enter your name: ");
            String name = input.next();
            System.out.println("Enter your account number: ");
            int accountNumber = input.nextInt();
            System.out.println("Enter your balance: ");
            double balance = input.nextDouble();
            Bank bank3 = new Bank(accountNumber, balance, name);
            bank3.addAccount(bank3);
            bank3.displayAccount();
        }
        else
        {
            System.out.println("You cannot add more than 3 users.");
        }
        break;

        case 3:
        Transaction transaction = new Transaction(1234567890, "Saving", 5000.5);
        Transaction transaction1 = new Transaction(1234567890, "Current", 1000.5);
        Transaction transaction2 = new Transaction(1234567890, "Current", 60000.5);

        transaction.toString();
        transaction1.toString();
        transaction2.toString();

        TransactionLedger transactionLedger = new TransactionLedger();
        transactionLedger.addTransaction(transaction);
        transactionLedger.addTransaction(transaction1);
        transactionLedger.addTransaction(transaction2);

        //getting transaction details through arraylist
        System.out.println("Transaction Details through Account Number: ");
        List<Transaction> transactions = transactionLedger.getTransactionsByAccountId(1234567890);
        for(Transaction t : transactions)
        {
            System.out.println(t);
        }

        //getting transactions details through Account id and date
        System.out.println("Transaction Details through Account Number and Date: ");
        List<Transaction> transactions1 = transactionLedger.getTransactionsByAccountIdAndDate(1234567890);
        for(Transaction t : transactions1)
        {
            System.out.println(t);
        }
        break;

        case 4:
        //printing statement
        Statement statement = new Statement();

        statement.generateReport();
        statement.printReport();
        break;

        case 5:
        //determining account types
        int option;
        System.out.println("Press 1 for Current Account.");
        System.out.println("Press 2 for Saving Account.");
        System.out.println("\n");


        System.out.println("Enter your choice: ");
        option = input.nextInt();

        if(option == 1)
        {
          CurrentAccount currentAccount = new CurrentAccount(1234567890, 40000, "Sheraz");
        
          currentAccount.cashWithdraw(1000);
          currentAccount.toString();
        }
        else if(option == 2)
        {
          SavingAccount savingAccount = new SavingAccount(1234567890, "Heena", 50000);
          savingAccount.cashWithdraw(1000);
          savingAccount.toString();
        }
        else
        {
          System.out.println("Invalid choice.");
        }
        break;

        case 6:
        //reactivating account
        System.out.println("Enter your account number: ");
        long accountNumber = input.nextInt();
        System.out.println("Enter your balance: ");
        double balance = input.nextDouble();

        if(balance < 100)
        {
          System.out.println("Your account is inactive\n\n.");
          Bank bank4 = new Bank();
          bank4.reactiveAccount(accountNumber, balance);
          System.out.println("Add dome amount to make it active.");
          double amount = input.nextDouble();
          bank4.cashWithdraw(amount);
          bank4.toString();

        }
        else
        {
          System.out.println("Your account is active.");
        }

        break;

        case 7:
        System.out.println("Thank you for using the Bank of Java!");
        break;


        default:
        System.out.println("Invalid choice.");
        break;
    }
  }

}
