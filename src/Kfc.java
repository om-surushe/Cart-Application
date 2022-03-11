
// import java.util.ArrayList;
// import java.util.List;
import java.util.Scanner;

public class Kfc {

    private List<Customer> customers = new List<Customer>(null);
    private List<item> menu = new List<item>(null);
    
    public List<Customer> getCustomers() {
        return customers;
    }

    public void Admin() {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("Make your menu card at KFC");
            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. View menu");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            System.out.println("--------------------------------------------------------------------------------");
            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.println("Enter item name");
                    String itemName = sc.nextLine();
                    System.out.println("Enter item price");
                    int itemPrice = sc.nextInt();
                    item newItem = new item(itemName, itemPrice, 1);
                    menu.add(newItem);
                    System.out.println("Item added");
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Enter item name");
                    String itemName1 = sc.nextLine();
                    for (int i = 0; i < menu.size(); i++) {
                        if(itemName1.equals(menu.getArray(i).getItemName()))
                        {
                            menu.remove(menu.getArray(i));
                            System.out.println("Successfully removed");
                            break;
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < menu.size(); i++) {
                        System.out.println(String.format("%20s %20d", ((item) menu.getArray(i)).getItemName(), ((item) menu.getArray(i)).getItemPrice()));
                    }   
                    break;

                case 4:
                    System.out.println("Thank you for using KFC Admin");
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 4);
        sc.close();
        return;
    }

    public void placeOrder(Customer customer) {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("Welcome to KFC");
            System.out.println("0. View menu");
            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. view your cart with total price");
            System.out.println("4. Pay");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            System.out.println("--------------------------------------------------------------------------------");
            switch (choice) {
                case 0:
                    for (int i = 0; i < menu.size(); i++) {
                        System.out.println(String.format("%20s %20d",  menu.getArray(i).getItemName(), menu.getArray(i).getItemPrice()));
                    }
                    break;

                case 1:
                    sc.nextLine();
                    System.out.println("Enter item name");
                    String itemName = sc.nextLine();
                    boolean flag = false;
                    for (int i = 0; i < menu.size(); i++) {
                        if( menu.getArray(i).getItemName().equals(itemName)){
                            customer.getBasket().addItem(menu.getArray(i));
                            flag = true;
                            customer.setPayment(customer.getPayment()+(menu.getArray(i)).getItemPrice());
                            System.out.println("Item added");
                            System.out.println("Total price: "+customer.getPayment());
                            break;
                        }
                    }
                    if (!flag) {
                        System.out.println("Item not found");
                    }
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Enter item name");
                    String itemName1 = sc.nextLine();
                    boolean flag1 = false;
                    for (int i = 0; i < customer.getBasket().getOrder().size(); i++) {
                        if(itemName1.equals(customer.getBasket().getOrder().getArray(i).getItemName()))
                        {
                            customer.getBasket().removeItem(customer.getBasket().getOrder().getArray(i));
                            flag1 = true;
                            customer.setPayment(customer.getPayment()- customer.getBasket().getOrder().getArray(i).getItemPrice());
                            System.out.println("Item removed");
                            System.out.println("Total price: "+customer.getPayment());
                            break;
                        }
                    }
                    if (!flag1) {
                        System.out.println("Item not found");
                    }
                    break;
                case 3:
                    for (int i = 0; i < customer.getBasket().getOrder().size(); i++) {
                        System.out.println(String.format("%20s %20d",  customer.getBasket().getOrder().getArray(i).getItemName(), customer.getBasket().getOrder().getArray(i).getItemPrice()));
                    }
                    System.out.println("Total price: "+customer.getPayment());
                    break;

                case 4:
                    System.out.println("Your Ordered placed successfully");
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 4);
        sc.close();
        return;
    }

    public void CustomerSide(Customer customer) throws InterruptedException {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("Welcome to KFC");
            System.out.println("1. View menu");
            System.out.println("2. Place your order");
            System.out.println("3. Confirm Order");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            System.out.println("--------------------------------------------------------------------------------");
            switch (choice) {
                case 1:
                    for (int i = 0; i < menu.size(); i++) {
                        System.out.println(String.format("%20s %20d", menu.getArray(i).getItemName(), menu.getArray(i).getItemPrice()));
                    }
                    break;
                case 2:
                    this.placeOrder(customer);
                    break;
                case 3:
                    customer.getBasket().setPaid(true);
                    System.out.println("Taking paisa from your khata");
                    Thread.sleep(7000);
                    System.out.println("Aagya bhai paisa");
                    System.out.println("Thanks For Payment");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 3);
        sc.close();
        return;
    }












































    // public static void main(String[] args) throws Exception {
    //     Kfc kfc = new Kfc();

    //     int ch1 = 0;

    //     do {
    //         System.out.println("--------------------------------------------------------------------------------");
    //         System.out.println("Choose Your Interface");
    //         System.out.println("1. Admin");
    //         System.out.println("2. Customer");
    //         System.out.println("3. Exit");
    //         System.out.print("Enter your choice: ");
    //         int ch2 = sc.nextInt();
    //         System.out.println("--------------------------------------------------------------------------------");
    //         switch (ch2) {
    //             case 1:
    //                 kfc.Admin();
    //                 break;
    //             case 2:
    //                 sc.nextLine();
    //                 System.out.println("Enter your name");
    //                 String name = sc.nextLine();
    //                 System.out.println("Enter your contact number");
    //                 String contactNo = sc.nextLine();
    //                 Customer newCustomer = new Customer(new Basket(Integer.toString(id)), name, contactNo);
    //                 kfc.customers.add(newCustomer);
    //                 id++;
    //                 kfc.CustomerSide(newCustomer);
    //                 break;
    //             case 3:
    //                 System.exit(0);
    //             default:
    //                 System.out.println("Invalid choice");
    //                 break;
    //         }
    //         {

    //         }
    //     } while (ch1 != 3);

    // }

}
