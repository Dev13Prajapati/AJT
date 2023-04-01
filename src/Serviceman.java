import java.util.Scanner;

public class Serviceman {
    String name;
    String occupation;
    long mono;
    String area;
    String city;
    int visitCharge;

    void setDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nYour Name: ");
        this.name = sc.nextLine();
        System.out.print("Your Occupation: ");
        this.occupation = sc.nextLine();
        System.out.print("Your Area: ");
        this.area = sc.nextLine();
        System.out.print("Your City: ");
        this.city = sc.nextLine();
        System.out.print("Your Visit Charge: ");
        this.visitCharge = sc.nextInt();
        System.out.print("Your Mobile No: ");
        this.mono = sc.nextLong();
    }
}
