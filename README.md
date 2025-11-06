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
