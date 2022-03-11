import java.util.Scanner;

public class hotel {

    public static void main(String[] args) throws Exception {
        Kfc kfc = new Kfc();
        int id = 1;
        Scanner sc = new Scanner(System.in);

        int ch1 = 0;

        do {
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("Choose Your Interface");
            System.out.println("1. Admin");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int ch2 = sc.nextInt();
            System.out.println("--------------------------------------------------------------------------------");
            switch (ch2) {
                case 1:
                    kfc.Admin();
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Enter your name");
                    String name = sc.nextLine();
                    System.out.println("Enter your contact number");
                    String contactNo = sc.nextLine();
                    Customer newCustomer = new Customer(new Basket(Integer.toString(id)), name, contactNo);
                    kfc.getCustomers().add(newCustomer);
                    id++;
                    kfc.CustomerSide(newCustomer);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
                    break;
            }

        } while (ch1 != 3);
        sc.close();
        return;
    }

}
