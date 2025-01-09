import java.util.Random;
import java.util.Scanner;
public class accountMain {
    Random rand = new Random();
    private double balance;
    private String id;
    private String owner;


    public void init(int accountBalance) {
        id = idConstruct();
        System.out.println(id);
    }

    public String idConstruct() {
        int id = 0;
        String idBuild = "";
        String idLast = "";
        int[] idArray = new int[8];
        for (int i = 0; i < 8; i++) {
            int addingnum = rand.nextInt(0, 10);
            idArray[i] = addingnum;
        }
        for(int i = 0;i<8;i++){
            idBuild = idLast+""+idArray[i];
        }
        return idBuild;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }
   /* public void changeowner( ) {


        Scanner input = new Scanner(System.in);
        System.out.println("Enter account ID to change owner");
        int userinputid = input.nextInt();
        if (userinputid.equals(id)) {
    */

    }
}
}
