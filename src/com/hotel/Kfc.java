package com.hotel;
// import java.util.ArrayList;
// import java.util.List;
import java.util.Scanner;

import com.components.Basket;
import com.components.Customer;
import com.components.List;
import com.components.item;

class Kfc {

    private List<Customer> customers;// = new ArrayList<Customer>();
    private List<item> menu; // = new ArrayList<item>();
    static Scanner sc = new Scanner(System.in);
    public static int id = 1;

    public void Admin() {
        int choice = 0;
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
                    boolean flag = false;
                    // for (item i : menu) {
                    //     if (i.getItemName().equals(itemName1)) {
                    //         menu.remove(i);
                    //         System.out.println("Item removed");
                    //         flag = true;
                    //         break;
                    //     }
                    // }
                    for (int i = 0; i < menu.size(); i++) {
                        if (((item) menu.get(i)).getItemName().equals(itemName1)) {
                            menu.remove(i);
                            System.out.println("Item removed");
                            flag = true;
                            break;
                        }
                            
                        }
                    if (!flag) {
                        System.out.println("Item not found");
                    }
                    break;
                case 3:
                    for (int i = 0; i < menu.size(); i++) {
                        System.out.println(String.format("%20s %20d", ((item) menu.get(i)).getItemName(), ((item) menu.get(i)).getItemPrice()));
                            
                        }
                    // for (item i : menu) {
                    // }
                    break;

                case 4:
                    System.out.println("Thank you for using KFC Admin");
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 4);

        return;
    }

    public void placeOrder(Customer customer) {
        int choice = 0;
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
                        System.out.println(String.format("%20s %20d", ((item) menu.get(i)).getItemName(), ((item) menu.get(i)).getItemPrice()));
                    }
                    break;

                case 1:
                    sc.nextLine();
                    System.out.println("Enter item name");
                    String itemName = sc.nextLine();
                    boolean flag = false;
                    for (int i = 0; i < menu.size(); i++) {
                        if(((item) menu.get(i)).getItemName().equals(itemName)){
                            customer.getBasket().addItem((item) menu.get(i));
                            flag = true;
                            customer.setPayment(customer.getPayment()+((item) menu.get(i)).getItemPrice());
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
                    for (item i : customer.getBasket().getOrder()) {
                        if (i.getItemName().equals(itemName1)) {
                            customer.getBasket().removeItem(i);
                            flag1 = true;
                            customer.setPayment(customer.getPayment()-i.getItemPrice());
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
                    for (item i : customer.getBasket().getOrder()) {
                        System.out.println(String.format("%20s %20d", i.getItemName(), i.getItemPrice()));
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
        return;
    }

    public void CustomerSide(Customer customer) throws InterruptedException {
        int choice = 0;

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
                    for (item i : menu) {
                        System.out.println(String.format("%20s %20d", i.getItemName(), i.getItemPrice()));
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
        return;
    }

    public static void main(String[] args) throws Exception {
        Kfc kfc = new Kfc();

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
                    kfc.customers.add(newCustomer);
                    id++;
                    kfc.CustomerSide(newCustomer);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
                    break;
            }
            {

            }
        } while (ch1 != 3);

    }

}
