package se.marion;
import java.util.*;

  public final class App {
   private App(){

   }
    public static void main(String []args){
      RegisterSystem r = new RegisterSystem();
      r.AddInventory();
    
      while (r.newCustomer){
        r.MainMenu();

        if (r.buyMore){
          r.BuyProducts(); }
        if (r.newCustomer){
          r.rec.printReceipt(r.customer);
          r.rec.howMuchToPay();
          r.rec.receiptCustomer.clear();
          r.rec.toPay.clear();
        }
      }
      r.rec.printAllReceipts(r.customer);
    }
}
        