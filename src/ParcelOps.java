import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import static java.util.Arrays.stream;

class Item {
    private String name;
    private double price;


    Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    String getName() {
        return name;
    }

    Double getPrice() {
        return price;

    }
}

    class Location{
        private Optional<List<Item>> items;

        Location(Optional<List<Item>>items){
            this.items=items;
        }
        Optional<List<Item>>getItems(){
            return items;
        }
    }


    class Usr{
    private Optional<Location> location;

    Usr(Optional<Location>location){
     this.location =location;
        }

        Optional<Location>getLocation(){
        return location;
        }
    }





public class ParcelOps {

    public static void main(String [] args){

        List<Item> userItem = List.of(
                new Item("Laptop",6000),
                new Item("Mouse",4000),
                new Item("Headphones", 1500),
                new Item("Keyboard", 700)
        );

                Optional<Usr> userOpt = Optional.of(
                        new Usr(Optional.of(new Location(Optional.of(userItem))))
                );

                Predicate<Item> priceGreaterThan3000 = item->item.getPrice()>3000; //will give price where condition is true
                Function<Item,String> toUpper = item ->item.getName().toUpperCase(); //helps performs one form of data to another form of data
                Consumer<String> printer = itemName->System.out.println("Item: "+itemName);
                Supplier<String>fallback =()->"No Item Found";

                double finalResult = userOpt.flatMap(Usr::getLocation)
                        .flatMap(Location::getItems)
                        .stream()
                        .flatMap(List::stream)
                        .map(Item::getPrice)
                        .reduce(0.0,(a,b)->a+b);

    System.out.println("Total Price of all Items = " + finalResult);
}
}