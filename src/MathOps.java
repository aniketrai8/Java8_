import java.util.*;
import java.util.stream.*;

public class MathOps {
    public static void main(String[] args){
        List<Integer> numbers= Arrays.asList(2,3,4,8,9,11);
        //method for finding sum of odd term
        int sum= numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Sum of Odd terms= "+sum);

        //Method to find odd term
        List<Integer>oddNumbers= numbers.stream()
                .filter(n->n%2!=0)
                .collect(Collectors.toList());
        System.out.println("Odd Integer are "+oddNumbers);
       //Method to find even terms
        List<Integer>evenNumber = numbers.stream()
                .filter(n->n%2==0)
                .collect(Collectors.toList());
        System.out.println("Even Numbers "+evenNumber);

        List<Integer>primeNumber = numbers.stream()
                .filter(MathOps::isPrime)
                .collect(Collectors.toList());
        System.out.println("Prime Numbers are "+primeNumber);




    }

    private static boolean isPrime(int num){
        if (num<=1) return false;
        return IntStream.rangeClosed(2, (int)Math.sqrt(num))
                .allMatch(n -> num % n != 0);
    }

}
