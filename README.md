# Java8_
Contains a mix of learnings from the best Repos and Tutorials prersent spanned over the internet. Focusing on Lamba Expresion , Stream APIs, Data and Time additionality in JAVA 8

### JAVA 8 Lambda Expression ->
```
public static void main(String[] args){
  List<String> names= Arrays.asList("Brijesh","Aniket","Koushikh");
 Collections.sort(names, new Comparator<String>() {
    public int compare(String a, String b) {
       return a.compareTo(b);
});
```

### @FunctionalInterface
- It is a recommended practise that all Functional Interface have an Informative @FunctionalInterface Annotation. That communicates the purpose of the the interface, and also allows the compiler to generate an error if the annoted class iteerface does not satisfy the condition.
- An interface is a single abstract method is a functional interface, and its implemeneted may be treated as lambda expression.
- 
<b>In Java 8 </b>
```
public static void main (String [] args){
 List<String> names= Arrays.asList("Brijesh","Aniket","Koushik");
  names.sorr((a,b) -> a.comapreTo(b));
```
<I> List.sort(Comparator<? super E> c) was introduced in Java 8 as a default method in the List interface. </I>
<I> List.sort() delegates to Collections.sort(); </I>

<U>For Loops in Newer Versions</U>
* JAVA 5
  ```
  public static void main(String [] args){
    List<String> names= Arrays.asList("Brijesh","Aniket","Koushik");
    for(String n: names){
       S.O.T
  }
  }
  ```
 * JAVA 8
   ```
    public static void main(String [] args){
    List<String> names= Arrays.asList("Brijesh","Aniket","Koushik");
   names.forEach( n-> Sytem.out.println(" "));
   
   }

### Built in Java Functional Interface
* Java has a set of pre defined functional interface supported by <ins>java.util.function </ins>
* <b> Predicate </b> -> Tests a condition and returns a boolean
  - Predicate is used for decision making
  - It is used to decide what stays in the pipeline
  - Streams automatically appply without creating a copy in the collection
  - A Typical use of the Predicate lambda is to filter a collection of values.
```
List<String> names= Arrays.asList("Angela","Aaron","Bob","Clarie");

List<string> namesWithA  = names.stream()
      .filter(name -> name.startsWith("A"))
      .collect(Collector.toList());
```
* <b> Consumer </b> -> Consume a value and performs an operation but returns nothing
  - Is the terminal stage of an operation
  - Typically printing, saving, logging
  - There are also specialized versions of The consumer - DoubleConsumer, IntConsumer and LongConsumer - that recieves primitive values as arguments.
 
    ```
    Map<String,Integer> ages= new HasHmap<>();
    ages.put("John",24);
    ages.put("Freddy",31);
    ages.put("Johanes", 33);

    ages.forEach((name,age)-> System.out.println(name+ "is" +age + "years old"));

    ```
  - 
* <b> Suplier </b> -> Suplies or Produces a an output , no input required
   - Suppliers come into play when you need to generate or provide values — often in stream sources or defaults.
   - 
* <b> Function </b> -> Takes one input and returns a result.
  - Deals with Transform logic
  - Used in Map(),flatMap() and collect()
 
* <b>Operators</b>
 - Operators are special cases of a function that recieves and returns the same value type. The Unary operator interface recives a single argument.
 - There are exists Binaryoperators which is mostly used as reduction operations.
```
List<Integer> values= Arrays.asList(3,4,5,6);

int sum = values.stream()
    .reduce(0, (i1,i2) -> i1+i2);

```
  


```
| Root Type         | Signature           | Return Type     | Typical Use           | Example Stream Op           |
| ----------------- | ------------------- | --------------- | --------------------- | --------------------------- |
| **Predicate<T>**  | `boolean test(T t)` | `boolean`       | Filter / Condition    | `filter()`                  |
| **Function<T,R>** | `R apply(T t)`      | Output value    | Transform / Map       | `map()`                     |
| **Consumer<T>**   | `void accept(T t)`  | None            | Action / Effect       | `forEach()`                 |
| **Supplier<T>**   | `T get()`           | Value generator | Data source / Default | `generate()`, `orElseGet()` |

```
### Thinking Pattern ->
```
| Goal                                        | Which Interface                           | Why                       | Example                                    |
| ------------------------------------------- | ----------------------------------------- | ------------------------- | ------------------------------------------ |
| You need to **check** a condition           | `Predicate<T>`                            | Returns boolean           | `filter(x -> x > 0)`                       |
| You need to **transform** data              | `Function<T,R>`                           | Maps T → R                | `map(String::length)`                      |
| You need to **perform an action**           | `Consumer<T>`                             | Executes logic, no return | `forEach(System.out::println)`             |
| You need to **generate** or **supply** data | `Supplier<T>`                             | No input, returns value   | `Stream.generate(() -> UUID.randomUUID())` |
| You need to **merge** two things            | `BinaryOperator<T>` / `BiFunction<T,U,R>` | Combines data             | `reduce(Integer::sum)`                     |
| You need to **compare** two things          | `BiPredicate<T,U>`                        | Boolean on two inputs     | `(x, y) -> x.equals(y)`                    |
```


* <ins><B> Optional <T> </b> </ins>
- Before Java8 developers has to carefully validate values because of the possiblity of throwing the NullPointerException.
- Java 8 Optional class to handle situation there was a possiblity of getting an NPE
- it can return a value of this object if this value is not a null.


  Ex- Here how to return an Optional with a speicfic value or an empty Optional. if the paramater is full
  ```
  
  Optional<String> optional = Optional.ofNullable(getString());
  ```
  Ex - Assume we have an object of type User that has a fields of Type Address with a street of type String and we need to return a value of the stret if it exists or a default value
  if the street is null.
  ```
  Optional<User> user= Optional.ofNullable(getUser())l
  String result = user
  .map(User:: getAddress)
  .map(Address:: getStreet)
  .orElse("not specified");
  ```

  ### Streams
  * One of the major new feathures in Java 8 was is the introduction of the Stream Functionality
  * It is cotained within the library - java.util.streams
  * A stream() dedault method is added to the collection Interface and allows xreating a Stream<T> using any collection as an element source
