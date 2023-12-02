import java.util.Random;
import java.util.Scanner;

class NumberGuess {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random obj = new Random();
        int guess = obj.nextInt(1,101);
        int score = 100, attempts = 1,choice = 1,num = 0;
        WelcomeMessage();
        while (choice != 0) {
            
            if (choice == 1) {
                num = UserGuess();
                System.out.println();
            }

            if (num == guess) {
                System.out.println("Score is "+ (score - 1));
                System.out.println("No of attempts "+ (attempts));
                System.out.println();
                score = 100;
                attempts = 0;
                System.out.print("Do you want to continue? Type (1/0) ");
                choice = sc.nextInt();
                System.out.println();

                if (choice == 1) {
                    WelcomeMessage();
                    guess = obj.nextInt(1,101);
                }
            }

            else if (num < guess) {
                System.out.println(num+" is less than required number.Try again.....");
                System.out.println();
                attempts++;
                score--;
            }

            else {
                System.out.println(num+" is greater than required number.Try again.....");
                System.out.println();
                attempts++;
                score--;
            }
        }
        if (choice == 0) {
            EndGameMessage();
        }
        sc.close();
    }

    public static void WelcomeMessage() {
        System.out.println("==========Welcome to number guessing game==========");
        System.out.println("---------------------------------------------------");
        System.out.println();
    }

    public static void EndGameMessage() {
        System.out.println("Thanks for playing");
        System.out.println("-------------------------------------------------------------");
        System.out.println();
    }

    public static int UserGuess() {
        boolean in = true;
        Scanner sc = new Scanner(System.in);
        int num = 0;
        while (in) {
            try {
                System.out.print("Enter the number between 1 to 100 ");
                num = sc.nextInt();
                if(num < 1 || num > 100)
                    throw new Exception();
                in = false;
            } catch (Exception e) {
                System.out.println("Invalid Integer");
                System.out.println();
                sc.nextLine();
                in = true;
            }
        }
        return num;
    }
}