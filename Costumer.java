import java.util.ArrayList;
public class Costumer {
    
    public static class Customer{
        Address ShippingAddress = new Address();
        Address BillingAddress = new Address();
        
    }
    public static class Address{
        String streetAddress = "";
        String city = "";
        String state = "";
        String zipCode = "";
    }
    public static class Item{
        String name;
        int price;
    }
    public static class Quantity{
        Item item = new Item();
        int quantity;
        public int  TotalPrice(){
            return item.price*quantity;
        }
    }
    
    public static class Invoice{
        ArrayList<Quantity> list = new ArrayList();
        int paymentRecieved;
        public int StillDue(){
            int sum=0;
            for(Quantity i : list){
                sum+=i.TotalPrice();
            }
            return sum - paymentRecieved ;
        }
    }
    
    public static void main(String Args[]){
        Customer customer = new Customer();
        customer.BillingAddress.streetAddress="Kolokotrwni";
        customer.BillingAddress.city="Lamia";
        customer.BillingAddress.state="Greece";
        customer.BillingAddress.zipCode="35100";
        customer.ShippingAddress.streetAddress="Karaiskaki";
        customer.ShippingAddress.city="Lefkada";
        customer.ShippingAddress.state="Greece";
        customer.ShippingAddress.zipCode="31100";
        
        
        Quantity turi = new Quantity();
        turi.item.name="turi";
        turi.item.price=2;
        turi.quantity=4;
        
        Quantity gala = new Quantity();
        gala.item.name="gala";
        gala.item.price=2;
        gala.quantity=4;
        
        Invoice invoice = new Invoice();
        invoice.list.add(turi);
        invoice.list.add(gala);
        
        invoice.paymentRecieved=5;
        invoice.StillDue();
    }
}
