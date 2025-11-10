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
* <b> Consumer </b> -> Consume a value and performs an operation but returns nothing
  - Is the terminal stage of an operation
  - Typically printing, saving, logging
  - 
* <b> Suplier </b> -> Suplies or Produces a an output , no input required
   - Suppliers come into play when you need to generate or provide values — often in stream sources or defaults.
   - 
* <b> Function </b> -> Takes one input and returns a result.
  - Deals with Transform logic
  - Used in Map(),flatMap() and collect()


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



  
