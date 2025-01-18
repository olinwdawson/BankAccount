import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Random;
import java.util.Scanner;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.lang.Object;
public class accountMain {
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);
    Calendar c = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("MMM");
    private double balance;
    private String id;
    private String owner;
    private double fee;
    private static String lastMonth;
    private String currentMonth;
    private int transactionCount;
    public void init() {
        System.out.print("First and Last Name: ");
        owner = scan.nextLine().toUpperCase();
        System.out.print("Initial Account Balance: ");
        balance = scan.nextDouble();
        id = idConstruct();
        System.out.print("ID: " + id);
        currentMonth = sdf.format(c.getTime());
        if(!(currentMonth==lastMonth)){
            transactionCount=0;
            lastMonth=currentMonth;
        }
        payUp();
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
        if(transactionCount<=10){
            balance+=amount;
            transactionCount++;
        } else {
            balance += amount;

            transactionCount++;
        }
    }
    public void withdraw(double amount) {
        if(transactionCount<=10){
            balance-=amount;
            transactionCount++;
        } else {
            balance -= amount;

            transactionCount++;
        }
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
    public void fee(){
        balance-=fee;
    }
    public int transactionCount(){
        return transactionCount;
    }
    public void clearStatics(){
        transactionCount = 0;
    }
    public LocalDate paymentDay(){
        ZoneId zoneID = ZoneId.of( "America/Los_Angeles");
        LocalDate today = LocalDate.now( zoneID);
        YearMonth currentYearMonth = YearMonth.from( today );  // 2016-06
        LocalDate paymentDay = currentYearMonth.atEndOfMonth();  // 2016-06-30
        return paymentDay;
    }
    public LocalDate currentDay(){
        ZoneId zoneID = ZoneId.of( "America/Los_Angeles");
        LocalDate today = LocalDate.now( zoneID);
        LocalDate currentYearMonth = LocalDate.from( today );
        return currentYearMonth;
    }
    public void payUp(){
        double amountOver = transactionCount - 10;
        if(paymentDay().compareTo(currentDay())==0){
            double feeCost = amountOver*fee;
            balance-=feeCost;
        }
    }
}
