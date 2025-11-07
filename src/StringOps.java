import java.util.*;
import java.util.stream.*;


public class StringOps {

    public static void main (String [] args){
        Set<String> names= new HashSet <>(Arrays.asList("Aniket","Tanushree","Vaishanavi","Prasidh","Tanushree"));
        //Unique names
        System.out.println("Unique Names "+names);

        //Convert to Uppercase
        Set<String> upperNames = names.stream()
                .map(String::toUpperCase)
                        .collect(Collectors.toSet());
        System.out.println("Converted to UpperCase "+upperNames);

        Set<String> longNames = names.stream()
                .filter(name->name.length()>6)
                .collect(Collectors.toSet());
        System.out.println("Names above 6 characters "+longNames);

        List<String> sortedNames=names.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Sorted names are in the order "+names);

    }
}
