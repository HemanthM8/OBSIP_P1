import java.util.*;
class OnlineExam
{
    static Scanner sc=new Scanner(System.in);
    static Map<String,String> map = new HashMap<>();
    public static void main(String[] args) 
    {
        login();    
    }

    public static void DisplayFeatures()
    {
        System.out.println("1.Update profile");
        System.out.println("2.Start Exam");
        System.out.println("3.Logout");
        System.out.print("Enter your choice ");
        int choice=sc.nextInt();
        switch (choice) {
            case 1:
                UpdateProfile();
                DisplayFeatures();
                System.out.println();
                break;
            case 2:
                Exam();
                DisplayFeatures();
                System.out.println();
                break;
            case 3:
                EndMessage();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    public static void login()
    {
        map.put("User1","12345");
        map.put("User2","48587");
        map.put("User3","98765");
        String username,pw;
        System.out.print("Enter username ");
        username=sc.next();
        System.out.print("Enter password ");
        pw=sc.next();
        if(map.containsKey(username) && map.get(username).equals(pw))
        {
            System.out.println("Login Successful");
            System.out.println();
            DisplayFeatures();
        }
        else
        {
            System.out.println("Invalid Credentials");
            login();
        }
    }

    public static void UpdateProfile()
    {
        String pw,name,temp;
        System.out.print("Enter the username ");
        name=sc.next();
        System.out.print("Enter the new password you want to change ");
        pw=sc.next();
        if(map.containsKey(name))
        {
            map.put(name,pw);
            System.out.println("Password changed successfully");
            System.out.println();
        }
        else
        {
            System.out.println("Not Found");
        }
    }

    public static void Exam()
    {
        int score=0,choice;
        System.out.println();
        System.out.println("1. Who invented Java Programming?");
        System.out.println("1.Guido van Rossum\n2.James Gosling\n3.Dennis Ritchie\n4.Bjarne Stroustrup");
        System.out.print("Answer ");
        choice=sc.nextInt();
        if(choice==2)
        {
            score++;
        }
        System.out.println();
        System.out.println("2. Which statement is true about Java?");
        System.out.println("1.Java is a sequence-dependent programming language\n2.Java is a code dependent programming language\n3.Java is a platform-dependent programming language\n4. Java is a platform-independent programming language");
        System.out.print("Answer ");
        choice=sc.nextInt();
        if(choice==4)
        {
            score++;
        }
        System.out.println();
        System.out.println("3.  Which component is used to compile, debug and execute the java programs?");
        System.out.println("1.JRE\n2.JIT\n3.JDK\n4.JVM");
        System.out.print("Answer ");
        choice=sc.nextInt();
        if(choice==3)
        {
            score++;
        }
        System.out.println();
        System.out.println("4. Which one of the following is not a Java feature?");
        System.out.println("1.Object-oriented\n2.Use of Pointers\n3.Portable\n4.Dynamic");
        System.out.print("Answer ");
        choice=sc.nextInt();
        if(choice==2)
        {
            score++;
        }
        System.out.println();
        System.out.println("5. Which of these cannot be used for a variable name in Java?");
        System.out.println("1.Idenrifier & Keyword\n2.Identifier\n3.Keyword\n4.None of the above");
        System.out.print("Answer ");
        choice=sc.nextInt();
        if(choice==3)
        {
            score++;
        }
        System.out.println("Your score is "+score);
        System.out.println();
    }

    public static void EndMessage()
    {
        System.out.println("Thanks for Visiting");
        System.out.println("----------------------------");
        System.out.println();
    }
}