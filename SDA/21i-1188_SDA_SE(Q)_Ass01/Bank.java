
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.List;

// the class is abstract for different type of accounts
abstract class Account 
{
      protected long accountNo;
      protected static double balance;
      protected boolean isDormant;
      protected static String AccHolders;
      protected ArrayList<Transaction>transactions;


      //The constructor of the abtract class
      public Account(long accountNo, double balance, String AccHolders)
      {
             this.accountNo = accountNo;
             this.balance = balance;
             this.AccHolders = AccHolders;
             this.isDormant =(balance < 100);
             this.transactions = new ArrayList<Transaction>();

      }

     //The getters and setters of the class

      public String getAccHolders()
      {
            return AccHolders;
      }

      public long getAccountNo()
      {
            return accountNo;
      }

      public double getBalance()
      {
            return balance;
      }

      public void setBalance(double balance)
      {
            this.balance = balance;
      }

      public void setDormant(boolean isDormant)
      {
            this.isDormant = isDormant;
      }

      //function for account holder to deposit money to his/her account
      public void amountDeposit(double amount)
      {
            balance += amount;
            transactions.add(new Transaction(accountNo, AccHolders, amount));

            //when holder add money the account is not dormant
            isDormant = false;

      }

      public abstract void cashWithdraw(double amount);

      public void addTransaction(Transaction transaction)
      {
            transactions.add(transaction);
      }

      public ArrayList<Transaction> getTransactions()
      {
            return transactions;
      }

      //The account get closes when the balance is less than 100
      public void closeAccount()
      {
            isDormant = true;
      }

      //When holder add amount to his/her account the account become reactive
      public void reactiveAccount()
      {
            if(balance >= 100)
            {
                  isDormant = false;
            }
      }

      //The fucntion to print the details of the account
      public String toString()
      {
            return "Account ID: " + accountNo + "\nOwner Name: " + AccHolders + "\nBalance: " + balance + "\nDormant: " + isDormant;
      } 

}

//The transaction class to store the details of the transaction
class Transaction
{
    private long accountNo;
    private String Acctype;
    private double amount;
    private LocalDateTime dateTime;

    public Transaction(long accountNo, String Acctype, double amount)
    {
        this.accountNo = accountNo;
        this.Acctype = Acctype;
        this.amount = amount;
        this.dateTime = dateTime;
    }

    public long getAccountNo() 
    {
        return accountNo;
    }

    public LocalDateTime getDateTime()
    {
        return dateTime;
    }

    public String getAccType()
    {
        return Acctype;
    }

    public double getAmount()
    {
        return amount;
    }

    @Override
    public String toString()
    {
        return String.format("%s | %s | %s | %.2f", dateTime.toString(), accountNo, amount , Acctype);
    }

public Object getBalance() {
      return null;
}
}

//the transaction ledger class to store the details of the transaction
class TransactionLedger
{
    private final List<Transaction> transactions;

    public TransactionLedger() 
    {
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) 
    {
        transactions.add(transaction);
    }

    public List<Transaction> getTransactionsByAccountId(int accountId) 
    {
        List<Transaction> result = new ArrayList<>();
        for (Transaction transaction : transactions) 
        {
            if (transaction.getAccountNo() == accountId) 
            {
                result.add(transaction);
            }
        }
        return result;
    }

    public List<Transaction> getTransactionsByAccountIdAndDate(int accountId) 
    {
        LocalDateTime date = LocalDateTime.now();
        List<Transaction> result = new ArrayList<>();
        for (Transaction transaction : transactions) 
        {
            if (transaction.getAccountNo() == accountId && transaction.getDateTime().toLocalDate().equals(date.toLocalDate())) 
            {
                result.add(transaction);
            }
        }
        return result;
    }
    
}

//The class to print  the statement of the account
 class Statement {
    private Account account;
    private ChronoLocalDateTime startDate;
    private ChronoLocalDateTime endDate;
    private List<Transaction> transactions;

    public Statement()
    {
        this.account = account;
        this.startDate = startDate;
        this.endDate = endDate;
        this.transactions = new ArrayList<>();
    }

    public Statement(Account account, ChronoLocalDateTime<?> startDate, ChronoLocalDateTime<?> endDate) {
        this.account = account;
        this.startDate = startDate;
        this.endDate = endDate;
        this.transactions = new ArrayList<>();
        
        for (Transaction t : account.getTransactions()) {
            if (t.getDateTime().compareTo(startDate) >= 0 && t.getDateTime().compareTo(endDate) <= 0) {
                transactions.add(t);
            }
        }
    }

    public String generateReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Statement for account: ").append(account.getAccountNo()).append("\n");
        sb.append("Period: ").append(startDate).append(" to ").append(endDate).append("\n\n");
        sb.append(String.format("%-25s %-15s %-15s %-15s\n", "Date", "Type", "Amount", "Balance"));
        sb.append("------------------------------------------------------------\n");
        for (Transaction t : transactions) {
            sb.append(String.format("%-25s %-15s %-15s %-15s\n", t.getDateTime(), t.getAccType(), t.getAmount(), t.getBalance()));
        }
        return sb.toString();
    }

    public void printReport() 
    {
        System.out.println(generateReport());
    }


}

class CurrentAccount extends Account {
      private ArrayList<String> NumPersons;
  
      public CurrentAccount(long accountNo, double balance, String AccHolders)
      {
          super(accountNo, balance, AccHolders);
          NumPersons = new ArrayList<String>();
          NumPersons.add(AccHolders);
      }
  
      public ArrayList<String> getNumPersons()
      {
          return NumPersons;
      }
  
      public void setNumPersons(String numPersons)
      {
         NumPersons.add(numPersons);
      }
  
      @Override
      public void cashWithdraw(double amount)
      {
          if (getBalance() - amount >= 0)
          {
              setBalance(getBalance() - amount);
              addTransaction(new Transaction(getAccountNo(), "Current", amount));
              setDormant(false);
          }
          else
          {
              setDormant(true);
          }
      }
  
      @Override
      public String toString()
      {
          String ownersString = "";
          for (String owner : NumPersons)
          {
              ownersString += NumPersons + ", ";
          }
          ownersString = ownersString.substring(0, ownersString.length() - 2);
          return super.toString() + "\nOwners: " + ownersString;
      }


  
}

class SavingAccount extends Account 
{

      public SavingAccount(long accountNo, String AccHolders,double balance)
      {
          super(accountNo,balance,AccHolders);
      }
  
      @Override
      public void cashWithdraw(double amount)
      {
          double penalty = 0.0001 * amount;
          if(getBalance()- (amount+penalty)>=0)
          {
              setBalance(getBalance() - (amount+penalty));
              addTransaction(new Transaction(getAccountNo(),"",amount+penalty));
              setDormant(false);
          }
          else
          {
              setDormant(true);
          }
          
      }
     
}

class Customer{
      String firstname;
      String lastname;
      String id;
      String address;
      String email;

      public Customer(String firstname, String lastname,   String id,   String address,  String email)
      {
            this.firstname = firstname;
            this.lastname = lastname;
            this.id = id;
            this.address = address;
            this.email = email;
      }
}

class Bank extends Account
{
      private ArrayList<Customer>customer;
      static long accountNo;
      int cash;
      LocalDateTime Date;

      public Bank()
      {
            super(accountNo,balance,AccHolders);
      }

      public Bank(long accountNo, double balance, String AccHolders)
      {
          super(accountNo,balance,AccHolders);
      }
     

      public void addCustomer(Customer customer)
      {
          this.customer.add(customer);
      }
      
      public void addAccount(Account account)
      {
            ArrayList <Account>accounts;

      }
      public void cashWithdraw(double amount)
      {
          double penalty = 0.0001 * amount;
          if(getBalance()- (amount+penalty)>=0)
          {
              setBalance(getBalance() - (amount+penalty));
              addTransaction(new Transaction(getAccountNo(),"WithDraw",amount+penalty));
              setDormant(false);
          }
          else
          {
              setDormant(true);
          }
          
      }
      public void cashDeposit(double amount)
       {
            if(getBalance() + amount >= 0)
            {
                setBalance(getBalance() + amount);
                addTransaction(new Transaction(getAccountNo(),"Deposit",amount));
                setDormant(false);
            }
            else
            {
                setDormant(true);
            }
        }
        public void transfer(Account account, double amount)
        {
            if(getBalance() - amount >= 0)
            {
                setBalance(getBalance() - amount);
                account.setBalance(account.getBalance() + amount);
                addTransaction(new Transaction(getAccountNo(),"Transfer",amount));
                setDormant(false);
            }
            else
            {
                setDormant(true);
            }
        }

        public void setUser(Customer customer)
        {
            this.customer.add(customer);
        }

        public void getUsers()
        {
            for (Customer c : customer)
            {
                System.out.println(c);
            }
        }

        public void displayAccount()
        {
            System.out.println("Account Number: " + getAccountNo());
            System.out.println("Balance: " + getBalance());
            System.out.println("Account Holder: " + getAccHolders());
            System.out.println("Dormant: " + isDormant());
            System.out.println("Transactions: ");
            for (Transaction t : getTransactions())
            {
                System.out.println(t);
            }
        }

        private String isDormant() 
        {
            return null;
        }

        public void reactiveAccount(long accountNo, double balance)
        {
              if(balance >= 100)
              {
                    isDormant = false;
              }
        }

        public void closeAccount(long accountNo)
        {
              if(balance < 100)
              {
                    isDormant = true;
              }
        }


       

}