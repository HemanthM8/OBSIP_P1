import java.util.Scanner;
import java.util.ArrayList;
public class ATMInterface {

    static Scanner sc=new Scanner(System.in);
    static float balance=10000;
    static ArrayList<String> Ttype=new ArrayList<>();
    static ArrayList<Float> amount=new ArrayList<>();

    public static void main(String[] args) {
        while(true) {
            DisplayMenu();
            int choice=sc.nextInt();
            switch (choice) {
                case 1:
                    DisplayBalance();
                    break;
                case 2:
                    Withdraw();
                    break;
                case 3:
                    Deposit();
                    break;
                case 4:
                    Transfer();
                    break;
                case 5:
                    TransactionHis();
                    break;
                case 6:
                    EndMessage();
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }

    public static void DisplayMenu() {
        System.out.println("**********Welcome to ATM**********");
        System.out.println("-------------------------------------");
        System.out.println("1.Display Balance");
        System.out.println("2.Withdraw");
        System.out.println("3.Deposit");
        System.out.println("4.Transfer");
        System.out.println("5.Transaction History");
        System.out.println("6.Exit");
        System.out.print("Enter your choice ");
    }

    public static void DisplayBalance() {
        System.out.printf("Your current balance is %.2f \n",balance);
        System.out.println();
    }

    public static void Withdraw() {
        System.out.print("Enter Amount to withdraw ");
        float amt=Input();
        if(amt==0.0f) {
            return;
        }
        if(amt>balance || balance==0) {
            System.out.println("Insufficient Funds");
        }
        else {
            balance-=amt;
            System.out.printf("%.2f amount has been withdrawn from your account\n",amt);
            Ttype.add("Withdraw");
            amount.add(amt);
            DisplayBalance();
        }
    }

    public static void Deposit() {
        System.out.print("Enter Amount to Deposit ");
        float amt=Input();
        if(amt==0.0f) {
            return;
        }
        balance+=amt;
        System.out.printf("%.2f amount has been deposited from your account\n",amt);
        Ttype.add("Deposit");
        amount.add(amt);
        DisplayBalance();
    }

    public static void Transfer() {
        System.out.print("Enter Amount to Transfer ");
        float amt=Input();
        if(amt==0.0f) {
            return;
        }
        System.out.print("Enter recipient account number ");
        int acc=sc.nextInt();
        if(amt>balance || balance==0) {
            System.out.println("Insufficient Funds");
            System.out.println();
        }
        else {
            balance-=amt;
            System.out.printf("%.2f amount has been transferred from your account to recipient with account number %d \n",amt,acc);
            Ttype.add("Transfer");
            amount.add(amt);
            DisplayBalance();
        }
    }

    public static void TransactionHis() {
        System.out.println();
        System.out.println("Transaction History");
        System.out.println("-----------------------------");
        for(int i=0;i<Ttype.size();i++) {
            System.out.printf("%s   %.2f\n",Ttype.get(i),amount.get(i));
        }
        System.out.println();
    }

    public static float Input() {
        float amt=0.0f;
        try {
                amt = sc.nextFloat();
        } catch (Exception e) {
                System.out.println("Cannot process Transaction.Please enter valid amount");
                System.out.println();
                sc.nextLine();
            }
        return amt;
    }

    public static void EndMessage() {
        System.out.println("Thank You For Visiting Our ATM");
        System.out.println("----------------------------------");
        System.out.println();
    }
}

