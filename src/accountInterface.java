import java.util.Scanner;

public class accountInterface {
    public static void main(String[] args) {
        accountMain main = new accountMain();
        main.init();
        Scanner scan = new Scanner(System.in);

        while(true){
            System.out.println("\nSelect action: \n1 - View Account Information\n2 - Deposit\n3 - Withdraw\n4 - Change Owner\n5 - Interest Rate");
            int choice = scan.nextInt();
            switch(choice){
                case 1:
                    main.accountInfo();
                    break;
                case 2:
                    System.out.println("How much to deposit?");
                    main.deposit(scan.nextInt());
                    scan.nextLine();
                    main.getBalance();
                    break;
                case 3:
                    System.out.println("How much to withdraw?");
                    main.withdraw(scan.nextInt());
                    scan.nextLine();
                    main.getBalance();
                    break;
                case 4:
                    main.changeowner();
                    break;
                case 5:
                    System.out.print("Interest Rate: ");
                    double interest = scan.nextDouble();
                    main.interest(interest);
                    break;
            }
        }
    }
}
