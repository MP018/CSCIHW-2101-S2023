package Project1;

import java.util.Scanner;
/*
 * Appas Bank
 * Bank Account Parameters:
 * public Name -> String ✓
 * private Balance -> double ✓ 
 * private Date of Birth -> String ✓
 * private SSN -> int (Maybe String) ✓
 * private Account Number -> int ✓
 * 
 * Bank Account Methods:
 * Constructor 
 * Getters and Setters
 * Deposit
 * Withdraw
 * Transfer (HomeWork)
 * Balance
 * Menu
 * Compound Interest
 * Simple Interest (HomeWork)
 * Authentication Basic
 * Authentication Advanced (HomeWork?)
 * 
 * Bank Account Constructor
 * Name, Balance, SSN, Account Number, Date of Birth
 * Name, SSN
 */

public class BankAccount {

    // Bank Account Parameters
    public String name;
    private double balance;
    private String dob;
    private int ssn;
    private int accountNumber;
    public double interestRate = 0.01;
    public double simpleInterestRate = 0.001;
    public int period = 4; // quarterly

    // Bank Account Constructor
    public BankAccount(String name, int ssn, double balance, int accountNumber, String dob) {
        this.name = name;
        this.ssn = ssn;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.dob = dob;
    }

    // Bank Account Constructor
    public BankAccount(String name, int ssn) {
        this.name = name;
        this.ssn = ssn;
    }

    // Bank Account Methods

    // Note you do need to create a getter for public variables however it is best
    // practice to create a getter for all variables

    /*
     * Getters and Setters
     */

    public String getName() {
        return this.name;
    }

    public double getbalance() {
        return this.balance;
    }

    public String getdob() {
        return this.dob;
    }

    public int getssn() {
        return this.ssn;
    }

    public int getaccountNumber() {
        return this.accountNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
     * Should only be used by during the creation of the account never after instead
     * see deposit and withdraw
     */
    public void setbalance(double balance) {
        this.balance = balance;
    }

    public void setdob(String dob) {
        this.dob = dob;
    }

    public void setssn(int ssn) {
        this.ssn = ssn;
    }

    public void setaccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void deposit(double amount) {
        this.balance += amount;
        savings();
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    //Overdraft method
    public void overDraft(BankAccount acount, double amount) {
        if (this.balance <= 0) {
            System.out.println("You will be charged a $35 overdraft fee. Are you sure you want to continue? (Yes/No)");
            Scanner input = new Scanner(System.in);
            String choice = input.nextLine();
            if (choice.equalsIgnoreCase("Yes")) {
                this.balance -= amount;
                this.balance -= 35;
            } else {
                System.out.println("Transaction cancelled");
            }
        }
    }

    // Transfer money method
    public static void transferMoney(BankAccount acount1, BankAccount acount2, double amount) {
        acount1.withdraw(amount);
        acount2.deposit(amount);
    }


    //create savings account if user has more than or equal to $10,000    
    public void savings (){
        if (balance >= 10000){
            System.out.println("You are eligible for a savings account. Would you like to create one? (Yes/No)");
            Scanner input = new Scanner(System.in);
            String choice = input.nextLine();
            if (choice.equalsIgnoreCase("Yes")) {
                
                System.out.println("Please enter the amount you would like to save/principal: ");
                double principal = input.nextDouble();
                System.out.println("Please enter the number of years you would like to save for: ");
                int years = input.nextInt();
                System.out.println("Please enter the type of interest you would like to use (compound (APY0.001)/simple (0.001). Please type either c or s): ");
                String interest = input.nextLine();
                
                if (interest.equalsIgnoreCase("c")){
                    compoundInterest(principal, years, 0.0001, 4);
                } else if (interest.equalsIgnoreCase("s")){
                    simpleInterest(principal, 0.001, years);
                } else {
                    System.out.println("Invalid choice");
                }

            } else {
                System.out.println("No savings account created");
            }
        }
    }

    // Create a mthod that will subtract a mothly fee from the balance
    // this method will take a double as a parameter
    // this method will subtract the fee from the balance
    // Netflix subscription is $12.99
    public void monthlyFee(double fee) {
        withdraw(fee);
    }

    // Create a method that will print a menu to the user
    // This is called a helper method / function
    public static int menu() {
        int choice;
        Scanner input = new java.util.Scanner(System.in);
        System.out.println("Welcome to Appas Bank");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Transfer"); // HomeWork
        System.out.println("4. Balance");
        System.out.println("5. Compound Interest");
        System.out.println("6. Simple Interest"); // HomeWork
        System.out.println("0. Exit");
        System.out.println("Please enter your choice: ");
        choice = input.nextInt();
        return choice;
    }

    public void printBalance() {
        System.out.println("Your balance is: $" + this.balance);
    }

    // Create a method that will interact with the user based on their choice from
    // the menu method
    // This method will take a Bank Account as a parameter
    public static void interact(BankAccount account, BankAccount account2) {
        // get the choice from the menu method
        int choice = menu();
        // create a scanner object
        Scanner input = new java.util.Scanner(System.in);
        // use that choice and run the method associated with that choice

        if (choice == 1) {
            System.out.println("Please enter the amount you would like to deposit. If you have more than $10,000 you are eligible for a savings account: ");
            double amount = input.nextDouble();
            account.deposit(amount);
            account.printBalance();
        } 
        else if (choice == 2) {
            System.out.println("How much would you like to withdraw?");
            double amount = input.nextDouble();
            account.withdraw(amount);
            account.overDraft(account, amount);
            account.printBalance();
        } // place holder for choice 3
        
        else if (choice == 3){
            System.out.println("How much would you like to transfer?");
            double amount = input.nextDouble();
            System.out.println("Please enter the name of the person you would like to transfer money to: ");
            String name = input.nextLine();
            transferMoney(account, account2, amount);
        }
    
        else if (choice == 4) {
            account.printBalance();

        } 
        else if (choice == 5) {
            System.out.println("How many years? (Whole numbers only)");
            int years = input.nextInt();
            account.compoundInterest(account.getbalance(), years, account.interestRate, account.period);
            account.printBalance();
        } 
        // place holder for choice 6
        else if (choice == 6) {
            System.out.println("How many years? (Whole numbers only)");
            int years = input.nextInt();
            account.simpleInterest(account.getbalance(), account.simpleInterestRate, years);
            account.printBalance();
        }

        else if (choice == 0) {
            System.out.println("Thank you for banking with Appas Bank");
        } else { // this would catch any invalid choices like
            System.out.println("Invalid choice");
        }

    }

    //simple interest
    public void simpleInterest(double principal, double rate, int time){
        double amount = principal * (1 + (rate * time));
        double roundedAmount = Math.round(amount * 100.0) / 100.0;
        double simpleinterest = amount - principal; // A-P
        simpleinterest = Math.round(simpleinterest * 100.0) / 100;

        System.out.println("Current Rate is: " + rate + "%");
        System.out.println("Selected Time is: " + time + " years");
        System.out.println("Simple Interest after " + time + " years is: $" + simpleinterest);
        System.out.println("Total Amount after " + time + " years is: $" + roundedAmount);
    
    }

    // Create a method that will calculate the interest on the balance using
    // compound interest
    // P(1 + R/n)^(nt) - P
    // A = P(1 + R/n)^(nt)
    // P = Principal
    // R = Rate
    // n = number of times interest is compounded per year (annum)
    // t = number of years
    // This method will take a double as an argument
    // This method will return a double

    // P can be this.balance or getBalance() if you would like to use a getter

    public void compoundInterest(double principal, int time, double rate, int annum) {
        double amount = principal * Math.pow(1 + (rate / annum), annum * time);
        double roundedAmount = Math.round(amount * 100.0) / 100.0;
        double compinterest = amount - principal; // A-P
        compinterest = Math.round(compinterest * 100.0) / 100;

        System.out.println("Current Rate is: " + rate + "%");
        System.out.println("Current Period is: " + annum + " times per year");
        System.out.println("Selected Time is: " + time + " years");
        System.out.println("Compound Interest after " + time + " years is: $" + compinterest);
        System.out.println("Total Amount after " + time + " years is: $" + roundedAmount);
    }

}
