import java.util.*;
import java.util.Arrays.*;
import java.util.stream.Collectors;
import java.util.List;


 class Ops {
     private String itemName;
     private double itemPrice;


     Ops(String itemName, double itemPrice) {
         this.itemName = itemName;
         this.itemPrice = itemPrice;

     }

     public String getItemName() {
         return itemName;
     }

     public double getItemPrice() {
         return itemPrice;
     }
 }
    public  class TerminalOps{


        public static void main(String [] args){
            List<Ops> itemList = Arrays.asList(
                    new Ops ("Stationary",1000),
                    new Ops ("Bicycles", 2000),
                    new Ops ("Soaps",1500),
                    new Ops ("Tumblewares",200),
                    new Ops ("Choclates",500)

        );

            double totalAfterDiscount = itemList.stream()

                    .map(item-> new Ops (
                            item.getItemName(),
                            item.getItemPrice()*0.95
                    ))

                    .sorted(Comparator.comparing(Ops::getItemPrice))

                    .peek(item ->System.out.println(
                            item.getItemName()+" -> " + item.getItemPrice()
                    ))

                    .map(Ops::getItemPrice)
                    .reduce(0.0,Double::sum);

            System.out.println("\n Total price after 5% tax GST reduction = "+totalAfterDiscount);
    }

}
