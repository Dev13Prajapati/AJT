import java.util.Scanner;

public class User {
    String name;
    String email;
    long mono;
    String hno;
    String soc;
    String city;

    void setDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nYour Name: ");
        this.name = sc.nextLine();
        System.out.print("Your Email: ");
        this.email = sc.nextLine();
        System.out.print("Your House No: ");
        this.hno = sc.nextLine();
        System.out.print("Your Society/Residency: ");
        this.soc = sc.nextLine();
        System.out.print("Your City: ");
        this.city = sc.nextLine();
        System.out.print("Your Mobile No: ");
        this.mono = sc.nextLong();
    }
}
