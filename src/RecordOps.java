import java.util.*;
import java.util.Optional;

class City{

    private String  name;

    City(String name){
        this.name=name;
    }

    String getName(){
        return name;
    }
}

class Address{

    private Optional<City> city;

    Address(Optional<City> city){
        this.city=city;
    }
    Optional<City> getCity(){
        return city;
    }
        }

   class User {
    private Optional<Address> address;

    User(Optional <Address> address){
        this.address= address;
    }

    Optional<Address> getAddress(){
        return address;
    }
        }


public class RecordOps {
    public static void main(String[] args) {

        Optional<User> userOpt1 = Optional.of(
                new User(Optional.of(new Address(Optional.of(new City("Mumbai")
                )))));


        Optional<User> userOpt2 = Optional.of(new User(Optional.of(new Address(Optional.empty()
        ))));

        Optional<User> userOpt3 = Optional.of(new User(Optional.empty()));

        System.out.println(getCityName(userOpt1));
        System.out.println(getCityName(userOpt2));
        System.out.println(getCityName(userOpt3));


    }
    private static String getCityName(Optional<User> userOpt) {

        return userOpt
                .flatMap(User::getAddress)
                .flatMap(Address::getCity)
                .map(City::getName)
                .filter(name -> !name.isBlank())
                .map(String::toUpperCase)
                .orElse("CITY_NOT_FOUND");
    }



}


