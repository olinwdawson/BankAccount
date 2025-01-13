import java.util.Random;
import java.util.Scanner;

public class accountMain {
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);
    private double balance;
    private String id;
    private String owner;
    public void init() {
        System.out.print("First and Last Name: ");
        owner = scan.nextLine().toUpperCase();
        System.out.print("Initial Account Balance: ");
        balance = scan.nextDouble();
        id = idConstruct();
        System.out.print("ID: " + id);

    }
    public void getBalance(){
        System.out.println("Balance: "+balance);
    }

    public String idConstruct() {

        String idArray = "";
        for (int i = 0; i < 8; i++) {
            idArray += rand.nextInt(0, 10);
        }
        return idArray;
    }

    public void accountInfo(){
        System.out.println("OWNER: "+owner);
        System.out.println("ID: "+id);
        System.out.println("BALANCE: "+balance);
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void changeowner() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter account ID to change owner");
        Integer userinputid = input.nextInt();
        Integer idasint = Integer.parseInt(id);
        input.nextLine();
        if (userinputid.equals(idasint)) {
            System.out.println("What is the name of the new owner");
            String newowner = input.nextLine();
            owner = newowner.toUpperCase();
            System.out.println(newowner.toUpperCase() + " is the new owner of this account");
        }
    }
    public void interest(double interestRate){
        balance += (balance*interestRate*.1);
        getBalance();
    }
}
