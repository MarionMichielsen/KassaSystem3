package se.marion;
import java.util.*;

    public class RegisterSystem {
            List<Product> availableProducts = new ArrayList<Product>(); //sparar alla produkter man kan köpa
            Product banan = new Product("Bananer", "kilo", 10);
            Product broccoli = new Product("Broccoli", "stycken", 8);
            Product kaffe = new Product("Kaffe", "paket", 20);
            Receipt rec= new Receipt();
            String kommando;
            int produktID;
            int antal;
            String input;
            int choice = 3;
            boolean newCustomer = true;
            Date date = new Date();
            boolean buyMore = true;
            Integer customer = 0;
        
        public void AddInventory () { //lägger till produkter
            availableProducts.add(banan);
            availableProducts.add(broccoli);
            availableProducts.add(kaffe);
        }

        public int MainMenu(){  //skriver ut första menyn där man kan välja ny kund eller avsluta
            System.out.println("KASSA");
            System.out.println("1. Ny kund");
            System.out.println("0. Avsluta");

           input = System.console().readLine();
           
            do  {
               try { //kollar om man har matat in en int
                choice = Integer.parseInt(input);
            }
                catch (Exception e){ //kastar en exception om det inte var en int
                    System.out.println("Ogiltig inmatning. Välj 1 för ny kund. 0 för Avsluta.");
                    input = System.console().readLine();
                    continue;             
            }
                if (choice !=0 && choice != 1){ //om man har matat in en annan int än 1 eller 0
                    System.out.println("Ogiltig inmatning. Välj 1 för ny kund. 0 för Avsluta.");
                    input = System.console().readLine();
                    continue;
                 }
            }   
                while  (choice !=0 && choice != 1); //fortsätter frågar användaren att mata 1 eller 0 så länge han matar in nåt annat

            if (choice == 0){ //avslutar om man valde 0
                System.out.println("All the receipts from "+ date);
                newCustomer = false;
                buyMore = false;
            }
            else if (choice == 1){ //om man väljer ny kund
                System.out.println("KVITTO: " + date);
                customer++;
                buyMore = true;          
            }
            else { //om man skrev in en int men inte 1 eller 0 i första menyn:
                System.out.println("Ogiltig inmatning. Välj 1 för ny kund. 0 för Avsluta.");
                choice = Integer.parseInt(System.console().readLine());  
            }
            return customer;      
         } 
         
         public boolean BuyProducts(){ //metoden där man ska köpa nåt
           do {  System.out.println("Kommandon"); // be användaren att mata in nya kommando tills man väljer pay
            System.out.println("<produktid> <antal>");
            System.out.println("PAY");
            System.out.print("Kommando: ");
            kommando = System.console().readLine();

            if (kommando.equalsIgnoreCase("pay")){ //slutar fråga att mata in nya produkten
                buyMore= false;
            }
            else {  //än så länge man inte väljer pay:
                try { //man försöker skilja på kommandon. om det är ogiltig inmating kastas en exception
                    String[] varor = new String[2]; 
                    varor = kommando.split(" "); 
                    produktID = Integer.parseInt(varor[0]); 
                    antal = Integer.parseInt(varor[1]);
                    switch (produktID){
                        case (100): 
                            rec.AddProductToReceipt(banan, antal);
                            rec.addToHashMap (customer, rec.sReceipt);
                            break;
                        case (200):
                            rec.AddProductToReceipt(broccoli, antal);
                            rec.addToHashMap (customer, rec.sReceipt);
                            break;
                        case (300):
                            rec.AddProductToReceipt(kaffe, antal);
                            rec.addToHashMap (customer, rec.sReceipt);
                            break;
                        default:
                            System.out.println("invalid input. Enter 100, 200 or 300 to choose a product. Or Pay to pay");
                    }
                }
                catch (Exception G) { //om man har matat in nåt annat
                    System.out.println("Ogiltig inmatning.");
                    continue;
                }
                buyMore = true;    
            }
            } while (!kommando.equalsIgnoreCase("pay"));
            return buyMore;
        
            }
    }