public class Customer {
    private String name;
    private String contactNo;
    private Basket basket;
    private long payment=0;

    public Customer(Basket basket, String name, String contactNo) {
        this.basket = basket;
        this.name = name;
        this.contactNo = contactNo;
    }

    public String getName() {
        return name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setPayment(long payment) {
        this.payment = payment;
    }

    public long getPayment() {
        return payment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

}
