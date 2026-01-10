package com.ardent.backend.practice;

import org.jspecify.annotations.NullMarked;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice {


    public static void main(String args[]){
//
//        List<String> list = Arrays.asList("item1" , "item2" , "item3");
//        System.out.println(list);
//        list.stream();
//        System.out.println(list.stream().count());
//
//        Stream<Integer> integerStream = Stream.of(1, 2, 3);
//        System.out.println(integerStream);
//
//        Stream.iterate(10 , (n)->{return n+1;}).limit(100).count();
//
//        Stream.iterate(10 ,n->n+1).limit(100);
//
//
//
//      List<Integer> myList = Arrays.asList(1,2,3,4,5,6,7,8,9,0, 10, 12 , 14);
//
//        //finding the even numbers.
//
//
//        List<Integer> myFilteredList = myList.stream().filter((x) -> {
//            return x % 2 == 0 ;
//        }).collect(Collectors.toList());
//
//
//        System.out.println(myFilteredList);
//
//
//        List<Integer> filteredListDividedBy2 = myFilteredList.stream().map(x -> x / 2).collect(Collectors.toList());
//
//        System.out.println(filteredListDividedBy2);

//        Remove the duplicate characters from the integer

//        Integer[] arr = {1, 24, 23 , 1 , 2  , 23 , 23};
//
//         List<Integer> collect = Arrays.stream(arr).distinct().collect(Collectors.toList());
//        System.out.println(collect);
//
//        List<String> list = Arrays.asList("ade", "advr", "wert", "adfa");
//
////        sort them on the basis of length of the word
//
//        List<String> collect1 = list.stream()
//                .sorted((a, b) -> a.length() - b.length())
//                .collect(Collectors.toList());
//
//        System.out.println(collect1);
//
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//
//        List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
//        System.out.println(evenNumbers);
//

////        CONVERT TO SQUARE AND COLLECT AS LIST
//
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//
//        List<Integer> squareNumbers =  numbers.stream().map(x -> x*x).collect(Collectors.toList());
//        System.out.println(squareNumbers);

////        FIND THE EVEN NUMBERS FROM THE LIST AND RETURN THE SQUARE OF THEM
//
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//
//        List<Integer> evenSquaredNumber = numbers.stream().filter(x -> x % 2 == 0).map(x -> x * x).collect(Collectors.toList());
//        System.out.println(evenSquaredNumber);


//        // Create a list that contains only the names that start with the letter 'A', converted to uppercase, and print the result.
//        List<String> names = Arrays.asList("Shrey", "Aman", "Ankit", "Rohit", "Ajay");
//
//        List<String> filteredWord = names.stream()
//                .filter(word -> word.charAt(0) == 'A')
//                .map(word -> word.toUpperCase())
//                .collect(Collectors.toList());
//        System.out.println(filteredWord);


//        From the list:
//
//        Find the maximum number
//
//        Print it

//        List<Integer> numbers = Arrays.asList(3, 7, 2, 9, 1, 5);
////        int num = numbers.stream().max((a , b) -> a - b).get();
////        System.out.println(num);
//
//
//        Integer i = numbers.stream().reduce((a, b) -> a + b).get();
//        System.out.println(i);

//        List<String> names = Arrays.asList("Java", "Spring", "Hibernate", "SQL");
//        String s = names.stream().reduce((a, b) -> a + ", " + b).get();
//        System.out.println(s);


//        List<Integer> numbers = Arrays.asList(5, 12, 3, 12, 5, 7, 3);
//        System.out.println(numbers.stream().distinct().collect(Collectors.toList()));
//
//        List<String> words = Arrays.asList("apple", "banana", "avocado", "cherry", "apricot");
//
//        System.out.println(words.stream().filter(a -> a.charAt(0) == 'a').sorted().collect(Collectors.toList()));


//            List<Integer> numbers = Arrays.asList(4, 9, 2, 7, 5);
//
////        List<Integer> numbers = Arrays.asList(1, 3, 5, 7, 8);
//
////        System.out.println(numbers.stream().allMatch(a -> a % 2 == 0));
//        System.out.println(numbers.stream().filter(x -> x>6).limit(1).collect(Collectors.toList()).get(0));
//
//
//
//
//
////        numbers = Arrays.asList( 2, 9,  7, 5);
////        System.out.println(numbers.stream().filter(x->x%2==0).findFirst().orElse(-1));
//
//
//        List<String> words = Arrays.asList("java", "spring", "boot", "api");
//
//        System.out.println(words.stream().map(word -> word.toUpperCase()).reduce((a , b) -> a + " | " + b).get());


        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");


        Map<String , Long> resultMap = words.stream().collect(Collectors.groupingBy(word -> word , Collectors.counting()));
        System.out.println(resultMap);

        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 3, 4);

        System.out.println(numbers.stream().collect(Collectors.groupingBy(number -> number , Collectors.counting())));

         words = Arrays.asList("java", "spring", "java", "boot", "spring", "java");

         Map<String , Long> freqMap = words.stream().collect(Collectors.groupingBy(word -> word , Collectors.counting()));

        List<String> collect = freqMap.keySet().stream().filter(word -> freqMap.get(word) > 1).collect(Collectors.toList());
        System.out.println(collect);


    }
}
