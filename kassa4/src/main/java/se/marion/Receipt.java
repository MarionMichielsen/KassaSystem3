package se.marion;

import java.util.*;

public class Receipt {

    List<Integer> toPay = new ArrayList<Integer>();
    ArrayList<String> receiptCustomer = new ArrayList<String>();
    HashMap<Integer, String> allReceipts = new HashMap<Integer, String>();
    String sReceipt;

    public String buildString(){ //skriver om arrayen med kundkvittot om till en string , samt skriver ut den 
        StringBuilder sb = new StringBuilder();
        for (String s : receiptCustomer) {
            sb.append(s);
            sb.append("\n");
        }
        sReceipt = sb.toString();
        System.out.println(sReceipt);
        return sReceipt;
    }

    public void addToHashMap(Integer customer, String sReceipt){ //sparar kundens kvitto i en hashmap med alla kvitto
        allReceipts.put(customer, sReceipt);
    }
    public void printReceipt(int customer){   //skriver ut kvittot från denna kund
        System.out.println(sReceipt);
    }

    public void printAllReceipts(int customer){ //skriver ut alla kvitto från samma dag
        for (Integer key: allReceipts.keySet()){
            System.out.println(key +" = "+allReceipts.get(key));
      }
}
 
    public void howMuchToPay(){  // räknar ut och skriver ut totalbeloppet för 1 kund
        Integer total = 0;
        for ( Integer pay: toPay){
            total += pay;
        }
        System.out.println("Total amount to pay: "+ total);
    }
    
    public void AddProductToReceipt(Product p, int antal) { //lägger till det man köpte till array receiptCustomer, och gör en sträng av det. sparar också totalen i toPay
        String sAntal = String.valueOf(antal)+" ";
        int total = antal*p.price;
        toPay.add(total);
        String sPris = String.valueOf(p.price)+" = ";
        String name = p.name+ " * ";
        String typ = p.typ+ " ";
        String sTotal = String.valueOf(total);
        String kvitto = sAntal.concat(typ).concat(name).concat(sPris).concat(sTotal);
        receiptCustomer.add(kvitto);
        buildString();
    }
}
