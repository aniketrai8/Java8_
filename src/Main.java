import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class EmployeeOps {

    String name;
    double salary;

    EmployeeOps(String name, double salary){
        this.name= name;
        this.salary=salary;
    }
    public String getName(){
        return name;
    }
    public double getSalary(){
        return salary;
    }

    @Override
    public String toString(){
        return name +":"+ salary;
    }
}


public class Main {
    public static void main(String[] args) {
        List<EmployeeOps> employees = Arrays.asList(
           new EmployeeOps("Aniket",50000),new EmployeeOps("Rahul", 30000),new EmployeeOps("Rahul", 30000),new EmployeeOps("Priya", 65000),
                new EmployeeOps("Aniket", 50000),   // duplicate record
                new EmployeeOps("Sneha", 28000) //not be included in filtered list
        );



        long count = employees.stream()
                .distinct()
                .filter(e -> e.getSalary() >= 30000)
                .count();

        System.out.println("Total employees after filtering = " + count);

        List<EmployeeOps> filtered = employees.stream()
                .distinct()
                .filter(e -> e.getSalary() >= 30000)
                .collect(Collectors.toList());

        System.out.println("Filtered List:");
        filtered.forEach(System.out::println);
    }
}
