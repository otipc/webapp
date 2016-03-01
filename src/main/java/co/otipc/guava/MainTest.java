package co.otipc.guava;



import com.google.common.base.*;
import com.google.common.collect.Ordering;
import com.rometools.rome.feed.rss.Item;

import java.util.Comparator;

/**
 * Created by cuichaoguo on 16/2/29.
 */
public class MainTest {

  public static void main(String[] args) {
    //    optional();
    optional2();


  }

  private static void optional() {

    Optional<Integer> possible = Optional.of(null);
    boolean isPresent = possible.isPresent(); // returns false
    System.out.println(isPresent);

  }

  private static void optional2() {

    Optional<Integer> possible = Optional.of(5);
    boolean isPresent = possible.isPresent(); // returns true
    int i = possible.get(); // returns 5
    System.out.println(i);

  }

  private static void test2() {

    boolean invalid = Strings.isNullOrEmpty(null);
    String name = Strings.emptyToNull(null);

    Objects.equal("a", "a"); //returns true
    Objects.equal(null, "a"); // returns false
    Objects.equal(null, null); // returns true

  }

  private static String test() {

    Splitter.on(',').split("foo, bar,,   qux,");

    Joiner joiner = Joiner.on("; ").skipNulls();
    // returns "Harry; Ron; Hermione
    return joiner.join("Harry", null, "Ron", "Hermione");


//    Ordering<Item> ordering = Ordering.from();

//    return Objects.hashCode("", "", "");



  }



}
